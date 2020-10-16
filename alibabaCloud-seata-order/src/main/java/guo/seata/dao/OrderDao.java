package guo.seata.dao;

import guo.seata.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 10:08
 */
public interface OrderDao {
    int create(Order order);
    int changeStatus(@Param("userId") Long userId, @Param("status") int status);
}
