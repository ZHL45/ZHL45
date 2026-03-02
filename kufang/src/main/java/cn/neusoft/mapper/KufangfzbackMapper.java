package cn.neusoft.mapper;

import cn.neusoft.domain.kufang.Kufangfzback;
import cn.neusoft.packaging.GoodChangeFind;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Mapper
public interface KufangfzbackMapper {
    Integer add(Kufangfzback kufangfzback);//分站库房添加退货项
    Integer add2(Kufangfzback kufangfzback);//中心库房添加退货项
    Integer add3(Kufangfzback kufangfzback);//中心库房退货给厂商
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
