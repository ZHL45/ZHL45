package cn.neusoft.service;

import cn.neusoft.domain.Supplier;
import cn.neusoft.domain.order.OrderSub;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.JobSubQuery;
import cn.neusoft.vo.PageQueryBean;

import java.util.List;

public interface SubStationService {
    Integer jiesuan(JobSubQuery jobSubQuery);
    List<OrderSub> findWeiByPage(JobSubQuery query);
    List<OrderSub> findYiByPage(JobSubQuery query);
}
