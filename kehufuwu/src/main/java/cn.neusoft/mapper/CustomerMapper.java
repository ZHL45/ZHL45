package cn.neusoft.mapper;

import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    Integer add(CustomerInfo customerInfo);//添加客户信息
    Integer delete(String id);//删除客户信息
    Integer update(CustomerInfo customerInfo);//修改客户信息
    public List<CustomerInfo> findByPage(BaseQuery query);//分页+模糊搜索功能
    public List<OrderAll> findById(String c_id);
    public CustomerInfo findId(String c_id);
}
