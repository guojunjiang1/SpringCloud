package guo.account.dao;

import guo.account.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 11:14
 */
public interface AccountDao {
    int change(@Param("userId") Long userId, @Param("money") BigDecimal money);
    Account findById(Long userId);
}
