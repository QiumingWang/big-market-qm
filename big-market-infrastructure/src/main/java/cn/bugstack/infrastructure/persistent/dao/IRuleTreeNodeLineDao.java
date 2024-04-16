package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: IRuleTreeNodeLine
 * @author: qiuming
 * @description: XXX
 * @date: 2024/4/16 18:45
 */
@Mapper
public interface IRuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineListByTreeId(String treeId);
}
