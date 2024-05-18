package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @className: RaffleActivityAccountMonth
 * @description: 抽奖次数月账户表
 * @author: qiuming
 * @date: 2024/5/18 20:20
 */
@Data
public class RaffleActivityAccountMonth {
    /** 自增ID */
    private Integer id;
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 月（yyyy-mm） */
    private String month;
    /** 月次数 */
    private Integer monthCount;
    /** 月次数-剩余 */
    private Integer monthCountSurplus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
