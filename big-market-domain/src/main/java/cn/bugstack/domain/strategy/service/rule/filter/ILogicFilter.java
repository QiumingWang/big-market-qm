package cn.bugstack.domain.strategy.service.rule.filter;

import cn.bugstack.domain.strategy.model.entity.RuleActionEntity;
import cn.bugstack.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @className: ILogicFilter
 * @author: qiuming
 * @description: 抽奖规则策略结构
 * @date: 2024/4/11 13:59
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {
    RuleActionEntity<T> filter(RuleMatterEntity matter);
}
