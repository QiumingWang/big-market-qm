package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @className: RaffleActivityAccountFlow
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/3 20:45
 */
@Data
public class RaffleActivityAccountFlow {
    /** 自增ID */
    private Integer id;
    /** 用户ID */
    private String user_id;
    /** 活动ID */
    private Long activity_id;
    /** 总次数 */
    private Integer total_count;
    /** 日次数 */
    private Integer day_count;
    /** 月次数 */
    private Integer month_count;
    /** 流水ID - 生成的唯一ID */
    private String flow_id;
    /** 流水渠道（activity-活动领取、sale-购买、redeem-兑换、free-免费赠送） */
    private String flow_channel;
    /** 业务ID（外部透传，活动ID、订单ID） */
    private String biz_id;
    /** 创建时间 */
    private Date create_time;
    /** 更新时间 */
    private Date update_time;

}
