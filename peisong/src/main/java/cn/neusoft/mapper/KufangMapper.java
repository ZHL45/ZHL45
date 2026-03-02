package cn.neusoft.mapper;

import cn.neusoft.domain.KucunTuihuo;
import cn.neusoft.domain.Peisong_ku;
import cn.neusoft.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KufangMapper {
    Integer add(Peisong_ku peisongKufang);
    Integer edit(Peisong_ku peisongKufang);
    Peisong_ku search(String cname);
    Integer delete(String cname);
    List<KucunTuihuo> kucun(BaseQuery query);
    List<Peisong_ku> findByPage(BaseQuery query);
}
