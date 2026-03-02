package cn.neusoft.service.imp;

import cn.neusoft.domain.kufang.Goods_Total;
import cn.neusoft.mapper.GoodsTotalMapper;
import cn.neusoft.service.GoodsTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsTotalServiceImp implements GoodsTotalService {
    @Autowired
    GoodsTotalMapper goodsTotalMapper;
    @Override
    public Integer add(Goods_Total goodsTotal) {
        return goodsTotalMapper.add(goodsTotal);
    }


    @Override
    public Integer first(Goods_Total goodsTotal) {
        return goodsTotalMapper.first(goodsTotal);
    }

    @Override
    public Goods_Total findbyid(Goods_Total goodsTotal) {
        return goodsTotalMapper.findbyid(goodsTotal);
    }
}
