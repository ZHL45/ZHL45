package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.fenzhan.TaskList2;
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
    public List<TaskList2> findbypagediaodu(TaskFind taskFind) {
        List<TaskList2> list = taskListMapper.findbypagediaodu(taskFind);
        int b=0;
        for (int a=0;a<list.size();a++){
            if (b==0){
                list.get(a).setDeliver("张十三");
                b+=1;
            }else {
                list.get(a).setDeliver("李十四");
                b-=1;
            }
        }
        System.out.println(list);
        return list;
    }




}
