package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.Peisong_ku;
import cn.neusoft.mapper.OffererMapper;
import cn.neusoft.domain.Offerer;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.OffererQuery;
import cn.neusoft.service.OffererService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffererServiceImp implements OffererService {
    @Autowired
    OffererMapper offererMapper;
    @Override
    public Integer add(Offerer offerer){
        return offererMapper.add(offerer);
    }

    public Integer edit(Offerer offerer){
        return offererMapper.edit(offerer);
    }

    public Offerer search(String cname){
        return offererMapper.search(cname);
    }

    public Integer delete(String cname){
        return offererMapper.delete(cname);
    }

    public PageQueryBean<Offerer> findByPage(OffererQuery offererQuery){
        //构建结果对象
        PageQueryBean<Offerer> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(offererQuery.getPageNow(),offererQuery.getPageSize());
        //获得当页集合
        List<Offerer> OffererList = offererMapper.findByPage(offererQuery);
        //创建一个分页的实体PageInfo
        PageInfo<Offerer> pageInfo = new PageInfo<>(OffererList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;

    }
}
