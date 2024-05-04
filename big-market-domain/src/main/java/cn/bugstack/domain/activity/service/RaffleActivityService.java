package cn.bugstack.domain.activity.service;

import cn.bugstack.domain.activity.repository.IActivityRepository;
import org.springframework.stereotype.Service;

/**
 * @description: 抽奖活动服务
 * @className: RaffleActivityService
 * @author: qiuming
 * @date: 2024/5/4 18:31
 */

@Service
public class RaffleActivityService extends AbstractRaffleActivity{

    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }

}
