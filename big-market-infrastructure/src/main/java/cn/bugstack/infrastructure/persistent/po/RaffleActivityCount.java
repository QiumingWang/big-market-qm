package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

/**
 * @className: RaffleActivityAccount
 * @description: 活动次数配置表
 * @author: qiuming
 * @date: 2024/5/3 20:38
 */
@Data
public class RaffleActivityCount {
    /** 自增ID */
    private Long id;
    /** 活动次数编号 */
    private Long activity_countId;
    /** 总次数 */
    private Integer totalCount;
    /** 日次数 */
    private Integer dayCount;
    /** 月次数 */
    private Integer monthCount;
    /** 创建时间 */
    private Long createTime;
    /** 更新时间 */
    private Long updateTime;

}
