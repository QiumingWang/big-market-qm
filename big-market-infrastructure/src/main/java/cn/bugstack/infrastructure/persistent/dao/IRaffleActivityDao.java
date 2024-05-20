package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: IRaffleActivityDao
 * @description: XXX
 * @author: qiuming
 * @date: 2024/5/3 21:44
 */
@Mapper
public interface IRaffleActivityDao {
    RaffleActivity queryRaffleActivityByActivityId(Long activityId);


    Long queryRaffleStrategyIdByActivityId(Long activityId);

    Long queryRaffleActivityIdByStrategyId(Long strategyId);
}
