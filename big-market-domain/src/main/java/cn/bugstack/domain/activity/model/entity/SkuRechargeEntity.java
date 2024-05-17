package cn.bugstack.domain.activity.model.entity;

import lombok.Data;

/**
 * @className: SkuRechargeEntity
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/17 22:06
 */
@Data
public class SkuRechargeEntity {
    /** 用户ID */
    private String userId;
    /** 商品SKU activity + activity count */
    private Long sku;
    /** 业务单号 */
    private String outBusinessNo;
}
