package cn.bugstack.domain.strategy.service.rule.chain;

/**
 * @className: ILogicChainArmory
 * @author: qiuming
 * @description: XXX
 * @date: 2024/4/16 10:31
 */
public interface ILogicChainArmory {
    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);
}
