package cn.bugstack.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @className: StrategyAwardStockKeyVO
 * @author: qiuming
 * @description: 策略奖品库存Key标识值对象
 * @date: 2024/4/17 10:52
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardStockKeyVO {
    /**策略ID*/
    private Long strategyId;
    /**奖品ID*/
    private Integer awardId;
}
