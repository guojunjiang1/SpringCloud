package guo.account.service;

import guo.account.dao.AccountDao;
import guo.account.domain.Account;
import io.seata.spring.annotation.GlobalTransactional;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 11:17
 */
@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public boolean change(Long userId, BigDecimal money){
        Account account = accountDao.findById(userId);
        if (account.getResidue().intValue()-money.intValue()<0){
            //余额不足
            throw new RuntimeException();
        }
        int change = accountDao.change(userId, money);
        return change>0;
    }
}
