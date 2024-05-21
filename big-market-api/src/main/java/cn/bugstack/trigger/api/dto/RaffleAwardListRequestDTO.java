package cn.bugstack.trigger.api.dto;

import lombok.Data;

/**
 * @className: RaffleAwardListRequestDTO
 * @author: qiuming
 * @description: 抽奖结果请求
 * @date: 2024/4/26 11:57
 */
@Data
public class RaffleAwardListRequestDTO {
    /** 抽奖策略ID */
    @Deprecated
    private Long strategyId;
    /** 活动ID */
    private Long activityId;
    /** 用户ID */
    private String userId;
}
