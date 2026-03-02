package cn.neusoft.controller;

import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.query.CustomerInfoQuery;
import cn.neusoft.service.impl.CustomerServiceImpl;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 */

@Api(value = "客户信息模块的API",description="客户信息相关的CRUD功能")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceimpl;

    @PostMapping
    @ApiOperation(value = "新增客户信息")
    public ResultBean add(@RequestBody CustomerInfo customerInfo)
    {
        return ResultBean.success(customerServiceimpl.add(customerInfo));
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除客户信息")
    public ResultBean delete(@PathVariable("id") String id)
    {
        Integer integer= customerServiceimpl.delete(id);
        if(integer==1)
            return ResultBean.success("删除成功",null);
        return ResultBean.fail(500,"没有该记录");
    }

    @PostMapping("/findByPage")
    @ApiOperation(value = "客户信息的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody CustomerInfoQuery customerInfoQuery)
    {
        PageQueryBean<CustomerInfo> pageQueryBean = customerServiceimpl.findByPage(customerInfoQuery);
        return ResultBean.success(pageQueryBean);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "客户历史订单信息的查询")
    public ResultBean findById(@PathVariable("id") String c_id)
    {
        List<OrderAll> orderAllList = customerServiceimpl.findById(c_id);
        return ResultBean.success(orderAllList);
    }

    @GetMapping("/createId")
    @ApiOperation(value = "随机生成客户编号")
    public ResultBean findId()
    {
        return ResultBean.success(customerServiceimpl.getC_id());
    }

    @PutMapping
    @ApiOperation(value = "编辑客户信息")
    public ResultBean update(@RequestBody CustomerInfo customerInfo)
    {
        return ResultBean.success(customerServiceimpl.update(customerInfo));
    }


}
