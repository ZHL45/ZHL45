package cn.neusoft.service;

import cn.neusoft.domain.kufang.Goods_Total;
import org.springframework.stereotype.Service;

@Service
public interface GoodsTotalService {
    Integer add(Goods_Total goodsTotal);//记录商品编号、增加商品数量
    Integer first(Goods_Total goodsTotal);//初始化
    Goods_Total findbyid(Goods_Total goodsTotal);//通过id查找
}
