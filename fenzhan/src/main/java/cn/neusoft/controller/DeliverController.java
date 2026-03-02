package cn.neusoft.controller;

import cn.neusoft.domain.fenzhan.Deliver;
import cn.neusoft.service.imp.DeliverServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
/*
add(Deliver deliver):为订单添加配送员
 */
@RestController
@RequestMapping("/deliver")
@Api(description = "配送员")
public class DeliverController {
    @Autowired
    DeliverServiceImp deliverServiceImp;

    @PostMapping        //Post +/deliver
    @ApiOperation("为订单添加配送员  传入参数：订单号taskid、配送员姓名postman")
    public ResultBean add(@RequestBody Deliver deliver)
    {
        if(deliver.getTaskdate()==null)
        {
            deliver.setTaskdate(new Date());
        }
        System.out.println(deliverServiceImp.update(deliver.getTaskid().toString()));
        return ResultBean.success(deliverServiceImp.add(deliver));

    }
}
