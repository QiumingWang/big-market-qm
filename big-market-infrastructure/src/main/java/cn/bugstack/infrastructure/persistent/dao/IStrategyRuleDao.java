package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.StrategyRule;

import java.util.List;

/**
 * @className: IStrategyRuleDao
 * @author: qiuming
 * @description: 抽奖规则
 * @date: 2024/4/9 18:25
 */
public interface IStrategyRuleDao {
    List<StrategyRule> queryStrategyRuleList();
}
