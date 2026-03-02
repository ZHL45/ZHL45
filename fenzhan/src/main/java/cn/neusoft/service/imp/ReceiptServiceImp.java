package cn.neusoft.service.imp;

import cn.neusoft.domain.fenzhan.Bill;
import cn.neusoft.domain.fenzhan.Fenzhan_receipt_state;
import cn.neusoft.domain.fenzhan.OrderAll;
import cn.neusoft.domain.fenzhan.Receipt;
import cn.neusoft.domain.kufang.OrderReturn;
import cn.neusoft.mapper.ReceiptMapper;
import cn.neusoft.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImp implements ReceiptService {
    @Autowired
    ReceiptMapper receiptMapper;
    @Override
    public List<Receipt> findall() {
        return receiptMapper.findall();
    }

    @Override
    public int add(Receipt receipt) {
        return receiptMapper.add(receipt);
    }

    @Override
    public int add2(Receipt receipt) {
        return receiptMapper.add2(receipt);
    }

    @Override
    public int add3(Receipt receipt) {
        return receiptMapper.add3(receipt);
    }

    @Override
    public Receipt findbyid(String tid) {
        return receiptMapper.findbyid(tid);
    }

    @Override
    public Bill findbill(String did) {
        return receiptMapper.findbill(did);
    }

    @Override
    public List<OrderAll> findbypage(Receipt receipt) {
        return receiptMapper.findbypage(receipt);
    }

    @Override
    public List<OrderAll> findbypage2(Receipt receipt) {
        return receiptMapper.findbypage2(receipt);
    }

    @Override
    public List<OrderAll> findbypage3(Receipt receipt) {
        return receiptMapper.findbypage3(receipt);
    }


    @Override
    public Integer total() {
        return receiptMapper.total();
    }

    @Override
    public Integer total2(Receipt receipt) {
        return receiptMapper.total2(receipt);
    }

    @Override
    public List<Receipt> findbycondition(Receipt receipt) {
        return receiptMapper.findbycondition(receipt);
    }

    @Override
    public OrderAll add_follow(String o_id) {
        return receiptMapper.add_follow(o_id);
    }

    @Override
    public OrderReturn add_follow3(String o_id) {
        return receiptMapper.add_follow3(o_id);
    }

    @Override
    public String getpman(String integer) {
        return receiptMapper.getpman(integer);
    }

    @Override
    public Fenzhan_receipt_state get_state(String id) {
        return receiptMapper.get_state(id);
    }

    @Override
    public Integer set_state(Fenzhan_receipt_state fenzhanReceiptState) {
        return receiptMapper.set_state(fenzhanReceiptState);
    }

    @Override
    public Integer check(String id) {
        return receiptMapper.check(id);
    }
}
