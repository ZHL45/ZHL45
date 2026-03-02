package cn.neusoft.mapper;

import cn.neusoft.domain.fenzhan.TaskList;
import cn.neusoft.domain.fenzhan.OrderAll;
import cn.neusoft.domain.fenzhan.TaskList2;
import cn.neusoft.packaging.TaskFind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskListMapper {
    List<TaskList2> findbypagediaodu(TaskFind taskFind);//分页搜索+模糊查询

}
