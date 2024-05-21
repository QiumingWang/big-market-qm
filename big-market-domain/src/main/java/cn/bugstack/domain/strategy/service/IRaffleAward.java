package cn.bugstack.domain.strategy.service;

import cn.bugstack.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @className: IRaffleAward
 * @description: 策略奖品接口
 * @author: qiuming
 * @date: 2024/5/2 17:08
 */
public interface IRaffleAward {

    /**
     * 使用策略查询 奖品信息
     *
     * @param strategyId: 策略ID
     * @return List<StrategyAwardEntity>: 奖品信息
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);

    /**
     * 使用活动查询 奖品信息
     * @param activityId: 活动ID
     * @return List<StrategyAwardEntity>: 奖品信息
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardListByActivityId(Long activityId);

}
