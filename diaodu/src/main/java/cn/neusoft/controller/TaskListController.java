package cn.neusoft.controller;


import cn.neusoft.packaging.TaskFind;
import cn.neusoft.service.serviceImplement.TaskListServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasklist")
@Api(description = "任务单列表相关功能")
public class TaskListController {
    @Autowired
    TaskListServiceImp taskListServiceImp;
    @PostMapping("/findbypage")
    @ApiOperation("传入参数：起始时间start、结束时间end、任务类型type、任务状态state、当前页pageNow、每页数据数量pageSize")
    public ResultBean findbypage(@RequestBody TaskFind taskFind)
    {
        return ResultBean.success(taskListServiceImp.findbypagediaodu(taskFind));
    }

}
