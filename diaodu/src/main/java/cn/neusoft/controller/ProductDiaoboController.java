package cn.neusoft.controller;


import cn.neusoft.domain.Diaobo_order;
import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.query.DiaoboMohuQuery;
import cn.neusoft.service.serviceImplement.OrderlistServiceImp;
import cn.neusoft.service.serviceImplement.ProductDiaoboImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diaobo")
@Api(description = "调拨单相关功能")
public class ProductDiaoboController {

    @Autowired
    ProductDiaoboImp productDiaoboImp;

    // 条件查询    传订单号
    @PostMapping("/fingdbyPage")
    @ApiOperation(value = "分页展示所有调拨单+模糊查询")
    public ResultBean fingdbyPage(@RequestBody DiaoboMohuQuery diaoboMohuQuery)
    {
        PageQueryBean<Diaobo_order> pageQueryBean = productDiaoboImp.findByPage(diaoboMohuQuery);
        return ResultBean.success(pageQueryBean);
    }

    // 修改
    @PostMapping("/edit")
    @ApiOperation(value = "修改调拨单")
    public ResultBean edit(Diaobo_order diaoboOrder)
    {
        return ResultBean.success(productDiaoboImp.edit(diaoboOrder));
    }

//    // 新增调拨单
//    @GetMapping("/add")
//    @ApiOperation(value = "增添调拨单")
//    public ResultBean add(Diaobo_order diaoboOrder)
//    {
//        return ResultBean.success(productDiaoboImp.add(diaoboOrder));
//    }

    // 删除调拨单
    @DeleteMapping("/delete/{d_id}")
    @ApiOperation(value = "删除调拨单")
    public ResultBean delete(@PathVariable("d_id") String d_id)
    {
        return ResultBean.success(productDiaoboImp.delete(d_id));
    }
}
