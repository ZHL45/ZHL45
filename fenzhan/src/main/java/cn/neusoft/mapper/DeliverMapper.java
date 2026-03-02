package cn.neusoft.mapper;

import cn.neusoft.domain.fenzhan.Deliver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliverMapper {
    Integer add(Deliver deliver);
    Integer update(String string);
}
