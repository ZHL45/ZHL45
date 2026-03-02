package cn.neusoft.service.serviceImplement;

import ch.qos.logback.classic.pattern.SyslogStartConverter;
import cn.neusoft.domain.Chukumingxi;
import cn.neusoft.domain.ChukumingxiReturn;
import cn.neusoft.domain.Dingdanpaihang;
import cn.neusoft.domain.Zhongxin_yujing;
import cn.neusoft.mapper.ChukudiaohuoMapper;
import cn.neusoft.query.ChurukuMinxiQuery;
import cn.neusoft.query.DingdanpaihangQuery;
import cn.neusoft.query.YujingQuery;
import cn.neusoft.service.ChukudiaohuoService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ChukudiaohuoServiceImp implements ChukudiaohuoService {
    @Autowired
    ChukudiaohuoMapper chukudiaohuoMapper;
    @Override
    public Integer add(String p_name,String p_id,String num){
        return chukudiaohuoMapper.add(p_name,p_id,num);
    }

    @Override
    public PageQueryBean<ChukumingxiReturn> zxchukudan(ChurukuMinxiQuery churukuMinxiQuery){

        //构建结果对象
        PageQueryBean<ChukumingxiReturn> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(churukuMinxiQuery.getPageNow(),churukuMinxiQuery.getPageSize());
        //获得当页集合
        List<ChukumingxiReturn> dingdanpaihangList = chukudiaohuoMapper.zxchukudan(churukuMinxiQuery);

        //创建一个分页的实体PageInfo
        PageInfo<ChukumingxiReturn> pageInfo = new PageInfo<>(dingdanpaihangList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }

    @Override
    public Integer editYujing(Zhongxin_yujing zhongxinYujing){
        return chukudiaohuoMapper.editYujing(zhongxinYujing);
    }

    @Override
    public List<Zhongxin_yujing> getYujing(){
        return chukudiaohuoMapper.getYujing();
    }

    public PageQueryBean<Zhongxin_yujing> findByPage(YujingQuery yujingQuery){
        //构建结果对象
        PageQueryBean<Zhongxin_yujing> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(yujingQuery.getPageNow(),yujingQuery.getPageSize());
        //获得当页集合
        List<Zhongxin_yujing> dingdanpaihangList = chukudiaohuoMapper.findByPage(yujingQuery);

        //创建一个分页的实体PageInfo
        PageInfo<Zhongxin_yujing> pageInfo = new PageInfo<>(dingdanpaihangList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;

    }


}
