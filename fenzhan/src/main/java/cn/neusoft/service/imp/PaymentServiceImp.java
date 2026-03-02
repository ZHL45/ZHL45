package cn.neusoft.service.imp;

import cn.neusoft.domain.fenzhan.Payment;
import cn.neusoft.domain.fenzhan.Payment1;
import cn.neusoft.mapper.PaymentMapper;
import cn.neusoft.packaging.PaymentQuery;
import cn.neusoft.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PaymentServiceImp implements PaymentService {
    @Autowired
    PaymentMapper paymentMapper;
    @Override
    public Set<String> findclass() {
        return paymentMapper.findclass();
    }

    @Override
    public Set<String> findname(String class1) {
        return paymentMapper.findname(class1);
    }

    @Override
    public List<Payment> findbypage(PaymentQuery paymentQuery) {
        return paymentMapper.findbypage(paymentQuery);
    }

    @Override
    public List<Payment1> findbypage1(PaymentQuery paymentQuery) {
        return paymentMapper.findbypage1(paymentQuery);
    }
}
