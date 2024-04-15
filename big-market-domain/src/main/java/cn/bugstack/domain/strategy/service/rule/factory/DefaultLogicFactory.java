package cn.bugstack.domain.strategy.service.rule.factory;

import cn.bugstack.domain.strategy.model.entity.RuleActionEntity;
import cn.bugstack.domain.strategy.service.annotation.LogicStrategy;
import cn.bugstack.domain.strategy.service.rule.ILogicFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 规则工厂, 对Entity进行过滤
 * @create 2023-12-31 11:23
 */
@Service
public class DefaultLogicFactory {

    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        // 遍历列表中的每个逻辑过滤器
        logicFilters.forEach(logic -> {
            // 使用Spring的AnnotationUtils类找到每个逻辑过滤器类上的LogicStrategy注解
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                // 将逻辑过滤器添加到map中，key是注解中的逻辑模式的代码，value是逻辑过滤器本身
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    /*
     * @return Map<String,ILogicFilter<T>>
     * @author: qiuming
     * @description: 返回逻辑过滤器的map
     * @date: 2024/4/14 23:21
     */
    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_WEIGHT("rule_weight","【抽奖前规则】根据抽奖权重返回可抽奖范围KEY", "before"),
        RULE_BLACKLIST("rule_blacklist","【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回", "before"),
        RULE_LOCK("rule_lock", "【抽奖中规则】抽奖n次后，对应奖品可解锁抽奖", "center"),
        RULE_LUCK_AWARD("rule_luck_award", "【抽奖后规则】幸运奖兜底", "after"),
        ;

        private final String code;
        private final String info;
        private final String type;

        public static boolean isCenter(String code) {
            // 把code从"RULE_WEIGHT”等,得到before或者center
            return "center".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }
        public static boolean isAfter(String code) {
            // 把code从"RULE_WEIGHT”等,得到before或者center
            return "after".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }
    }


}
