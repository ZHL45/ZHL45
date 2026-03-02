package cn.neusoft.mapper;

import cn.neusoft.domain.kufang.*;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.packaging.Kf_change1_vo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsChangeMapper {
    Integer add(Goods_Change goods_change);//入库
    Integer add_follow1(Goods_Change goods_change);//紧跟入库的捆绑函数
    Integer add2(Goods_Change goods_change);//出库
    Integer add2_follow1(Goods_Change goods_change);//紧跟入库的捆绑函数


    List<KufangGoods1> findbypage(GoodChangeFind goodChangeFind);//模糊搜索+分页查询（日期+类型为购货入库）

    List<Goods_Change> findbypage2(GoodChangeFind goodChangeFind);//模糊搜索+分页查询（日期+类型为调拨出库）

    List<Goods_Change> findbypage3(GoodChangeFind goodChangeFind);//模糊搜索+分页查询（日期+商品名，不输入则默认全部）

    List<Goods_Change> print(GoodChangeFind goodChangeFind);//打印出库单

    Integer updatestate(String integer);//更改订单状态

    ChuKuDan find(String allocateid);//打印单
    List<Kufang_change1> print(Kf_change1_vo kfChange1Vo);//打印分发单

    List<ChuKuDan> print1(Kf_change1_vo kfChange1Vo);

    Goods findgoods(String cid);

    String findc(String o_id);
    Integer add_follow2(String o_id);

}
