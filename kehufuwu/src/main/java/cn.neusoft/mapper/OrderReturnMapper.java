package cn.neusoft.mapper;

import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderReturnMapper {
    Integer add(OrderReturn orderReturn);//添加订单信息
    Integer delete(OrderReturn orderReturn);//删除订单信息
    Integer update(OrderReturn orderReturn);//修改订单信息
    public List<OrderReturn> findByPage(BaseQuery query);//分页+模糊搜索功能

}
