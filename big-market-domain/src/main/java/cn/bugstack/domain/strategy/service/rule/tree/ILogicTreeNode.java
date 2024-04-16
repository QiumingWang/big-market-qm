package cn.bugstack.domain.strategy.service.rule.tree;

import cn.bugstack.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @className: ILogicTreeNode
 * @author: qiuming
 * @description: 规则树接口
 * @date: 2024/4/16 16:25
 */
public interface ILogicTreeNode {
    /**
     * @param userId: 用户ID
     * @param strategyId: 策略ID
     * @param awardId: 奖品ID
     * @return void:
     */
    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId);
}
