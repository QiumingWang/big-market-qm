package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: IStrategyDao
 * @description: 抽奖策略DAO
 * @date: 2024/4/9 17:34
 */
@Mapper
public interface IStrategyDao {
    List<Strategy> queryStrategyList();
}
