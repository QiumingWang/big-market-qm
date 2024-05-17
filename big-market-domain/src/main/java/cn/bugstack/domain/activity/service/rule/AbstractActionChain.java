package cn.bugstack.domain.activity.service.rule;

/**
 * @className: AbstractActionChain
 * @description: 下单责任链抽象类
 * @author: qiuming
 * @date: 2024/5/17 22:37
 */
public abstract class AbstractActionChain implements IActionChain {
    private IActionChain next;

    @Override
    public IActionChain next() {
        return next;
    }

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }

}
