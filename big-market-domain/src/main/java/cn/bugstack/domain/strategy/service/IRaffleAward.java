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

    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);
}
