package cn.bugstack.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: BehaviorType
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/23 11:56
 */
@Getter
@AllArgsConstructor
public enum BehaviorTypeVO {
    sign("sign", "日历签到"),
    openai_pay("openai_pay", "openai外部支付完成"),
    ;


    private final String code;
    private final String info;
}
