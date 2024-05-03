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
    private Long activityId;
    /** 活动名称 */
    private String activityName;
    /** 活动描述 */
    private String activityDesc;
    /** 开始时间 */
    private Date begin_dateTime;
    /** 结束时间 */
    private Date end_dateTime;
    /** 库存总量 */
    private Integer stockCount;
    /** 剩余库存 */
    private Integer stockCountSurplus;
    /** 活动参与次数配置 */
    private Long activityCountId;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 活动状态 */
    private String state;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
