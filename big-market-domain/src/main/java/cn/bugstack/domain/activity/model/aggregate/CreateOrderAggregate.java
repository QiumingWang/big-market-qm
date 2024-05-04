package cn.bugstack.domain.activity.model.aggregate;

import cn.bugstack.domain.activity.model.entity.ActivityAccountEntity;
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
public class CreateOrderAggregate {
    /** 活动账户实体 */
    private ActivityAccountEntity activityAccountEntity;
    /** 活动订单实体 */
    private ActivityOrderEntity activityOrderEntity;
}
