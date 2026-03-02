package cn.neusoft.mapper;

import cn.neusoft.domain.Supplier;
import cn.neusoft.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierMapper {
    Integer delete(String id);
    Integer jiesuan(String id);
    List<Supplier> findByPage(BaseQuery query);
}
