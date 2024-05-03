package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @className: RaffleActivity
 * @description: 抽奖活动
 * @author: qiuming
 * @date: 2024/5/3 20:33
 */
@Data
public class RaffleActivity {
    /** 自增ID */
    private Long id;
    /** 活动ID */
    private Long activity_id;
    /** 活动名称 */
    private String activity_name;
    /** 活动描述 */
    private String activity_desc;
    /** 开始时间 */
    private Date begin_date_time;
    /** 结束时间 */
    private Date end_date_time;
    /** 库存总量 */
    private Integer stock_count;
    /** 剩余库存 */
    private Integer stock_count_surplus;
    /** 活动参与次数配置 */
    private Long activity_count_id;
    /** 抽奖策略ID */
    private Long strategy_id;
    /** 活动状态 */
    private String state;
    /** 创建时间 */
    private Date create_time;
    /** 更新时间 */
    private Date update_time;
}
