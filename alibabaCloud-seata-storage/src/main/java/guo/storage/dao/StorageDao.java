package guo.storage.dao;

import guo.storage.domain.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 11:45
 */
public interface StorageDao {
    int change(@Param("ProductId") Long ProductId,@Param("number") int number);
    Storage findById(@Param("ProductId") Long ProductId);
}
