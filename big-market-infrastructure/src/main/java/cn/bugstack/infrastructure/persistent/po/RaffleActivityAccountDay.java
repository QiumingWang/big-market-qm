package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @className: RaffleActivityAccountDay
 * @description: 用户抽奖日账户表，每日刷新
 * @author: qiuming
 * @date: 2024/5/18 20:20
 */
@Data
public class RaffleActivityAccountDay {
    /** 自增ID */
    private Integer id;
    /** 用户ID */
    private String  userId;
    /** 活动ID */
    private Long activityId;
    /** 日期（yyyy-mm-dd） */
    private String day;
    /** 日次数 */
    private Integer dayCount;
    /** 日次数-剩余 */
    private Integer dayCountSurplus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
