package cn.bugstack.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @className: StrategyAwardRuleModelVO
 * @author: qiuming
 * @description: 抽奖策略规则之对象，
 * @date: 2024/4/14 23:41
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {
    private String ruleModels;

}
