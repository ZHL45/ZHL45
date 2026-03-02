package cn.neusoft.mapper;

import cn.neusoft.domain.kufang.Goods;
import cn.neusoft.packaging.Goods_find;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    Integer add(Goods goods);//添加
    Goods findbyid(Goods goods);//通过id查找，需输入cid
    Integer update(Goods goods);//更新库存数量，需输入新添加的数量cnum以及cid

    List<Goods> findbypage(Goods_find goods_find);//分页+模糊搜索
}
