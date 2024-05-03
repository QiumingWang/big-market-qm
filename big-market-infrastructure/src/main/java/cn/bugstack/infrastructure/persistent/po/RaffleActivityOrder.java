package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @className: RaffleActivityOrder
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/3 20:47
 */
@Data
public class RaffleActivityOrder {
    /** 自增ID */
    private Long id;
    /** 用户ID */
    private String user_id;
    /** 活动ID */
    private Long activity_id;
    /** 活动名称 */
    private String activity_name;
    /** 抽奖策略ID */
    private Long strategy_id;
    /** 订单ID */
    private Long order_id;
    /** 下单时间 */
    private Date order_time;
    /** 订单状态（not_used、used、expire） */
    private String state;
    /** 创建时间 */
    private Date create_time;
    /** 更新时间 */
    private Date update_time;
}
