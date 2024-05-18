package cn.bugstack.domain.award.service;

import cn.bugstack.domain.award.model.entity.UserAwardRecordEntity;

/**
 * @className: IAwardService
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/19 21:12
 */
public interface IAwardService {

    /**
     * 保存用户中奖记录
     *
     * @param userAwardRecordEntity:
     */
    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);
}
