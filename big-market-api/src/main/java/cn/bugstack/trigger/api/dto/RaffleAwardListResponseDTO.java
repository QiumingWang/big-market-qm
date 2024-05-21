package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: RaffleAwardListResponseDTO
 * @author: qiuming
 * @description: 抽奖奖品列表，response 对象
 * @date: 2024/4/26 11:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardListResponseDTO {
    /** 奖品ID */
    private Integer awardId;
    /** 奖品标题 */
    private String awardTitle;
    /** 奖品副标题【抽奖1次后解锁】 */
    private String awardSubtitle;
    /** 排序编号 */
    private Integer sort;
    /** 奖品次数规则 - 抽奖N次后解锁，未配置则为空 */
    private Integer awardRuleLockCount;
    /** 奖品是否解锁 */
    private Boolean isAwardUnlock;
    /** 剩余次数可解锁 awardRuleLock - 当前抽奖次数 */
    private Integer waitUnlockCount;
}
