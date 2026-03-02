package cn.neusoft.mapper;

import cn.neusoft.domain.fenzhan.Payment;
import cn.neusoft.domain.fenzhan.Payment1;
import cn.neusoft.packaging.PaymentQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface PaymentMapper {
    Set<String> findclass();
    Set<String> findname(String class1);

    List<Payment> findbypage(PaymentQuery paymentQuery);

    List<Payment1> findbypage1(PaymentQuery paymentQuery);
}
