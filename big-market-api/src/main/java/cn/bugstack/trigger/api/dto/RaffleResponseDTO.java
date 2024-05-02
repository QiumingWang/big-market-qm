package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: RaffleResponseDTO
 * @author: qiuming
 * @description: 抽奖应答结果
 * @date: 2024/4/26 12:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleResponseDTO {
    /** 奖品ID */
    private Integer awardId;
    /** 排序编号【策略奖品配置的奖品顺序编号】 */
    private Integer awardIndex;
}
