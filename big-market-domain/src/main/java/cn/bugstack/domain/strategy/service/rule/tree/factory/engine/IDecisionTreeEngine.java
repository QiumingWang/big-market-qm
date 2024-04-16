package cn.bugstack.domain.strategy.service.rule.tree.factory.engine;

import cn.bugstack.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @className: IDecisionTreeEngine
 * @author: qiuming
 * @description: 规则树组合接口调用
 * @date: 2024/4/16 16:40
 */
public interface IDecisionTreeEngine {

    /**
     * @param userId:     用户ID
     * @param strategyId: 策略ID
     * @param awardId:    奖品ID
     * @return
     */
    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId);

}
