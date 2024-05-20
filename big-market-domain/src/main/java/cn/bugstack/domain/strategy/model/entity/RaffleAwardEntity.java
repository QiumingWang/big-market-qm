package cn.bugstack.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: RaffleAwardEntity
 * @author: qiuming
 * @description: 抽奖奖品实体，对应奖品发放
 * @date: 2024/4/11 13:47
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardEntity {
    /** 抽奖奖品ID - 内部流转使用 */
    private Integer awardId;
    /** 奖品配置信息 */
    private String awardConfig;
    /** 奖品标题 名称 */
    private String awardTitle;
    /** 奖品顺序号 */
    private Integer sort;
}
