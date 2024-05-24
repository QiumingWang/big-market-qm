package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: UserActivityAccountRequestDTO
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/25 1:24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserActivityAccountRequestDTO {
    /** 用户 ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
}
