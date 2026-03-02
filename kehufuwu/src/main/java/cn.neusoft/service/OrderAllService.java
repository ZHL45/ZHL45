package cn.neusoft.service;


import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.domain.order.OrderExchange;
import cn.neusoft.domain.order.OrderLack;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.vo.PageQueryBean;

public interface OrderAllService {
    Integer add(OrderAll orderAll);

    Integer delete(String id);

    Integer update(OrderAll orderAll);

    Integer changeAfterSales(OrderAll orderAll);

    PageQueryBean<OrderAll> findByPage(BaseQuery query);

    Integer orderReturn(OrderReturn orderReturn);
    Integer orderExchange(OrderExchange orderExchange);
    Integer orderLack(OrderLack orderLack);
    //获取订单编号
    String getOrderId(String c_id,String type);
}
