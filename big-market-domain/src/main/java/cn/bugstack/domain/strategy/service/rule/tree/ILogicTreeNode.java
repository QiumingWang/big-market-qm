package cn.bugstack.domain.strategy.service.rule.tree;

import cn.bugstack.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

import java.util.Date;

/**
 * @className: ILogicTreeNode
 * @author: qiuming
 * @description: 规则树接口
 * @date: 2024/4/16 16:25
 */
public interface ILogicTreeNode {
    /**
     * 责任链接口
     *
     * @param userId      : 用户ID
     * @param strategyId  : 策略ID
     * @param awardId     : 奖品ID
     * @param ruleValue
     * @param expiredDate
     * @return void:
     */
    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue, Date expiredDate);
}
