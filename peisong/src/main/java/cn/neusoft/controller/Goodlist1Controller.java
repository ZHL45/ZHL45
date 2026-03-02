package cn.neusoft.controller;

import cn.neusoft.domain.Shangpin1;
import cn.neusoft.domain.Shangpin11;
import cn.neusoft.query.Goodlist1Query;
import cn.neusoft.service.serviceImplement.Good1ServiceImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/good1list")
@Api(value = "配送模块的API",description="商品列表1的CRUD功能")

public class Goodlist1Controller {

    @Autowired
    Good1ServiceImp good1ServiceImp;

    // 增加
    @PostMapping("/add")
    @ApiOperation(value = "新增商品列表1")
    public ResultBean add(@RequestBody Shangpin1 shangpin1)
    {
        String time = shangpin1.getPeriod();
        System.out.println("时间" + time);
        String time1 = time.substring(0,10);
        String time2 = time.substring(11,19);
        String time3 = time1 + " " + time2;
//        System.out.println(time1 + " " + time2);
        shangpin1.setPeriod(time3);
        return ResultBean.success(good1ServiceImp.add(shangpin1));
    }

    // 修改
    @PostMapping("/edit")
    @ApiOperation(value = "修改商品列表1")
    public ResultBean edit(@RequestBody Shangpin11 shangpin11)
    {

        return ResultBean.success(good1ServiceImp.edit(shangpin11));
    }

    @PostMapping("/findByPage")
    @ApiOperation(value = "商品列表1的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody Goodlist1Query goodlist1Query)
    {
        PageQueryBean<Shangpin1> pageQueryBean = good1ServiceImp.findByPage(goodlist1Query);
        return ResultBean.success(pageQueryBean);
    }

    @DeleteMapping("/{cid}")
    @ApiOperation(value = "删除商品列表1")
    public ResultBean delete(@PathVariable("cid")String cid)
    {
        return ResultBean.success(good1ServiceImp.delete(cid));
    }



}
