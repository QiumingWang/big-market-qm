package cn.bugstack.domain.strategy.service.rule.chain;


/**
 * @className: ILogicChain
 * @author: qiuming
 * @description: 抽奖策略规则责任链接口
 * @date: 2024/4/16 10:20
 */
public interface ILogicChain extends ILogicChainArmory {

    /**
     * @param userId:
     * @param strategyId:
     * @return Integer
     * @author: qiuming
     * @description: 责任链接口
     * @date: 2024/4/16 10:24
     */
    Integer logic(String userId, Long strategyId);

}
