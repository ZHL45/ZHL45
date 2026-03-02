package cn.neusoft.service;

import cn.neusoft.domain.fenzhan.Bill;

import java.util.List;

public interface BillService {
    Integer add(Bill bill);

    Integer delete(Bill bill);

    List<Bill> findbypage(Bill bill);
//    List<Bill> findall();

    List<Bill> findall2();

    List<Bill> findbypage2(Bill bill);


}

