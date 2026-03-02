package cn.neusoft.controller;

import cn.neusoft.domain.Chukumingxi;
import cn.neusoft.domain.Offerer;
import cn.neusoft.domain.Tuihuodan;
import cn.neusoft.domain.Zhongxin_yujing;
import cn.neusoft.query.*;
import cn.neusoft.service.serviceImplement.ChukudiaohuoServiceImp;
import cn.neusoft.service.serviceImplement.QuehuojinuhoServiceImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "配送模块的API",description="缺货进货相关的CRUD功能")
@RestController
@RequestMapping("/quehuojinhuo")
public class QuehuojinhuoController {

    @Autowired
    QuehuojinuhoServiceImp quehuojinuhoServiceImp;

    //
    @PostMapping("/lackFindByPage")
    @ApiOperation(value = "返回所有缺货商品+模糊查询分页展示")
    public ResultBean lackFindByPage(@RequestBody QuehuoQuery quehuoQuery)
    {

        return ResultBean.success(quehuojinuhoServiceImp.lackFindByPage(quehuoQuery));
    }



    @PostMapping("/jinhuodan/{o_id}/{cname}/{jinhuo_num}")
    @ApiOperation(value = "生成进货单（增添进数据库kufang_goods）")
    public ResultBean jinhuodan(@PathVariable("o_id")String o_id,@PathVariable("cname")String cname,@PathVariable("jinhuo_num")String jinhuo_num)
    {

        return ResultBean.success(quehuojinuhoServiceImp.jinhuodan(o_id,cname,jinhuo_num));
    }


    @PostMapping("/findByPage")
    @ApiOperation(value = "所有退货单+模糊条件查询")
    public ResultBean findByPage(@RequestBody TuihuodanQuery tuihuodanQuery)
    {
        PageQueryBean<Tuihuodan> pageQueryBean = quehuojinuhoServiceImp.findByPage(tuihuodanQuery);
        return ResultBean.success(pageQueryBean);
    }

    @PostMapping("/tuihuo/{o_id}/{tuihuo_num}")
    @ApiOperation(value = "退货")
    public ResultBean tuihuo(@PathVariable("o_id")String o_id, @PathVariable("tuihuo_num")String tuihuo_num)
    {
        return ResultBean.success(quehuojinuhoServiceImp.tuihuo(o_id,tuihuo_num));

    }
}
