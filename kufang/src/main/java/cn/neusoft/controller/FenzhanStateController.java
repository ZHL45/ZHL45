package cn.neusoft.controller;

import cn.neusoft.domain.fenzhan.FenzhanState;
import cn.neusoft.service.imp.FenzhanStateServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/state")
@Api(description = "内部接口，可忽略")
public class FenzhanStateController {
    @Autowired
    FenzhanStateServiceImp fenzhanStateServiceImp;
    @GetMapping("/update")
    public ResultBean update(FenzhanState fenzhanState)
    {
        if(fenzhanStateServiceImp.exist(fenzhanState.getTid())==1)//账号已存在，直接更新即可
        {
            return ResultBean.success(fenzhanStateServiceImp.update(fenzhanState));
        }
        return ResultBean.success(fenzhanStateServiceImp.add(fenzhanState));
    }
}
