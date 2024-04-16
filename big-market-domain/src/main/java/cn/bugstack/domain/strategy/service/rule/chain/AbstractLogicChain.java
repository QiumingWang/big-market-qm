package cn.bugstack.domain.strategy.service.rule.chain;

/**
 * @className: AbstractLogicChain
 * @author: qiuming
 * @description: XXX
 * @date: 2024/4/16 10:27
 */
public abstract class AbstractLogicChain implements ILogicChain {

    private ILogicChain next;

    protected abstract String ruleModel();


    /**
     * @param next: 下一个责任链表
     * @return next: 原来节点的下一个值
     */
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    @Override
    public ILogicChain next() {
        return next;
    }
}
