package cn.bugstack.domain.award.model.valobj;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AwardStateVO {
    create("create", "创建"),
    open("open", "开启"),
    close("close", "关闭"),
    ;

    private final String  code;
    private final String desc;
}
