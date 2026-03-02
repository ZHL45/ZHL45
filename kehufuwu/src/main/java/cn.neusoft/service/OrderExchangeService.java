package cn.neusoft.service;


import cn.neusoft.domain.order.OrderExchange;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.vo.PageQueryBean;

import java.util.List;

public interface OrderExchangeService {

    PageQueryBean<OrderExchange> findByPage(BaseQuery query);

    Integer orderReturn(OrderReturn orderReturn);
}
