package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: ActivityDrawResponseDTO
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/20 0:23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDrawResponseDTO {
    /** 奖品ID */
    private Integer awardId;
    /** 奖品标题 */
    private String awardTitle;
    /** 奖品排序编号 */
    private Integer awardIndex;
}
