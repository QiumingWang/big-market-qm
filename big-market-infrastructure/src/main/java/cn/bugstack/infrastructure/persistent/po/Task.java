package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

/**
 * @className: Task
 * @description: 任务表，发送MQ
 * @author: qiuming
 * @date: 2024/5/18 20:32
 */
@Data
public class Task {
    /** 自增ID */
    private String id;
    /** 消息主题 */
    private String topic;
    /** 消息主体 */
    private String message;
    /** 任务状态；create-创建、completed-完成、fail-失败 */
    private String state;
    /** 创建时间 */
    private String createTime;
    /** 更新时间 */
    private String updateTime;

}
