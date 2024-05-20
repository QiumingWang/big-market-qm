package cn.bugstack.trigger.api.dto;

import lombok.Data;

/**
 * @className: ActivityDrawRequestDTO
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/20 0:23
 */
@Data
public class ActivityDrawRequestDTO {
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
}
