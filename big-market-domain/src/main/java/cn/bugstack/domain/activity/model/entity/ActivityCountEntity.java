package cn.bugstack.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: ActivityCountEntity
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/4 17:50
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityCountEntity {
    /** 活动次数编号 */
    private Long activityCountId;
    /** 总次数 */
    private Integer totalCount;
    /** 日次数 */
    private Integer dayCount;
    /** 月次数 */
    private Integer monthCount;
}
