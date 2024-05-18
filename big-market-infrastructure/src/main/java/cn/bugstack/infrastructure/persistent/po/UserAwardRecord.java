package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

/**
 * @className: UserAwardRecord
 * @description: 用户奖品发放表
 * @author: qiuming
 * @date: 2024/5/18 20:21
 */
@Data
public class UserAwardRecord {
    /** 自增ID */
    private String id;
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private String activityId;
    /** 抽奖策略ID */
    private String strategyId;
    /** 抽奖订单ID【作为幂等使用】 */
    private String orderId;
    /** 奖品ID */
    private String awardId;
    /** 奖品标题（名称） */
    private String awardTitle;
    /** 中奖时间 */
    private String awardTime;
    /** 奖品状态；create-创建、completed-发奖完成 */
    private String awardState;
    /** 创建时间 */
    private String createTime;
    /** 更新时间 */
    private String updateTime;
}
