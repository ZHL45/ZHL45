package cn.neusoft.service;

import cn.neusoft.domain.kufang.Kufangfzback;
import cn.neusoft.packaging.GoodChangeFind;

import java.util.Date;
import java.util.List;

public interface KufangfzbackService {
    Integer add(Kufangfzback kufangfzback);//退货到分站库房
    Integer add2(Kufangfzback kufangfzback);//退货到中心库房
    Integer add3(Kufangfzback kufangfzback);//中心库房出库
    Integer add4(String integer);//

    List<Kufangfzback> findbypage(GoodChangeFind goodChangeFind);//在分站库房中分页查询+模糊搜索
    List<Kufangfzback> findbypage2(GoodChangeFind goodChangeFind);//在中心库房中分页查询+模糊搜索
    List<Kufangfzback> findbypage3(GoodChangeFind goodChangeFind);//在中心库房退货给厂商中分页查询+模糊搜索
    List<Kufangfzback> findbypage4(GoodChangeFind goodChangeFind);//在中心库房退货给厂商中分页查询+模糊搜索
    Integer add_follow(String o_id);
    Integer add2_follow(String test);
    Integer add3_follow(String test);
    Integer findcid(String cname);
    String findcunit(String cname);
    String findclass(String cname);

    Date finddate(String o_l_id);
    Integer uptui(Kufangfzback kufangfzback);
}
