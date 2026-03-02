package cn.neusoft.mapper;


import cn.neusoft.domain.Diaobo_order;
import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.query.DiaoboMohuQuery;
import cn.neusoft.query.DiaoduOrderQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDiaoboMapper {
    Diaobo_order search(String id);//  搜索
    Integer edit(Diaobo_order diaoboOrder);
    Integer add(Diaobo_order diaoboOrder);
    Integer delete(String id);

    List<Diaobo_order> findByPage(DiaoboMohuQuery diaoboMohuQuery);

}
