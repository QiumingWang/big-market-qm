package cn.bugstack.domain.strategy.service.armory;

/**
 * @className: IStrategyDispatch
 * @author: qiuming
 * @description: 抽奖策略调度
 * @date: 2024/4/10 22:13
 */
public interface IStrategyDispatch {

    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

    Boolean subtractionAwardStock(Long strategyId, Integer awardId);
}
