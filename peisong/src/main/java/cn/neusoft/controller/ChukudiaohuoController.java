package cn.neusoft.controller;

import cn.neusoft.domain.Chukumingxi;
import cn.neusoft.domain.ChukumingxiReturn;
import cn.neusoft.domain.Tuihuodan;
import cn.neusoft.domain.Zhongxin_yujing;
import cn.neusoft.query.ChurukuMinxiQuery;
import cn.neusoft.query.TuihuodanQuery;
import cn.neusoft.query.YujingQuery;
import cn.neusoft.service.serviceImplement.ChukudiaohuoServiceImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "配送模块的API",description="chu出库调货的CRUD功能")
@RestController
@RequestMapping("/chukuDiaohuo")
public class ChukudiaohuoController {

    @Autowired
    ChukudiaohuoServiceImp chukudiaohuoServiceImp;

    // 填购货表
    @PostMapping("/add")               //商品名称、商品id、商品数量
    @ApiOperation(value = "新增购货表")
    public ResultBean add(@RequestBody String p_name,String p_id,String num)
    {

        return ResultBean.success(chukudiaohuoServiceImp.add(p_name,p_id,num));
    }

    // 中心出库单明细
    @PostMapping("/zxchukudan")
    @ApiOperation(value = "查询中心出库单明细")
    public ResultBean zxchukudan(@RequestBody ChurukuMinxiQuery churukuMinxiQuery)
    {
        PageQueryBean<ChukumingxiReturn> pageQueryBean = chukudiaohuoServiceImp.zxchukudan(churukuMinxiQuery);
        return ResultBean.success(pageQueryBean);
    }

    // 修改预警值库存量
    @PostMapping("/editYujing")
    @ApiOperation(value = "修改预警值库存量")
    public ResultBean editYujing(@RequestBody Zhongxin_yujing zhongxinYujing)
    {
        return ResultBean.success(chukudiaohuoServiceImp.editYujing(zhongxinYujing));
    }

    @PostMapping("/findByPage")
    @ApiOperation(value = "模糊查询+展示商品预警值库存量")
    public ResultBean findByPage(@RequestBody YujingQuery yujingQuery)
    {
        PageQueryBean<Zhongxin_yujing> pageQueryBean = chukudiaohuoServiceImp.findByPage(yujingQuery);
        return ResultBean.success(pageQueryBean);
    }


}
