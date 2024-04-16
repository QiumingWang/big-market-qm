package cn.bugstack.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: RaffleFactorEntity
 * @author: qiuming
 * @description: 抽奖因子, 与用户对应
 * @date: 2024/4/11 13:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleFactorEntity {
    private String userId;
    private Long strategyId;
}
