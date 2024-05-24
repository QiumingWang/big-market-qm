package cn.bugstack.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: RebateTypeVO
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/24 19:13
 */
@Getter
@AllArgsConstructor
public enum RebateTypeVO {
    SKU("sku", "活动库存充值商品"),
    CREDIT("credit", "用户活动积分"),
    ;

    private final String code;
    private final String info;
}
