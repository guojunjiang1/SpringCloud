package guo.payment.dao;


import guo.common.entity.Payment;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/27 18:55
 */
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
