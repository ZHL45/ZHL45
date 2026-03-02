package cn.neusoft.service.imp;

import cn.neusoft.domain.fenzhan.TaskList;
import cn.neusoft.domain.fenzhan.OrderAll;
import cn.neusoft.mapper.TaskListMapper;
import cn.neusoft.packaging.TaskFind;
import cn.neusoft.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskListServiceImp implements TaskListService {
    @Autowired
    TaskListMapper taskListMapper;
    @Override
    public List<TaskList> findbypage(TaskFind taskFind) {
        return taskListMapper.findbypage(taskFind);
    }

    @Override
    public List<TaskList> findbypage2(TaskFind taskFind) {
        return taskListMapper.findbypage2(taskFind);
    }

    @Override
    public List<TaskList> findbypage3(TaskFind taskFind) {
        return taskListMapper.findbypage3(taskFind);
    }

    @Override
    public OrderAll print(String o_id) {
        return taskListMapper.print(o_id);
    }

    @Override
    public OrderAll find12378(String o_id) {
        return taskListMapper.find12378(o_id);
    }

    @Override
    public List<OrderAll> all() {
        return taskListMapper.all();
    }


}
