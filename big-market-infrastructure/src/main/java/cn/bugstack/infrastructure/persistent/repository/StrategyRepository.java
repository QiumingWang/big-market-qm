package cn.bugstack.infrastructure.persistent.repository;

import cn.bugstack.domain.strategy.model.entity.StrategyAwardEntity;
import cn.bugstack.domain.strategy.model.entity.StrategyEntity;
import cn.bugstack.domain.strategy.model.entity.StrategyRuleEntity;
import cn.bugstack.domain.strategy.model.valobj.*;
import cn.bugstack.domain.strategy.repository.IStrategyRepository;
import cn.bugstack.infrastructure.persistent.dao.*;
import cn.bugstack.infrastructure.persistent.po.*;
import cn.bugstack.infrastructure.persistent.redis.IRedisService;
import cn.bugstack.types.common.Constants;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @className: StrategyRepository
 * @author: qiuming
 * @description: 策略仓储实现, 与数据库表交互类
 * @date: 2024/4/9 23:39
 */
@Repository
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyAwardDao strategyAwardDao;
    @Resource
    private IStrategyRuleDao strategyRuleDao;
    @Resource
    private IRedisService redisService;

    @Resource
    private IRuleTreeDao ruleTreeDao;
    @Resource
    private IRuleTreeNodeDao ruleTreeNodeDao;
    @Resource
    private IRuleTreeNodeLineDao ruleTreeNodeLineDAO;


    @Override
    public List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId) {
        String cacheKey = Constants.RedisKey.STRATEGY_AWARD_KEY + strategyId;

        List<StrategyAwardEntity> strategyAwardEntities = redisService.getValue(cacheKey);

        if (strategyAwardEntities != null && !strategyAwardEntities.isEmpty()) {
            return strategyAwardEntities;
        }
        // 从库中读取数据
        List<StrategyAward> strategyAwards = strategyAwardDao.queryStrategyAwardListByStrategyId(strategyId);
        strategyAwardEntities = new ArrayList<>(strategyAwards.size());
        for (StrategyAward strategyAward: strategyAwards) {
            StrategyAwardEntity strategyAwardEntity = StrategyAwardEntity.builder()
                    .strategyId(strategyAward.getStrategyId())
                    .awardId(strategyAward.getAwardId())
                    .awardCount(strategyAward.getAwardCount())
                    .awardCountSurplus(strategyAward.getAwardCountSurplus())
                    .awardRate(strategyAward.getAwardRate())
                    .build();
            strategyAwardEntities.add(strategyAwardEntity);
        }
        redisService.setValue(cacheKey, strategyAwardEntities);

        return strategyAwardEntities;
    }

    @Override
    public void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable) {
        // 1. 存储抽奖策略范围值，如10000，用于生成1000以内的随机数
        redisService.setValue(Constants.RedisKey.STRATEGY_RATE_RANGE_KEY + key, rateRange);
        // 2. 存储概率查找表
        Map<Integer, Integer> cacheRateTable = redisService.getMap(Constants.RedisKey.STRATEGY_RATE_TABLE_KEY + key);
        cacheRateTable.putAll(strategyAwardSearchRateTable);
    }

    @Override
    public Integer getRateRange(Long strategyId) {
        return getRateRange(String.valueOf(strategyId));
    }

    @Override
    public Integer getRateRange(String key) {
        return redisService.getValue(Constants.RedisKey.STRATEGY_RATE_RANGE_KEY  + key);
    }

    @Override
    public Integer getStrategyAwardAssemble(String strategyId, Integer rateKey) {
        return redisService.getFromMap(Constants.RedisKey.STRATEGY_RATE_TABLE_KEY  + strategyId, rateKey);
    }

    @Override
    public StrategyEntity queryStrategyEntityByStrategyId(Long strategyId) {
        // 优先从缓存中获取数据
        String cacheKey = Constants.RedisKey.STRATEGY_KEY + strategyId;
        StrategyEntity strategyEntity = redisService.getValue(cacheKey);
        if (strategyEntity != null) {
            return strategyEntity;
        }
        // 从库中读取数据
        Strategy strategy = strategyDao.queryStrategyByStrategyId(strategyId);
        // 转换对象
        strategyEntity = StrategyEntity.builder()
                .strategyId(strategy.getStrategyId())
                .strategyDesc(strategy.getStrategyDesc())
                .ruleModels(strategy.getRuleModels())
                .build();
        // 存储到缓存中
        redisService.setValue(cacheKey, strategyEntity);

        return strategyEntity;
    }

    @Override
    public StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel) { // FIXME: 为什么不用redis缓存了
        // 从库中读取数据
        StrategyRule strategyRuleReq = new StrategyRule();
        strategyRuleReq.setStrategyId(strategyId);
        strategyRuleReq.setRuleModel(ruleModel);
        // 返回的strategyRule response
        StrategyRule strategyRuleRes = strategyRuleDao.queryStrategyRule(strategyRuleReq);
        return StrategyRuleEntity.builder()
                .strategyId(strategyRuleRes.getStrategyId())
                .awardId(strategyRuleRes.getAwardId())
                .ruleType(strategyRuleRes.getRuleType())
                .ruleModel(strategyRuleRes.getRuleModel())
                .ruleValue(strategyRuleRes.getRuleValue())
                .ruleDesc(strategyRuleRes.getRuleDesc())
                .build();
    }

    @Override
    public String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel) {
        StrategyRule strategyRule = new StrategyRule();
        strategyRule.setStrategyId(strategyId);
        strategyRule.setAwardId(awardId);
        strategyRule.setRuleModel(ruleModel);
        return strategyRuleDao.queryStrategyRuleValue(strategyRule);
    }

    @Override
    public String queryStrategyRuleValue(Long strategyId, String ruleModel) {
        return queryStrategyRuleValue(strategyId, null, ruleModel);
    }

    @Override
    public StrategyAwardRuleModelVO queryStrategyAwardRuleModel(Long strategyId, Integer awardId) {
        StrategyAward strategyAward = new StrategyAward();
        strategyAward.setStrategyId(strategyId);
        strategyAward.setAwardId(awardId);
        String ruleModels = strategyAwardDao.queryStrategyAwardRuleModels(strategyAward);
        return StrategyAwardRuleModelVO.builder().ruleModels(ruleModels).build();
    }

    /**
     * @param treeId:       treeId
     * @return RuleTreeVO:  tree对象
     * @author: qiuming
     * @description: 从treeID构建整个ruleTree
     * @date: 2024/4/16 22:21
     */
    @Override
    public RuleTreeVO queryRuleTreeVOByTreeId(String treeId) {
        // 优先从缓存中获取
        String cacheKey = Constants.RedisKey.RULE_TREE_VO_KEY + treeId;
        RuleTreeVO ruleTreeVOCache = redisService.getValue(cacheKey);
        if (null != ruleTreeVOCache) return ruleTreeVOCache;

        RuleTree ruleTree = ruleTreeDao.queryRuleTreeByTreeId(treeId);
        List<RuleTreeNode> ruleTreeNodes = ruleTreeNodeDao.queryRuleTreeNodeListByTreeId(treeId);
        List<RuleTreeNodeLine> ruleTreeNodeLines = ruleTreeNodeLineDAO.queryRuleTreeNodeLineListByTreeId(treeId);

        // 1. tree node line 转换Map结构
        Map<String, List<RuleTreeNodeLineVO>> ruleTreeNodeLineMap = new HashMap<>();
        for (RuleTreeNodeLine ruleTreeNodeLine: ruleTreeNodeLines) {
            RuleTreeNodeLineVO ruleTreeNodeLineVO = RuleTreeNodeLineVO.builder()
                    .treeId(ruleTreeNodeLine.getTreeId())
                    .ruleNodeFrom(ruleTreeNodeLine.getRuleNodeFrom())
                    .ruleNodeTo(ruleTreeNodeLine.getRuleNodeTo())
                    .ruleLimitType(RuleLimitTypeVO.valueOf(ruleTreeNodeLine.getRuleLimitType()))  // 从“EQUAL" 变为对应的枚举值
                    .ruleLimitValue(RuleLogicCheckTypeVO.valueOf(ruleTreeNodeLine.getRuleLimitValue()))  // 从TAKE_OVER 转换为对应的枚举值
                    .build();

            List<RuleTreeNodeLineVO> ruleTreeNodeLineVOList = ruleTreeNodeLineMap.computeIfAbsent(ruleTreeNodeLine.getRuleNodeFrom(), k-> new ArrayList<>());
            ruleTreeNodeLineVOList.add(ruleTreeNodeLineVO);
        }

        // 2. treeNode转换为Map结构
        Map<String, RuleTreeNodeVO> treeNodeMap = new TreeMap<>();
        for (RuleTreeNode ruleTreeNode: ruleTreeNodes) {
            RuleTreeNodeVO ruleTreeNodeVO = RuleTreeNodeVO.builder()
                    .treeId(ruleTreeNode.getTreeId())
                    .ruleKey(ruleTreeNode.getRuleKey())
                    .ruleDesc(ruleTreeNode.getRuleDesc())
                    .ruleValue(ruleTreeNode.getRuleValue())
                    .treeNodeLineVOList(ruleTreeNodeLineMap.get(ruleTreeNode.getRuleKey()))
                    .build();

            treeNodeMap.put(ruleTreeNodeVO.getRuleKey(), ruleTreeNodeVO);
        }

        // 3. 构建Rule_Tree
        RuleTreeVO ruleTreeVODB = RuleTreeVO.builder()
                .treeId(ruleTree.getTreeId())
                .treeName(ruleTree.getTreeName())
                .treeDesc(ruleTree.getTreeDesc())
                .treeRootRuleNode(ruleTree.getTreeRootRuleKey())
                .treeNodeMap(treeNodeMap)
                .build();

        redisService.setValue(cacheKey, ruleTreeVODB);
        // 活动时间过期
        return ruleTreeVODB;
    }
}
