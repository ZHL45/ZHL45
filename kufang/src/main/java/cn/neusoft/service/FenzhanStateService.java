package cn.neusoft.service;

import cn.neusoft.domain.fenzhan.FenzhanState;

public interface FenzhanStateService {
    Integer add(FenzhanState fenzhanState);//添加数据
    Integer exist(String tid);//判断数据是否存在
    Integer update(FenzhanState fenzhanState);//更新状态
}
