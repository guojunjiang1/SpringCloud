package guo.storage.service;

import guo.storage.dao.StorageDao;
import guo.storage.domain.Storage;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 12:04
 */
@Service
public class StorageService {
    @Autowired
    private StorageDao storageDao;

    public boolean change(Long productId,Integer number){
        Storage storage = storageDao.findById(productId);
        if (storage.getResidue()-number<0){
            //库存不够
            throw new RuntimeException("库存不足");
        }
        int change = storageDao.change(productId, number);
        return change>0;
    }
}
