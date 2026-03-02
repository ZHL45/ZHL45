package cn.neusoft.controller;

import cn.neusoft.domain.fenzhan.OrderAll;
import cn.neusoft.domain.fenzhan.TaskList;
import cn.neusoft.domain.test.Here;
import cn.neusoft.domain.test.Optition;
import cn.neusoft.packaging.TaskFind;
import cn.neusoft.service.imp.TaskListServiceImp;
import cn.neusoft.vo.ResultBean;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
        return ResultBean.success(taskListServiceImp.findbypage(taskFind));
    }
    @PostMapping("/findbypage2")
    @ApiOperation("传入参数：起始时间start、结束时间end、任务类型type、当前页pageNow、每页数据数量pageSize")

    public ResultBean findbypage2(@RequestBody TaskFind taskFind)
    {
        List<TaskList> taskLists=taskListServiceImp.findbypage2(taskFind);
        return ResultBean.success(taskLists);
    }
    @PostMapping("/findbypage3")
    @ApiOperation("传入参数：起始时间start、结束时间end当前页pageNow、每页数据数量pageSize")
    public ResultBean findbypage3(@RequestBody TaskFind taskFind)
    {
        return ResultBean.success(taskListServiceImp.findbypage3(taskFind));
    }
    @GetMapping("/print/{o_id}")
    @ApiOperation("打印签收单")
    public ResultBean print(@PathVariable("o_id") String o_id)
    {
        OrderAll orderAll=taskListServiceImp.print(o_id);
        orderAll.setStation("沈阳站");
        orderAll.setStation_addr("辽宁省沈阳市");
        orderAll.setStation_phone("18640967655");
        orderAll.setStation_station("-");
        orderAll.setKhback("-");
        orderAll.setKhname("-");
        return ResultBean.success(orderAll);
    }


    @GetMapping("/find/{o_id}")
    @ApiOperation("查询任务信息")
    public ResultBean find(@PathVariable("o_id") String o_id)
    {
        return ResultBean.success(taskListServiceImp.find12378(o_id));
    }



}
