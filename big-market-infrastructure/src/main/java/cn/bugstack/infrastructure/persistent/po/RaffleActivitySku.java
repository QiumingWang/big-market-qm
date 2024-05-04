package cn.bugstack.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @className: RaffleActivitySku
 * @description: 抽奖活动SKU持久化对象
 * @author: qiuming
 * @date: 2024/5/4 16:42
 */
@Data
public class RaffleActivitySku {
    /** 自增ID */
    private Integer id;
    /** 商品sku - 把每一个组合当做一个商品 */
    private Long sku;
    /** 活动ID */
    private Long activityId;
    /** 活动个人参与次数ID */
    private Long activityCountId;
    /** 商品库存 */
    private Integer stockCount;
    /** 剩余库存 */
    private Integer stockCountSurplus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
