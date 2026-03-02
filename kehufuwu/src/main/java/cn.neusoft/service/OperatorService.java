package cn.neusoft.service;


import cn.neusoft.domain.OperatorInfo;
import cn.neusoft.domain.order.OperatorJob;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.OperatorInfoQuery;
import cn.neusoft.query.OperatorJobQuery;
import cn.neusoft.query.OrderByOpQuery;
import cn.neusoft.vo.PageQueryBean;

import java.util.List;

public interface OperatorService {
    PageQueryBean<OperatorInfo> findByPage(BaseQuery query);
    //查询操作员id下所有订单信息
    List<OrderAll> findOrderInfo(OrderByOpQuery orderByOpQuery);
    //查询操作员的操作量
    List<OperatorJob> findOperatorJobInfo(OperatorJobQuery operatorJobQuery);
}
