package cn.bugstack.domain.activity.model.aggregate;

import cn.bugstack.domain.activity.model.entity.ActivityOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: CreateOrderAggregate
 * @description: 下单聚合对象
 * @author: qiuming
 * @date: 2024/5/4 17:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuotaOrderAggregate {
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 总次数 */
    private Integer totalCount;
    /** 日次数 */
    private Integer dayCount;
    /** 日次数-剩余 */
    private Integer monthCount;
    /** 活动订单实体 */
    private ActivityOrderEntity activityOrderEntity;
}
