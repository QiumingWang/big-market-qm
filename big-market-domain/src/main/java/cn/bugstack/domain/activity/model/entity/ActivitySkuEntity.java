package cn.bugstack.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: ActivitySkuEntity
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/4 17:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySkuEntity {
    /** 商品sku - 把每一个组合当做一个商品 */
    private Long sku;
    /** 活动ID */
    private Long activityId;
    /** 活动个人参与次数ID */
    private Long activityCountId;
    /** 商品库存 */
    private Integer stockCount;
    /** 剩余库存 */
    private Integer stockCountSurplus;
}
