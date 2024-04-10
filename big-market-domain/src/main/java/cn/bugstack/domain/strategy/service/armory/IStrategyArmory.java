package cn.bugstack.domain.strategy.service.armory;

/**
 * @className: IStrategyArmory
 * @author: qiuming
 * @description: 策略装配库，负责初始化策略计算
 * @date: 2024/4/9 23:32
 */
public interface IStrategyArmory {
    boolean assembleLotteryStrategy(Long StrategyId);

    Integer getRandomAwardId(Long strategyId);
}
