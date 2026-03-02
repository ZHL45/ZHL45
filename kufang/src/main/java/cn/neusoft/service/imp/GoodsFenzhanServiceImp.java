package cn.neusoft.service.imp;

import cn.neusoft.domain.kufang.ChuKuDan;
import cn.neusoft.domain.kufang.GetGoods;
import cn.neusoft.domain.kufang.GoodsFenzhan;
import cn.neusoft.mapper.GoodsFenzhanMapper;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.packaging.Goods_find;
import cn.neusoft.service.GoodsFenzhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsFenzhanServiceImp implements GoodsFenzhanService {
    @Autowired
    GoodsFenzhanMapper goodsFenzhanMapper;

    @Override
    public Integer add(GoodsFenzhan goodsFenzhan) {
        return goodsFenzhanMapper.add(goodsFenzhan);
    }

    @Override
    public Integer add_follow1(GoodsFenzhan goodsFenzhan) {
        return goodsFenzhanMapper.add_follow1(goodsFenzhan);
    }

    @Override
    public Integer add2(GoodsFenzhan goodsFenzhan) {
        return goodsFenzhanMapper.add2(goodsFenzhan);
    }

    @Override
    public List<GoodsFenzhan> findbypage(GoodChangeFind goodChangeFind) {
        return goodsFenzhanMapper.findbypage(goodChangeFind);
    }

    @Override
    public List<GoodsFenzhan> findbypage2(GoodChangeFind goodChangeFind) {
        return goodsFenzhanMapper.findbypage2(goodChangeFind);
    }

    @Override
    public Integer updatestate(String integer) {
        return goodsFenzhanMapper.updatestate(integer);
    }

    public Integer updatestate2(String integer) {
        return goodsFenzhanMapper.updatestate2(integer);
    }

    @Override
    public List<GetGoods> findbypage4(Goods_find goods_find) {
        return goodsFenzhanMapper.findbypage4(goods_find);
    }

    @Override
    public Integer updatevo(String integer) {
        return goodsFenzhanMapper.updatestate2(integer);
    }
}


