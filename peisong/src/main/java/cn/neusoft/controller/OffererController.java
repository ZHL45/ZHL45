package cn.neusoft.controller;

import cn.neusoft.domain.Offerer;
import cn.neusoft.query.OffererQuery;
import cn.neusoft.service.serviceImplement.OffererServiceImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offerer")
@Api(value = "配送模块的API",description="供应商的CRUD功能")
public class OffererController {

    @Autowired
    OffererServiceImp offererServiceImp;

    // 增加
    @PostMapping("/add")
    @ApiOperation(value = "增加供应商")
    public ResultBean add(@RequestBody Offerer offerer)
    {
        System.out.println(offerer);
        return ResultBean.success(offererServiceImp.add(offerer));
    }

    // 修改
    @PostMapping("/edit")
    @ApiOperation(value = "修改供应商")
    public ResultBean edit(@RequestBody Offerer offerer)
    {

        return ResultBean.success(offererServiceImp.edit(offerer));
    }


    @PostMapping("/findByPage")
    @ApiOperation(value = "供应商的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody OffererQuery offererQuery)
    {
        PageQueryBean<Offerer> pageQueryBean = offererServiceImp.findByPage(offererQuery);
        return ResultBean.success(pageQueryBean);
    }


    @DeleteMapping("/{cname}")
    @ApiOperation(value = "删除供应商")
    public ResultBean delete(@PathVariable("cname")String cname)
    {
        return ResultBean.success(offererServiceImp.delete(cname));
    }


}
