package cn.bugstack.domain.strategy.service.rule.chain.impl;

import cn.bugstack.domain.strategy.repository.IStrategyRepository;
import cn.bugstack.domain.strategy.service.rule.chain.AbstractLogicChain;
import cn.bugstack.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @className: BlacklistLogicChain
 * @author: qiuming
 * @description: 黑名单方法
 * @date: 2024/4/16 10:34
 */
@Slf4j
@Component("rule_blacklist")
public class BlacklistLogicChain extends AbstractLogicChain {

    @Resource
    private IStrategyRepository repository;

    @Override
    protected String ruleModel() {
        return "rule_blacklist";
    }


    @Override
    public Integer logic(String userId, Long strategyId) {
        log.info("抽奖责任链-黑名单开始 userId: {} strategyID: {} ruleModel: {}", userId, strategyId, ruleModel());
        String ruleValue = repository.queryStrategyRuleValue(strategyId, ruleModel());

        // ruleValue格式：100:user001,user002,user003
        String[] splitRuleValue = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(splitRuleValue[0]);

        // 过滤其他规则
        String[] blackList = splitRuleValue[1].split(Constants.SPLIT);
        for (String blackUserId : blackList) {
            if (userId.equals(blackUserId)) {
                log.info("抽奖责任链-黑名单接管 userID: {} strategyID: {} ruleModel: {} awardID: {}", userId, strategyId, ruleModel(), awardId);
                return awardId;
            }
        }

        // 过滤其他责任链
        log.info("抽奖责任链-黑名单放行 userId: {} strategyId: {} ruleModel: {}", userId, strategyId, ruleModel());

        // 策略放行
        return next().logic(userId, strategyId);
    }
}
