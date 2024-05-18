package cn.bugstack.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: UserRaffleOrderStateVO
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/18 21:11
 */
@Getter
@AllArgsConstructor
public enum UserRaffleOrderStateVO {
    create("create", "创建"),
    used("used", "已使用"),
    cancel("cancel", "取消"),
    ;

    private final String code;
    private final String desc;
}
