package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.bugstack.domain.activity.model.entity.*;
import cn.bugstack.domain.activity.repository.IActivityRepository;
import cn.bugstack.domain.activity.service.rule.IActionChain;
import cn.bugstack.domain.activity.service.rule.factory.DefaultActivityChainFactory;
import cn.bugstack.types.enums.ResponseCode;
import cn.bugstack.types.exception.AppException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @className: AbstractRaffleActivity
 * @description: 抽奖活动抽象类，定义标准的流程
 * @author: qiuming
 * @date: 2024/5/4 18:01
 */
@Slf4j
public abstract class AbstractRaffleActivity extends RaffleActivitySupport implements IRaffleOrder {

    public AbstractRaffleActivity(DefaultActivityChainFactory defaultActivityChainFactory, IActivityRepository activityRepository) {
        super(defaultActivityChainFactory, activityRepository);
    }

    @Override
    public ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity){
        // 1. 通过sku查询活动信息
        ActivitySkuEntity activitySkuEntity = activityRepository.queryActivitySku(activityShopCartEntity.getSku());
        // 2. 查询活动信息
        ActivityEntity activityEntity = activityRepository.queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());
        // 3. 查询次数信息（用户在活动上可参与的次数
        ActivityCountEntity activityCountEntity = activityRepository.queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());

        log.info("查询结果: {} {} {}", JSON.toJSONString(activitySkuEntity), JSON.toJSONString(activityEntity), JSON.toJSONString(activityCountEntity));

        return ActivityOrderEntity.builder().build(); // 创建一个空类？
    }

    @Override
    public String createSkuRechargeOrder(SkuRechargeEntity skuRechargeEntity) {
        // 1. 参数教研
        String userId = skuRechargeEntity.getUserId();
        Long sku = skuRechargeEntity.getSku();
        String outBusinessNo = skuRechargeEntity.getOutBusinessNo();
        if (null == sku || StringUtils.isBlank(userId) || StringUtils.isBlank(outBusinessNo)) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(),
                    ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        // 2. 查询基础信息
        // 2.1 查询sku基础活动信息
        ActivitySkuEntity activitySkuEntity = querySkuEntity(sku);
        // 2.2 查询活动信息
        ActivityEntity activityEntity= queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());
        // 2.3查询次数信息（用户在活动上可参与的次数）
        ActivityCountEntity activityCountEntity = queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());

        // 3. 校验活动规则
        IActionChain actionChain = this.defaultActivityChainFactory.openActionChain();
        boolean success = actionChain.action(activitySkuEntity, activityEntity, activityCountEntity);

        // 4. 构建订单聚合对象
        CreateOrderAggregate createOrderAggregate = buildOrderAggregate(skuRechargeEntity, activitySkuEntity, activityEntity, activityCountEntity);

        // 5. 保存订单，返回单号
        doSaveOrder(createOrderAggregate);

        return createOrderAggregate.getActivityOrderEntity().getOrderId();
    }

    protected abstract void doSaveOrder(CreateOrderAggregate createOrderAggregate);

    protected abstract CreateOrderAggregate buildOrderAggregate(SkuRechargeEntity skuRechargeEntity, ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);

}


