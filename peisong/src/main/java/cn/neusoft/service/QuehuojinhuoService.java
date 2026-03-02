package cn.neusoft.service;

import cn.neusoft.domain.Chukumingxi;
import cn.neusoft.domain.ChukumingxiReturn;
import cn.neusoft.domain.Quehuojinhuo;
import cn.neusoft.domain.Zhongxin_yujing;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.QuehuoQuery;
import cn.neusoft.vo.PageQueryBean;

import java.util.List;

public interface QuehuojinhuoService {

    PageQueryBean<Quehuojinhuo> lackFindByPage(QuehuoQuery quehuoQuery);
}
