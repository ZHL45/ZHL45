package cn.neusoft.service;

import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.vo.PageQueryBean;

import java.util.List;

public interface OrderReturnService {

    PageQueryBean<OrderReturn> findByPage(BaseQuery query);
}
