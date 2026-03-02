package cn.neusoft.mapper;

import cn.neusoft.domain.fenzhan.FenzhanState;
import org.apache.ibatis.annotations.Mapper;

/*
更改分站订单状态
 */
@Mapper
public interface FenzhanStateMapper {
    Integer add(FenzhanState fenzhanState);//添加数据
    Integer exist(String integer);//判断数据是否存在

    Integer update(FenzhanState fenzhanState);//更新状态

}
