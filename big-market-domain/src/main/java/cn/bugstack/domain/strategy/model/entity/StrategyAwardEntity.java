package cn.bugstack.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @className: StrategyAwardEntity
 * @author: qiuming
 * @description: 抽奖奖品策略实体
 * @date: 2024/4/9 23:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardEntity {
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖奖品ID - 内部流转使用 */
    private Integer awardId;
    /** 抽奖奖品标题 */
    private String awardTitle;
    /** 奖品副标题 */
    private String awardSubTitle;
    /** 奖品库存总量 */
    private Integer awardCount;
    /** 奖品库存剩余 */
    private Integer awardCountSurplus;
    /** 奖品中奖概率 */
    private BigDecimal awardRate;

    /** 排序 */
    private Integer sort;
    /** 规则模型，rule配置的模型同步到此表，便于使用 */
    private String ruleModels;


}
