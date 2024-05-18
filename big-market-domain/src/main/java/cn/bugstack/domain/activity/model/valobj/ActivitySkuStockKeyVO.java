package cn.bugstack.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: ActivitySkuStockKeyVO
 * @description: 活动sku库存 key 值对象
 * @author: qiuming
 * @date: 2024/5/18 15:50
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySkuStockKeyVO {
    /** 商品sku */
    private Long sku;
    /** 活动ID */
    private Long activityId;
}
