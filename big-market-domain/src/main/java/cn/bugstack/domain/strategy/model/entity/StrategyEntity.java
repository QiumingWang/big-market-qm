package cn.bugstack.domain.strategy.model.entity;

import cn.bugstack.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @className: StrategyEntity
 * @author: qiuming
 * @description: 抽奖策略实体, 使用注解可以通过builder方法创建对象
 * @date: 2024/4/10 22:34
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyEntity {
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 抽奖规则模型: rule_weigh, rule_blacklist*/
    private String ruleModels;


    // 与entity紧密结合的代码
    public  String[] ruleModels(){
        if (StringUtils.isBlank(ruleModels)) return null;
        return ruleModels.split(Constants.SPLIT);
    }

    /*
     * @param :
     * @return String
     * @author qiuming
     * @description 查询是否包含rule_weight
     * @date 2024/4/10 23:16
     */
    public String getRuleWeight() {
        String[] ruleModels = this.ruleModels();
        for (String ruleModel : ruleModels) {
            if ("rule_weight".equals(ruleModel))  return ruleModel;
        }
        return null;
    }
}
