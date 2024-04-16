package cn.bugstack.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className: RuleTreeNode
 * @author: qiuming
 * @description: 规则树节点对象
 * @date: 2024/4/16 15:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleTreeNodeVO {
    /** 规则树ID */
    private String treeId;
    /** 规则Key */
    private String ruleKey;
    /** 规则描述 */
    private String ruleDesc;
    /** 规则比值 */
    private String ruleValue;

    private List<RuleTreeNodeLineVO> treeNodeLineVOList;
}
