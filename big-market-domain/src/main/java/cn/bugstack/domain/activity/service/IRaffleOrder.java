package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.model.entity.ActivityOrderEntity;
import cn.bugstack.domain.activity.model.entity.ActivityShopCartEntity;

/**
 * @className: IRaffleOrder
 * @description: 抽奖活动订单接口
 * @author: qiuming
 * @date: 2024/5/4 17:25
 */
public interface IRaffleOrder {

    /**
     * @description: 以用户ID和活动sku创建一笔订单
     * @param activityShopCartEntity: 活动SKU实体，通过sku领取活动
     * @return ActivityOrderEntity: 活动参与记录
     * @date: 2024/5/4 17:58
     */
    ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity);
}
