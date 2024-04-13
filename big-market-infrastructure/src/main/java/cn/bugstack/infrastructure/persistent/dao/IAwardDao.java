package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: IAward
 * @author: qiuming
 * @description: 奖品信息DAO
 * @date: 2024/4/9 18:14
 */
@Mapper
public interface IAwardDao {
    List<Award> queryAwardList();


}
