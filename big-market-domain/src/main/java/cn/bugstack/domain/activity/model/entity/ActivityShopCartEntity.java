package cn.bugstack.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: ActivityShopCartEntity
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/4 17:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityShopCartEntity {
    /** 用户ID */
    private String userID;
    /** 商品SKU - activity + activity count */
    private Long sku;
}
