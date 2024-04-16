package cn.bugstack.domain.strategy.model.valobj;

import cn.bugstack.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import cn.bugstack.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: StrategyAwardRuleModelVO
 * @author: qiuming
 * @description: 抽奖策略规则之对象，
 * @date: 2024/4/14 23:41
 */
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {
    private String ruleModels;

    public String[] raffleCenterRuleModelList() {
        List<String> ruleModelList = new ArrayList<>();
        String[] ruleModelValues = ruleModels.split(Constants.SPLIT);
        for (String ruleModel: ruleModelValues) {
            if (DefaultLogicFactory.LogicModel.isCenter(ruleModel)) {
                ruleModelList.add(ruleModel);
            }
        }
        return ruleModelList.toArray(new String[0]);
    }
}
