package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: RaffleStrategyRuleWeightRequestDTO
 * @description: 抽奖策略规则，权重配置，查询N次抽奖可解锁奖品范围，请求对象
 * @author: qiuming
 * @date: 2024/5/25 16:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleStrategyRuleWeightRequestDTO {
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
}
