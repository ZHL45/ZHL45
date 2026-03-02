package cn.neusoft.service;

import cn.neusoft.domain.kufang.Goods;
import cn.neusoft.packaging.Goods_find;

import java.util.List;


public interface GoodsService {
    Integer add(Goods goods);
    Goods findbyid(Goods goods);
    Integer update(Goods goods);
    List<Goods> findbypage(Goods_find goods_find);

}
