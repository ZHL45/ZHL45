package cn.neusoft.controller;

import cn.neusoft.domain.BillInfo;
import cn.neusoft.query.BillInfoQuery;
import cn.neusoft.service.impl.BillInfoServiceImpl;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 */

@Api(value = "发票信息模块的API",description="发票信息相关的CRUD功能")
@RestController
@RequestMapping("/billInfo")
public class BillInfoController {
    @Autowired
    BillInfoServiceImpl billInfoServiceimpl;

    @PostMapping
    @ApiOperation(value = "新增发票信息")
    public ResultBean add(@RequestBody BillInfo billInfo)
    {
        return ResultBean.success(billInfoServiceimpl.add(billInfo));
    }

    @PostMapping("/findByBatch/{batch}")
    @ApiOperation(value = "获取发票详细信息")
    public ResultBean findByBatch(@PathVariable("batch") int batch)
    {
        return ResultBean.success(billInfoServiceimpl.findByBatch(batch));
    }

    @PostMapping("/findByPage")
    @ApiOperation(value = "发票信息的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody BillInfoQuery billInfoQuery)
    {
        PageQueryBean<BillInfo> pageQueryBean = billInfoServiceimpl.findByPage(billInfoQuery);
        return ResultBean.success(pageQueryBean);
    }

}
