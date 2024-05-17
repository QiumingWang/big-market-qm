package cn.bugstack.domain.activity.model.entity;

import cn.bugstack.domain.activity.model.valobj.OrderStateVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @className: ActivityOrderEntity
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/4 17:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityOrderEntity {
    /** 用户ID */
    private String userId;
    private Long sku;
    /** 活动ID */
    private Long activityId;
    /** 活动名称 */
    private String activityName;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 订单ID */
    private String orderId;
    /** 下单时间 */
    private Date orderTime;
    /** 总次数 */
    private Integer totalCount;
    /** 日次数 */
    private Integer dayCount;
    /** 月次数 */
    private Integer monthCount;
    /** 订单状态（not_used、used、expire） */
    private OrderStateVO state;
    /** 业务防止重复 ID */
    private String outBusinessNo;
}
