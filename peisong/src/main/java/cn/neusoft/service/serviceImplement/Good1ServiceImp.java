package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.Shangpin1;
import cn.neusoft.domain.Shangpin11;
import cn.neusoft.mapper.Good1listMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.service.Good1listService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Good1ServiceImp implements Good1listService {
    @Autowired
    Good1listMapper good1listMapper;
    @Override
    public Integer add(Shangpin1 shangpin1){
        System.out.println(shangpin1);
        return good1listMapper.add(shangpin1);
    }

    public Integer edit(Shangpin11 shangpin11){
        return good1listMapper.edit(shangpin11);
    }

    public Integer delete(String cid){
        return good1listMapper.delete(cid);
    }
    public PageQueryBean<Shangpin1> findByPage(BaseQuery query){
        //构建结果对象
        PageQueryBean<Shangpin1> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<Shangpin1> good1listList = good1listMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<Shangpin1> pageInfo = new PageInfo<>(good1listList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;

    }
}

