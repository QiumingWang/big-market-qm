package cn.bugstack.domain.strategy.service;

import cn.bugstack.domain.strategy.model.entity.RaffleAwardEntity;
import cn.bugstack.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @className: IRaffleStrategy
 * @author: qiuming
 * @description: 抽奖策略接口
 * @date: 2024/4/11 13:39
 */
public interface IRaffleStrategy {
    /*
     * @param raffleFactorEntity: 抽奖因子「用户，对应策略」
     * @return RaffleAwardEntity: 抽奖奖品
     * @author qiuming
     * @description
     * @date 2024/4/11 13:55
     */
    RaffleAwardEntity perform(RaffleFactorEntity raffleFactorEntity);
}
