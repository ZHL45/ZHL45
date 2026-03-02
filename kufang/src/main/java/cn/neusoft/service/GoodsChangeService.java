package cn.neusoft.service;

import cn.neusoft.domain.kufang.*;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.packaging.Kf_change1_vo;

import java.util.List;

public interface GoodsChangeService {
    Integer add(Goods_Change goods_change);
    Integer add2(Goods_Change goods_change);

    Integer add_follow1(Goods_Change goods_change);//紧跟入库的捆绑函数
    Integer add_follow2(String o_id);
    Integer add2_follow1(Goods_Change goods_change);//紧跟入库的捆绑函数

    List<KufangGoods1> findbypage(GoodChangeFind goodChangeFind);
    List<Goods_Change> findbypage2(GoodChangeFind goodChangeFind);
    List<Goods_Change> findbypage3(GoodChangeFind goodChangeFind);

    Integer updatestate(String integer);
    ChuKuDan find(String allocateid);//打印单

    List<Kufang_change1> print(Kf_change1_vo kfChange1Vo);
    List<ChuKuDan> print1(Kf_change1_vo kfChange1Vo);
    Goods findgoods(String cid);
    String findc(String o_id);
}
