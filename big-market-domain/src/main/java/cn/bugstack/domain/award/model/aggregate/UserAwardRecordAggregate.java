package cn.bugstack.domain.award.model.aggregate;

import cn.bugstack.domain.award.model.entity.TaskEntity;
import cn.bugstack.domain.award.model.entity.UserAwardRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: UserAwardRecordAggregate
 * @description: 用户中奖记录聚合对象 【聚合代表一个事务操作】
 * @author: qiuming
 * @date: 2024/5/19 21:34
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAwardRecordAggregate {
    private UserAwardRecordEntity userAwardRecordEntity;
    private TaskEntity taskEntity;
}
