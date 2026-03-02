package cn.neusoft.controller;

import cn.neusoft.domain.KucunTuihuo;
import cn.neusoft.domain.Peisong_ku;
import cn.neusoft.query.KucunQuery;
import cn.neusoft.query.KufangaChaxunQuery;
import cn.neusoft.service.serviceImplement.kufangServiceImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "配送模块的API",description="库房的CRUD功能")
@RestController
@RequestMapping("/pskufang")
public class KufangController {

    @Autowired
    kufangServiceImp kufangServiceImp;

    // 增加
    @PostMapping("/add")
    @ApiOperation(value = "新增库房")
    public ResultBean add(@RequestBody Peisong_ku peisongKufang)
    {
        System.out.println(peisongKufang);
        return ResultBean.success(kufangServiceImp.add(peisongKufang));
    }

    // 修改
    @PostMapping("/edit")
    @ApiOperation(value = "修改库房")
    public ResultBean edit(@RequestBody Peisong_ku peisongKufang)
    {
        System.out.println(peisongKufang);
        return ResultBean.success(kufangServiceImp.edit(peisongKufang));
    }
    @PostMapping("/findByPage")
    @ApiOperation(value = "库房的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody KufangaChaxunQuery kufangaChaxunQuery)
    {
        PageQueryBean<Peisong_ku> pageQueryBean = kufangServiceImp.findByPage(kufangaChaxunQuery);
        return ResultBean.success(pageQueryBean);
    }


    @DeleteMapping("/{ku_name}")
    @ApiOperation(value = "删除库房")
    public ResultBean delete(@PathVariable("ku_name")String ku_name)
    {
        return ResultBean.success(kufangServiceImp.delete(ku_name));
    }



    @PostMapping("/kucun")
    @ApiOperation(value = "库存量分页展示+模糊条件查询")
    public ResultBean kucun(@RequestBody KucunQuery kucunQuery)
    {
        PageQueryBean<KucunTuihuo> pageQueryBean = kufangServiceImp.kucun(kucunQuery);
        return ResultBean.success(pageQueryBean);
    }


}
