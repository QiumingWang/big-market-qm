package cn.bugstack.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: TaskStateVO
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/23 12:01
 */
@Getter
@AllArgsConstructor
public enum TaskStateVO {
    CREATE("create", "创建"),
    COMPLETE("complete", "发送完成"),
    FAIL("fail", "发送失败"),
    ;

    private final String code;
    private final String info;
}
