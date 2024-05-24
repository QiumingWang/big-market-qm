package cn.bugstack.domain.rebate.model.entity;

import cn.bugstack.domain.rebate.model.valobj.BehaviorTypeVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: BehaviorEntity
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/23 11:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BehaviorEntity {
    /** 用户ID */
    private String userId;
    /** 行为类型；sign 签到、openai_pay 支付 */
    private BehaviorTypeVO behaviorTypeVO;
    /** 业务ID；签到则是日期字符串，支付则是外部的业务ID，维护幂等 */
    private String outBusinessNo;
}
