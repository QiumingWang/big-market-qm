package cn.bugstack.domain.strategy.service.annotation;

import cn.bugstack.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: LogicStrategy
 * @description: 逻辑策略
 * @date: 2024/4/13 11:42
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicStrategy {

    // 这儿不是方法，是属性
    DefaultLogicFactory.LogicModel logicMode();

}
