package cn.bugstack.domain.strategy.service.rule.tree.factory;

import cn.bugstack.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.bugstack.domain.strategy.model.valobj.RuleTreeVO;
import cn.bugstack.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.bugstack.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import cn.bugstack.domain.strategy.service.rule.tree.factory.engine.impl.DecisionTreeEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @className: DefaultTreeFactory
 * @author: qiuming
 * @description: 规则工厂
 * @date: 2024/4/16 16:34
 */
@Service
public class DefaultTreeFactory {
    // 这里也可以加@Resource注解, 注入logicTreeNode
    private final Map<String, ILogicTreeNode> logicTreeNodeGroup;

    public DefaultTreeFactory(Map<String, ILogicTreeNode> logicTreeNodeGroup) {
        this.logicTreeNodeGroup = logicTreeNodeGroup;
    }

    /**
     * @param ruleTreeVO:  规则树根节点相关信息
     * @return IDecisionTreeEngine:  规则树
     * @description: 构建一颗规则树
     */
    public IDecisionTreeEngine openLogicTree(RuleTreeVO ruleTreeVO) {
        // 工厂模式只负责生产规则
        return new DecisionTreeEngine(logicTreeNodeGroup, ruleTreeVO);
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO {
        /** 抽奖奖品ID - 内部流转使用 */
        private Integer awardId;
        /** 抽奖奖品规则 */
        private String awardRuleValue;
    }

    /** 决策树动作实体 */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeActionEntity {
        private RuleLogicCheckTypeVO ruleLogicCheckType;
        private StrategyAwardVO strategyAwardVO;
    }
}
