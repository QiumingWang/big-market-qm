package cn.bugstack.domain.activity.service.quota;

import cn.bugstack.domain.activity.model.entity.ActivityCountEntity;
import cn.bugstack.domain.activity.model.entity.ActivityEntity;
import cn.bugstack.domain.activity.model.entity.ActivitySkuEntity;
import cn.bugstack.domain.activity.repository.IActivityRepository;
import cn.bugstack.domain.activity.service.quota.rule.factory.DefaultActivityChainFactory;

/**
 * @className: RaffleActivitySupport
 * @description: 抽奖活动支撑类
 * @author: qiuming
 * @date: 2024/5/17 22:18
 */
public class RaffleActivityAccountQuotaSupport {
    protected DefaultActivityChainFactory defaultActivityChainFactory;
    protected IActivityRepository activityRepository;

    //NOTE: Spring 推荐使用构造注入：spring.io中有
    public RaffleActivityAccountQuotaSupport(DefaultActivityChainFactory defaultActivityChainFactory,
                                             IActivityRepository activityRepository){
        this.defaultActivityChainFactory = defaultActivityChainFactory;
        this.activityRepository = activityRepository;
    }

    public ActivitySkuEntity querySkuEntity(Long sku) {
        return activityRepository.queryActivitySku(sku);
    }

    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }

    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityCountId);
    }

}
