package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: UserActivityAccountResponseDTO
 * @description: 用户活动账户应答对象
 * @author: qiuming
 * @date: 2024/5/25 1:21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserActivityAccountResponseDTO {
    /** 总次数 */
    private Integer totalCount;
    /** 总次数-剩余 */
    private Integer totalCountSurplus;
    /** 月次数 */
    private Integer monthCount;
    /** 月次数-剩余 */
    private Integer monthCountSurplus;
    /** 日次数 */
    private Integer dayCount;
    /** 日次数-剩余 */
    private Integer dayCountSurplus;
}
