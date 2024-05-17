package cn.bugstack.domain.activity.service.rule;

/**
 * @className: IActionChainArmory
 * @description: 抽奖动作责任链装配
 * @author: qiuming
 * @date: 2024/5/17 22:34
 */
public interface IActionChainArmory {
    IActionChain next();

    IActionChain appendNext(IActionChain next);
}
