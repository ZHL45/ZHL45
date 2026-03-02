package cn.neusoft.controller;


import cn.neusoft.domain.Supplier;
import cn.neusoft.domain.order.OrderSub;
import cn.neusoft.query.JobSubQuery;
import cn.neusoft.query.SupplierQuery;
import cn.neusoft.service.impl.SubstationServiceImpl;
import cn.neusoft.service.impl.SupplierServiceImpl;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "分站结算信息模块的Api",description = "分站结算信息相关的CRUD功能")
@RestController
@RequestMapping("/substation")
public class SubstationController {
    @Autowired
    SubstationServiceImpl substationServiceImpl;

    @PutMapping("/jiesuan")
    @ApiOperation(value = "分站信息结算")
    public ResultBean jiesuan(@RequestBody JobSubQuery jobSubQuery){
        return ResultBean.success("结算成功",substationServiceImpl.jiesuan(jobSubQuery));
    }

    @PostMapping("/findWeiByPage")
    @ApiOperation(value = "分站未结算信息的分页展示+模糊条件查询")
    public ResultBean findByWeiPage(@RequestBody JobSubQuery jobSubQuery)
    {
        String date = jobSubQuery.getStartTime();
        System.out.println(date == null);
        if(date != null){
            System.out.println("时间：" + date);
            String time1 = date.substring(0,10);
            String time2 = date.substring(11,19);
            String time3 = time1 + " " + time2;
            System.out.println(time3);
//        System.out.println(time1 + " " + time2);
            jobSubQuery.setStartTime(time3);
        }

        String date2 = jobSubQuery.getEndTime();
        if(date2 != null){
            System.out.println("时间：" + date2);
            String time4 = date2.substring(0,10);
            String time5 = date2.substring(11,19);
            String time6 = time4 + " " + time5;
            System.out.println(time6);
//        System.out.println(time1 + " " + time2);
            jobSubQuery.setEndTime(time6);
        }

        List<OrderSub> orderSubList = substationServiceImpl.findWeiByPage(jobSubQuery);
        return ResultBean.success(orderSubList);
    }

    @PostMapping("/findYiByPage")
    @ApiOperation(value = "分站已结算信息的分页展示+模糊条件查询")
    public ResultBean findYiByPage(@RequestBody JobSubQuery jobSubQuery)
    {
        String date = jobSubQuery.getStartTime();
        if(date != null){
            System.out.println("时间：" + date);
            String time1 = date.substring(0,10);
            String time2 = date.substring(11,19);
            String time3 = time1 + " " + time2;
//        System.out.println(time1 + " " + time2);
            jobSubQuery.setStartTime(time3);
        }

        String date2 = jobSubQuery.getEndTime();
        if(date2 != null){
            System.out.println("时间：" + date2);
            String time4 = date2.substring(0,10);
            String time5 = date2.substring(11,19);
            String time6 = time4 + " " + time5;
//        System.out.println(time1 + " " + time2);
            jobSubQuery.setEndTime(time6);
        }
        List<OrderSub> orderSubList = substationServiceImpl.findYiByPage(jobSubQuery);
        return ResultBean.success(orderSubList);
    }
}
