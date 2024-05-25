package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className: RaffleStrategyRuleWeightResponseDTO
 * @description: 抽奖策略规则，权重配置，查询N次抽奖可解锁奖品范围，应答对象
 * @author: qiuming
 * @date: 2024/5/25 16:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleStrategyRuleWeightResponseDTO {
    // 权重规则配置抽奖次数
    private Integer ruleWeightCount;
    // 用户在一个活动下完成的总抽奖次数
    private Integer userActivityAccountTotalUserCount;
    // 当前权重可抽奖范围
    private List<StrategyAward> strategyAwardList;

    @Data
    public static class StrategyAward {
        // 奖品ID
        private Integer awardId;
        // 标题
        private String awardTitle;
    }
}
