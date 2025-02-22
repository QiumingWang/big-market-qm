package cn.bugstack.domain.strategy.model.entity;

import lombok.Data;

/**
 * @className: RuleMatterEntity
 * @author: qiuming
 * @description: 规则实体无量，用于过滤规则的必要参数信息
 * @date: 2024/4/11 14:03
 */
@Data
public class RuleMatterEntity {
    // 对应一个user + strategy rule
    /** 用户ID */
    private String userId;
    /** 策略ID */
    private Long strategyId;
    /** 抽奖奖品ID【规则类型为策略，则不需要奖品ID】 */
    private Integer awardId;
    /** 抽奖规则类型【rule_random - 随机值计算、rule_lock - 抽奖几次后解锁、rule_luck_award - 幸运奖(兜底奖品)】 */
    private String ruleModel;
}
