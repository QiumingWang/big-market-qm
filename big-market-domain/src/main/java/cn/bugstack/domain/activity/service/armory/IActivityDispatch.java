package cn.bugstack.domain.activity.service.armory;

import java.util.Date;

/**
 * @className: IActivityDispatch
 * @description: 活动调度【扣减库存】
 * @author: qiuming
 * @date: 2024/5/18 15:25
 */
public interface IActivityDispatch {

    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     *
     * @param sku: 互动sku
     * @param endDateTime: 活动结束时间
     * @return boolean:
     */
    boolean subtractActivitySkuStock(Long sku, Date endDateTime);
}
