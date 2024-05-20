package cn.bugstack.trigger.api.dto;

import lombok.Data;

/**
 * @className: RaffleRequestDTO
 * @author: qiuming
 * @description: 抽奖请求参数：策略ID
 * @date: 2024/4/26 12:03
 */
@Data
public class RaffleStrategyRequestDTO {

    /** 抽奖策略ID */
    private Long strategyId;
}
