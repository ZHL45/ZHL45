package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.Diaobo_order;
import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.mapper.ProductDiaoboMapper;
import cn.neusoft.query.DiaoboMohuQuery;
import cn.neusoft.query.DiaoduOrderQuery;
import cn.neusoft.service.ProductDiaoboService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDiaoboImp implements ProductDiaoboService {
    int x = 100;

    @Autowired
    ProductDiaoboMapper productDiaoboMapper;
    @Override
    public Diaobo_order search(String id) {
        return productDiaoboMapper.search(id);
    }

    public PageQueryBean<Diaobo_order> findByPage(DiaoboMohuQuery diaoboMohuQuery) {
        //构建结果对象
        PageQueryBean<Diaobo_order> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(diaoboMohuQuery.getPageNow(), diaoboMohuQuery.getPageSize());
        //获得当页集合
        List<Diaobo_order> diaoduculueList = productDiaoboMapper.findByPage(diaoboMohuQuery);

        //创建一个分页的实体PageInfo
        PageInfo<Diaobo_order> pageInfo = new PageInfo<>(diaoduculueList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }

    @Override
    public Integer edit(Diaobo_order diaoboOrder){
        return productDiaoboMapper.edit(diaoboOrder);
    }

    @Override
    public Integer add(Diaobo_order diaoboOrder){
//        diaoboOrder.setCnum(x);
//        diaoboOrder.setFirst_classification("456");
//        x=x+1;
//        return productDiaoboMapper.add(diaoboOrder);
        return 0;
    }

    @Override
    public Integer delete(String d_id){
        return productDiaoboMapper.delete(d_id);
    }
}
