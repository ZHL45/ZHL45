package cn.neusoft.mapper;

import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderExchange;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderExchangeMapper {
    Integer add(OrderExchange orderExchange);//添加订单信息
    Integer delete(OrderExchange orderExchange);//删除订单信息
    Integer update(OrderExchange orderExchange);//修改订单信息
    public List<OrderExchange> findByPage(BaseQuery query);//分页+模糊搜索功能
    public Integer orderReturn(OrderReturn orderReturn);//将换货订单进行退货

}
