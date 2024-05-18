package cn.bugstack.domain.award.repository;

import cn.bugstack.domain.award.model.aggregate.UserAwardRecordAggregate;

/**
 * @className: IAwardRepository
 * @description: 奖品仓储服务
 * @author: qiuming
 * @date: 2024/5/19 21:33
 */
public interface IAwardRepository {

    /** 保存奖品对象 */
    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);
}
