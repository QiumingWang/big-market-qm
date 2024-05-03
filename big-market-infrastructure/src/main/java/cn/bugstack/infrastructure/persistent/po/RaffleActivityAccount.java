package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @className: RaffleActivityAccount
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/3 20:42
 */
@Data
public class RaffleActivityAccount {
    /** 自增ID */
    private Long id;
    /** 用户ID */
    private String user_id;
    /** 活动ID */
    private Long activity_id;
    /** 总次数 */
    private Integer total_count;
    /** 总次数-剩余 */
    private Integer total_count_surplus;
    /** 日次数 */
    private Integer day_count;
    /** 日次数-剩余 */
    private Integer day_count_surplus;
    /** 月次数 */
    private Integer month_count;
    /** 月次数-剩余 */
    private Integer month_count_surplus;
    /** 创建时间 */
    private Date create_time;
    /** 更新时间 */
    private Date update_time;
}
