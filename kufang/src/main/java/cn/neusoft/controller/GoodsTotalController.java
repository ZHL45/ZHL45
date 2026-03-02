package cn.neusoft.controller;

import cn.neusoft.domain.kufang.Goods_Total;
import cn.neusoft.service.imp.GoodsTotalServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/total")
@Api(description = "内部接口，不用管")
public class GoodsTotalController {
    @Autowired
    GoodsTotalServiceImp goodsTotalServiceImp;

    @GetMapping("/add")//入库
    public ResultBean add(Goods_Total goodstotal)
    {
        if(goodsTotalServiceImp.findbyid(goodstotal)==null)
        {
            return ResultBean.success(goodsTotalServiceImp.first(new Goods_Total(goodstotal.getCid(),goodstotal.getCnum())));//初始化

        }else
        {
            goodstotal.setCnum(goodstotal.getCnum()+goodsTotalServiceImp.findbyid(goodstotal).getCnum());
            return ResultBean.success(goodsTotalServiceImp.add(goodstotal));
        }
    }

    @GetMapping("/add2")//出库，出库前必须保证有库存且库存数大于取值
    public ResultBean add2(Goods_Total goodstotal)
    {
        goodstotal.setCnum(-1*goodstotal.getCnum()+goodsTotalServiceImp.findbyid(goodstotal).getCnum());
        return ResultBean.success(goodsTotalServiceImp.add(goodstotal));
    }
}
