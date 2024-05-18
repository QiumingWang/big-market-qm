package cn.bugstack.domain.activity.service.quota.rule.factory;

import cn.bugstack.domain.activity.service.quota.rule.IActionChain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @className: DefaultActivityChainFactory
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/17 22:49
 */
@Service
public class DefaultActivityChainFactory {
    private final IActionChain actionChain;

    public DefaultActivityChainFactory(Map<String, IActionChain> actionChainGroup) {
        actionChain = actionChainGroup.get(ActionModel.activity_base_action.code);
        IActionChain next =  actionChainGroup.get(ActionModel.activity_sku_action.code);
        actionChain.appendNext(next);
    }


    public IActionChain openActionChain() { return this.actionChain; }

    @Getter
    @AllArgsConstructor
    public enum ActionModel {
        activity_base_action("activity_base_action", "活动时间、状态校验"),
        activity_sku_action("activity_sku_stock_action", "活动库存校验"),
        ;

        private final String code;
        private final String info;
    }

}


