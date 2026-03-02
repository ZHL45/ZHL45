package cn.neusoft.mapper;

import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.domain.order.OrderExchange;
import cn.neusoft.domain.order.OrderLack;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderAllMapper {
    Integer add(OrderAll orderAll);//添加订单信息
    Integer delete(String id);//删除订单信息
    Integer changeAfterSales(OrderAll orderAll);//修改订单信息
    Integer update(OrderAll orderAll);//修改订单信息
    public List<OrderAll> findByPage(BaseQuery query);//分页+模糊搜索功能
    Integer orderReturn(OrderReturn orderReturn);//退货
    Integer orderExchange(OrderExchange orderExchange);//换货
    Integer orderLack(OrderLack orderLack);//生成缺货单
    //判断生成的订单，其中的商品是否为缺货状态
    String isLack(String p_name);
}
