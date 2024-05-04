package cn.bugstack.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: ActivityStateVO
 * @description: 活动状态值枚举对象
 * @author: qiuming
 * @date: 2024/5/4 17:27
 */
@Getter
@AllArgsConstructor
public enum ActivityStateVO {

    create("create", "创建");

    private final String  code;
    private final String desc;
}
