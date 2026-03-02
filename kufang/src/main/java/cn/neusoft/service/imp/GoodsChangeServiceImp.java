package cn.neusoft.service.imp;

import cn.neusoft.domain.kufang.*;
import cn.neusoft.mapper.GoodsChangeMapper;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.packaging.Kf_change1_vo;
import cn.neusoft.service.GoodsChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsChangeServiceImp implements GoodsChangeService {
    @Autowired
    GoodsChangeMapper goodsChangeMapper;
    @Override
    public Integer add(Goods_Change goods_change) {
        return goodsChangeMapper.add(goods_change);
    }

    @Override
    public Integer add2(Goods_Change goods_change) {
        return goodsChangeMapper.add2(goods_change);
    }

    @Override
    public Integer add_follow1(Goods_Change goods_change) {
        return goodsChangeMapper.add_follow1(goods_change);
    }

    @Override
    public Integer add_follow2(String o_id) {
        return goodsChangeMapper.add_follow2(o_id);
    }

    @Override
    public Integer add2_follow1(Goods_Change goods_change) {
        return goodsChangeMapper.add2_follow1(goods_change);
    }

    @Override
    public List<KufangGoods1> findbypage(GoodChangeFind goodChangeFind) {
        return goodsChangeMapper.findbypage(goodChangeFind);
    }

    @Override
    public List<Goods_Change> findbypage2(GoodChangeFind goodChangeFind) {
        return goodsChangeMapper.findbypage2(goodChangeFind);
    }

    @Override
    public List<Goods_Change> findbypage3(GoodChangeFind goodChangeFind) {
        return goodsChangeMapper.findbypage3(goodChangeFind);
    }

    @Override
    public Integer updatestate(String integer) {
        return goodsChangeMapper.updatestate(integer);
    }

    @Override
    public ChuKuDan find(String allocateid) {
        return goodsChangeMapper.find(allocateid);
    }

    @Override
    public List<Kufang_change1> print(Kf_change1_vo kfChange1Vo) {
        return goodsChangeMapper.print(kfChange1Vo);
    }

    @Override
    public List<ChuKuDan> print1(Kf_change1_vo kfChange1Vo) {
        return goodsChangeMapper.print1(kfChange1Vo);
    }

    @Override
    public Goods findgoods(String cid) {
        return goodsChangeMapper.findgoods(cid);
    }

    @Override
    public String findc(String o_id) {
        return goodsChangeMapper.findc(o_id);
    }

}
