package cn.bugstack.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: OrderStateVO
 * @description: 订单状态值对象
 * @author: qiuming
 * @date: 2024/5/4 17:30
 */
@Getter
@AllArgsConstructor
public enum OrderStateVO {

    completed("completed", "完成"); // 子对象初始化

    private final String code;
    private final String desc;
}
