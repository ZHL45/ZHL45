package cn.neusoft.service.imp;

import cn.neusoft.domain.kufang.Goods;
import cn.neusoft.mapper.GoodsMapper;
import cn.neusoft.packaging.Goods_find;
import cn.neusoft.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public Integer add(Goods goods) {
        return goodsMapper.add(goods);
    }

    @Override
    public Goods findbyid(Goods goods) {
        return goodsMapper.findbyid(goods);
    }

    @Override
    public Integer update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public List<Goods> findbypage(Goods_find goods_find) {
        return goodsMapper.findbypage(goods_find);
    }

}
