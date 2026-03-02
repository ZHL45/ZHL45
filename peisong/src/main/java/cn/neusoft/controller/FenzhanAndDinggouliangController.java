package cn.neusoft.controller;

import cn.neusoft.domain.Dingdanpaihang;
import cn.neusoft.domain.Peisong_ku;
import cn.neusoft.query.DingdanpaihangQuery;
import cn.neusoft.query.KufangaChaxunQuery;
import cn.neusoft.service.serviceImplement.FzAndDhServiceImp;
import cn.neusoft.service.serviceImplement.kufangServiceImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "配送模块的API",description="分站列表和订货量")
@RestController
@RequestMapping("/fz")
public class FenzhanAndDinggouliangController {

    @Autowired
    FzAndDhServiceImp fzAndDhServiceImp;

    @PostMapping("/findByPage")
    @ApiOperation(value = "订货量的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody DingdanpaihangQuery dingdanpaihangQuery)
    {
        List<Dingdanpaihang> pageQueryBean = fzAndDhServiceImp.findByPage(dingdanpaihangQuery);
        return ResultBean.success(pageQueryBean);
    }




}
