package cn.neusoft.mapper;

import cn.neusoft.domain.Offerer;
import cn.neusoft.domain.Peisong_ku;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.OffererQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OffererMapper {
    Integer add(Offerer offerer);
    Integer edit(Offerer offerer);
    Offerer search(String cname);
    Integer delete(String cname);

    List<Offerer> findByPage(OffererQuery query);
}
