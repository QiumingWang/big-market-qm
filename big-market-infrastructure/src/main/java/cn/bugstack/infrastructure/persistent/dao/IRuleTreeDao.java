package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: IRuleTreeDao
 * @author: qiuming
 * @description: 规则树表DAO
 * @date: 2024/4/16 18:42
 */
@Mapper
public interface IRuleTreeDao {
    RuleTree queryRuleTreeByTreeId(String treeId);
}
