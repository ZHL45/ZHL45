package cn.neusoft.service;

import cn.neusoft.domain.kufang.KufangBack;
import cn.neusoft.domain.kufang.OrderReturn;
import cn.neusoft.vo.PageBean;

import java.util.List;

public interface KufangBackService {
    Integer add(KufangBack kufangBack);
    List<OrderReturn> findbypage(PageBean pageBean);//退货
}
