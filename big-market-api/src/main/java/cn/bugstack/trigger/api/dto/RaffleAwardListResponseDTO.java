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
}
