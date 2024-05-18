package cn.bugstack.domain.activity.service.quota.rule;

import cn.bugstack.domain.activity.model.entity.ActivityCountEntity;
import cn.bugstack.domain.activity.model.entity.ActivityEntity;
import cn.bugstack.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @className: IActionChain
 * @description: 下单规则过滤接口
 * @author: qiuming
 * @date: 2024/5/17 22:33
 */
public interface IActionChain extends IActionChainArmory {

    /**
     * 下单规则过滤
     *
     * @return boolean:
     * @description: TODO
     */
    boolean action(ActivitySkuEntity activitySkuEntity,
                   ActivityEntity activityEntity,
                   ActivityCountEntity activityCountEntity);
}
