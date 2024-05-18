package cn.bugstack.domain.task.model.entity;

import lombok.Data;

/**
 * @className: TaskEntity
 * @description: 任务实体对象
 * @author: qiuming
 * @date: 2024/5/19 22:50
 */
@Data
public class TaskEntity {
    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private String message;
}
