package cn.neusoft.controller;

import cn.neusoft.domain.OperatorInfo;
import cn.neusoft.domain.order.OperatorJob;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.query.OperatorInfoQuery;
import cn.neusoft.query.OperatorJobQuery;
import cn.neusoft.query.OrderByOpQuery;
import cn.neusoft.service.impl.OperatorServiceImpl;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
add(Bill bill):添加记录
 */

@Api(value = "操作员信息模块的API",description = "操作员信息相关的CRUD功能")
@RestController
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    OperatorServiceImpl operatorServiceimpl;

    @PostMapping
    @ApiOperation(value = "操作员信息的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody OperatorInfoQuery operatorInfoQuery)
    {
        PageQueryBean<OperatorInfo> pageQueryBean = operatorServiceimpl.findByPage(operatorInfoQuery);
        return ResultBean.success(pageQueryBean);
    }

    @PostMapping("/findOrderInfo")
    @ApiOperation(value = "操作员名下的订单信息查询+模糊条件查询")
    public ResultBean findOrderInfo(@RequestBody OrderByOpQuery orderByOpQuery){
        List<OrderAll> orderAllList = operatorServiceimpl.findOrderInfo(orderByOpQuery);
        System.out.println(orderAllList.size());
        return ResultBean.success(orderAllList);
    }

    @PostMapping("/findOperateInfo")
    @ApiOperation(value = "操作员名下的操作量查询")
    public ResultBean findOperateInfo(@RequestBody OperatorJobQuery operatorJobQuery){

        String date = operatorJobQuery.getStartTime();
        if(date != null){
            System.out.println("时间：" + date);
            String time1 = date.substring(0,10);
            String time2 = date.substring(11,19);
            String time3 = time1 + " " + time2;
//        System.out.println(time1 + " " + time2);
            operatorJobQuery.setStartTime(time3);
        }

        String date2 = operatorJobQuery.getEndTime();
        if(date2 != null){
            System.out.println("时间：" + date);
            String time4 = date2.substring(0,10);
            String time5 = date2.substring(11,19);
            String time6 = time4 + " " + time5;
//        System.out.println(time1 + " " + time2);
            operatorJobQuery.setEndTime(time6);
        }

        List<OperatorJob> operatorJobList = operatorServiceimpl.findOperatorJobInfo(operatorJobQuery);
        System.out.println(operatorJobList.size());
        return ResultBean.success(operatorJobList);
    }


}
