package cn.neusoft.mapper;

import cn.neusoft.domain.kufang.Goods_Total;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsTotalMapper {
    Integer add(Goods_Total goodsTotal);//记录商品编号、增加或减少商品数量
    Integer first(Goods_Total goodsTotal);//初始化
    Goods_Total findbyid(Goods_Total goodsTotal);//通过id查找
}
