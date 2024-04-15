package cn.bugstack.domain.strategy.model.entity;

import cn.bugstack.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import lombok.*;

/**
 * @className: RuleActionEntity
 * @author: qiuming
 * @description: XXX
 * @date: 2024/4/11 23:37
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleActionEntity <T extends RuleActionEntity.RaffleEntity> {

    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    private String ruleModel;
    // 泛型值
    private T data;

    // 两个过滤规则：抽奖前和抽奖中
    static public class RaffleEntity {
    }


    // 抽奖之前
    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static public class RaffleBeforeEntity extends RaffleEntity {
        /** 策略ID */
        private Long strategyId;

        /** 权重值Key；用于抽奖时可以选择权重抽奖。*/
        private String ruleWeightValueKey;

        /** 奖品ID；*/
        private Integer awardId;
    }

    // 抽奖中
    static public class RaffleCenterEntity extends RaffleEntity {
    }

}
