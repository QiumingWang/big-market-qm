package cn.bugstack.domain.activity.service.rule.impl;

import cn.bugstack.domain.activity.model.entity.ActivityCountEntity;
import cn.bugstack.domain.activity.model.entity.ActivityEntity;
import cn.bugstack.domain.activity.model.entity.ActivitySkuEntity;
import cn.bugstack.domain.activity.model.valobj.ActivityStateVO;
import cn.bugstack.domain.activity.service.rule.AbstractActionChain;
import cn.bugstack.types.enums.ResponseCode;
import cn.bugstack.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @className: ActivityBaseActionChain
 * @description: 活动会泽过滤【日期，状态】
 * @author: qiuming
 * @date: 2024/5/17 22:41
 */
@Slf4j
@Component("activity_base_action")
public class ActivityBaseActionChain extends AbstractActionChain {
    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity,
                          ActivityEntity activityEntity,
                          ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-基础信息【有效期、状态】校验开始。");
        // 校验：活动状态
        if (!ActivityStateVO.open.equals(activityEntity.getState())) {
            throw new AppException(ResponseCode.ACTIVITY_STATE_ERROR.getCode(), ResponseCode.ACTIVITY_STATE_ERROR.getInfo());
        }
        // 校验：活动日期。「开始时间 <- 当前时间 -> 结束时间」
        Date currentDate = new Date();
        if (activityEntity.getBeginDateTime().after(currentDate) || activityEntity.getEndDateTime().before(currentDate)) {
            throw new AppException(ResponseCode.ACTIVITY_DATE_ERROR.getCode(), ResponseCode.ACTIVITY_DATE_ERROR.getInfo());
        }
        // 校验：活动库存
        if (activitySkuEntity.getStockCountSurplus() <= 0) {
            throw new AppException(ResponseCode.ACTIVITY_SKU_STOCK_ERROR.getCode(), ResponseCode.ACTIVITY_SKU_STOCK_ERROR.getInfo());
        }

        return next().action(activitySkuEntity, activityEntity, activityCountEntity);
    }
}
