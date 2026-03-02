package cn.neusoft.mapper;

import cn.neusoft.domain.fenzhan.Bill;
import cn.neusoft.domain.fenzhan.Fenzhan_receipt_state;
import cn.neusoft.domain.fenzhan.OrderAll;
import cn.neusoft.domain.fenzhan.Receipt;
import cn.neusoft.domain.kufang.OrderReturn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReceiptMapper {
    public List<Receipt> findall();//查询全部

    public int add(Receipt receipt);//添加回执记录,任务类型为送货收款
    public int add2(Receipt receipt);//添加回执记录，任务类型为送货or换货
    public int add3(Receipt receipt);//添加回执记录，任务类型为退货or退款

    public Receipt findbyid(String tid);//通过id查询特定数据

    public List<OrderAll> findbypage(Receipt receipt);//分页+模糊搜索功能
    public List<OrderAll> findbypage2(Receipt receipt);//分页+模糊搜索功能
    public List<OrderAll> findbypage3(Receipt receipt);//分页+模糊搜索功能

    Bill findbill(String did);

    public Integer total();//查询数据条数
    public Integer total2(Receipt receipt);//模糊搜索后查询数据条数

    public List<Receipt> findbycondition(Receipt receipt);//条件查询
    OrderAll add_follow(String o_id);
    OrderReturn add_follow3(String o_id);
    String getpman(String integer);

    Fenzhan_receipt_state get_state(String id);
    Integer set_state(Fenzhan_receipt_state fenzhanReceiptState);

    Integer check(String id);



}
