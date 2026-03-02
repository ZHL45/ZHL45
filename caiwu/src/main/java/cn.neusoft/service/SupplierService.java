package cn.neusoft.service;

import cn.neusoft.domain.Supplier;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.vo.PageQueryBean;

public interface SupplierService {
    Integer delete(String id);
    Integer jiesuan(String id);
    PageQueryBean<Supplier> findByPage(BaseQuery query);
}
