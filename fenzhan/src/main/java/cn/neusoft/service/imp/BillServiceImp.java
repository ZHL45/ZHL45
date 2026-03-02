package cn.neusoft.service.imp;

import cn.neusoft.domain.fenzhan.Bill;
import cn.neusoft.mapper.BillMapper;
import cn.neusoft.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImp implements BillService {
    @Autowired
    BillMapper billMapper;
    @Override
    public Integer add(Bill bill) {
        return billMapper.add(bill);
    }


    @Override
    public Integer delete(Bill bill) {
        return billMapper.delete(bill);
    }

    @Override
    public List<Bill> findbypage(Bill bill) {
        return billMapper.findbypage(bill);
    }

//    @Override
//    public List<Bill> findall() {
//        return billMapper.findall();
//    }

    @Override
    public List<Bill> findall2() {
        return billMapper.findall2();
    }

    @Override
    public List<Bill> findbypage2(Bill bill) {
        return billMapper.findbypage2(bill);
    }
}
