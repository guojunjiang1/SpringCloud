package guo.payment.service;

import guo.common.entity.Payment;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/27 19:12
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
