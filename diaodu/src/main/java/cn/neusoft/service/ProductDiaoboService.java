package cn.neusoft.service;

import cn.neusoft.domain.Diaobo_order;

public interface ProductDiaoboService {
    Diaobo_order search(String id);
    Integer edit(Diaobo_order diaoboOrder);

    Integer add(Diaobo_order diaoboOrder);
    Integer delete(String id);

}
