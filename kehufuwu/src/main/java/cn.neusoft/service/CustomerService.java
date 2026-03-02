package cn.neusoft.service;


import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.vo.PageQueryBean;

import java.util.List;

public interface CustomerService {
    Integer add(CustomerInfo customerInfo);

    Integer delete(String id);

    Integer update(CustomerInfo customerInfo);

    PageQueryBean<CustomerInfo> findByPage(BaseQuery query);

    List<OrderAll> findById(String c_id);

    String getC_id();
}
