package cn.neusoft.service;


import cn.neusoft.domain.fenzhan.Bill;
import cn.neusoft.domain.BillInfo;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.vo.PageQueryBean;

import java.util.List;

public interface BillInfoService {
    Integer add(BillInfo billInfo);

    List<Bill> findByBatch(int batch);

    PageQueryBean<BillInfo> findByPage(BaseQuery query);
}
