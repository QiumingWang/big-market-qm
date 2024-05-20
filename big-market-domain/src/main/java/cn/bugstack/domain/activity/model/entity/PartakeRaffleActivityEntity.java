package cn.bugstack.domain.activity.model.entity;

import lombok.*;

/**
 * @className: PartakeRaffleActivityEntity
 * @description: 参与抽奖活动实体对象
 * @author: qiuming
 * @date: 2024/5/18 21:07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartakeRaffleActivityEntity {
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
}
