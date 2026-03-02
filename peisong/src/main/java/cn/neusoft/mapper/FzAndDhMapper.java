package cn.neusoft.mapper;

import cn.neusoft.domain.*;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.DingdanpaihangQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FzAndDhMapper {
    List<Dingdanpaihang> findByPage(DingdanpaihangQuery dingdanpaihangQuery);
}
