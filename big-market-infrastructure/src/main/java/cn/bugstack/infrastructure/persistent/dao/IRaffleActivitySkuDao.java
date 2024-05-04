package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: IRaffleActivitySkuDao
 * @description: 商品SKU data access object
 * @author: qiuming
 * @date: 2024/5/4 17:05
 */
@Mapper
public interface IRaffleActivitySkuDao {

    RaffleActivitySku queryActivitySku(Long sku);
}
