package cn.neusoft.mapper;

import cn.neusoft.domain.*;
import cn.neusoft.query.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuehuodiaohuoMapper {
    List<Quehuojinhuo> lackFindByPage(QuehuoQuery quehuoQuery);

    Integer deleteyujing();
    Integer fuzhiyujing();

    Integer deletelack();
    Integer addlack1();
    Integer addlack2();
    Integer setquehuo();

    Integer set(String o_id);
    Integer setkufang(int cid,int jinhuo_num);
    Integer jinhuodan(JinhuoQuery jinhuoQuery);

    JinhuoQuery selectByName(String cname);

    List<Tuihuodan> findByPage(TuihuodanQuery tuihuodanQuery);

    Integer tuihuo(String o_id,String tuihuo_num);

    Integer editState(String o_id);

    Integer selectTuiNum(String p_name);

}
