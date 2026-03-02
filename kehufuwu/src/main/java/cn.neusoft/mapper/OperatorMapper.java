package cn.neusoft.mapper;


import cn.neusoft.domain.OperatorInfo;
import cn.neusoft.domain.order.OperatorJob;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.OperatorJobQuery;
import cn.neusoft.query.OrderByOpQuery;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperatorMapper {

    public List<OperatorInfo> findByPage(BaseQuery query);//分页+模糊搜索功能
    public List<OrderAll> findOrderInfo(OrderByOpQuery orderByOpQuery);//查找订单信息
    public List<OrderAll> findOperatorJobInfo(OperatorJobQuery operatorJobQuery);//查找操作量信息
    public Integer setOpIncome(OperatorInfo operatorInfo); //更新操作员收入
}
