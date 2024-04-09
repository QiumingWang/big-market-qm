package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: StrategyAward
 * @author: qiuming
 * @description: 抽奖策略奖品明细配置，关于一些*概率*和*规则*等
 * @date: 2024/4/9 17:34
 */
@Data
public class StrategyAward {
    /**  */
    private long id;
    /** 自增ID */
    private long strategyId;
    /** 抽奖策略ID */
    private Integer awardId;
    /** 抽奖奖品ID - 内部流转使用 */
    private String awardTitle;
    /** 抽奖奖品标题 */
    private String awardSubtitle;
    /** 抽奖奖品副标题 */
    private Integer awardCount;
    /** 奖品库存总量 */
    private Integer awardCountSurplus;
    /** 奖品库存剩余 */
    private BigDecimal awardRate;
    /** 奖品中奖概率 */
    private String ruleModels;
    /** 规则模型，rule配置的模型同步到此表，便于使用 */
    private Integer sort;
    /** 排序 */
    private Date createTime;
    /** 创建时间 */
    private Date updateTime;
}
