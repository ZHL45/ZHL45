package cn.neusoft.mapper;

import cn.neusoft.domain.Supplier;
import cn.neusoft.domain.order.OrderSub;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.JobSubQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubstationMapper {
    Integer jiesuan(JobSubQuery jobSubQuery);
    List<OrderSub> findWeiByPage(JobSubQuery query);
    List<OrderSub> findYiByPage(JobSubQuery query);
}
