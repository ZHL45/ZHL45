package cn.neusoft.service;

import cn.neusoft.domain.fenzhan.TaskList;
import cn.neusoft.domain.fenzhan.OrderAll;
import cn.neusoft.domain.fenzhan.TaskList2;
import cn.neusoft.packaging.TaskFind;

import java.util.List;

public interface TaskListService {
    List<TaskList2> findbypagediaodu(TaskFind taskFind);//分页搜索+模糊查询

}
