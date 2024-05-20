package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.UserRaffleOrder;
import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: IUserRaffleOrder
 * @description: 用户抽奖记录表
 * @author: qiuming
 * @date: 2024/5/18 20:34
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserRaffleOrderDao {

    @DBRouter
    UserRaffleOrder queryNoUsedRaffleOrder(UserRaffleOrder userRaffleOrder);

    void insert(UserRaffleOrder raffleOrder);

    int updateUserRaffleOrderStateUsed(UserRaffleOrder userRaffleOrder);
}
