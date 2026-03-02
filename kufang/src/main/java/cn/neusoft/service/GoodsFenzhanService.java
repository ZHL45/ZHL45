package cn.neusoft.service;

import cn.neusoft.domain.kufang.ChuKuDan;
import cn.neusoft.domain.kufang.GetGoods;
import cn.neusoft.domain.kufang.GoodsFenzhan;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.packaging.Goods_find;

import java.util.List;

public interface GoodsFenzhanService {
    Integer add(GoodsFenzhan goodsFenzhan);//入库
    Integer add_follow1(GoodsFenzhan goodsFenzhan);//入库绑定函数
    Integer add2(GoodsFenzhan goodsFenzhan);//出库
    List<GoodsFenzhan> findbypage(GoodChangeFind goodChangeFind);//模糊搜索+分页查询（日期+类型为购货入库）
    List<GoodsFenzhan> findbypage2(GoodChangeFind goodChangeFind);//模糊搜索+分页查询（日期+类型为调拨出库）、

    Integer updatestate(String integer);//订单状态转化
    Integer updatestate2(String integer);//订单状态转化
    List<GetGoods> findbypage4(Goods_find goods_find);//领货查询
    Integer updatevo(String integer);

}
