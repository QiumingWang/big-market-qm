package cn.bugstack.domain.award.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: TaskStateVO
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/19 21:30
 */
@Getter
@AllArgsConstructor
public enum TaskStateVO {
    create("create", "创建"),
    complete("complete", "发送完成"),
    fail("fail", "发送失败"),
    ;


    private final String code;
    private final String info;
}
