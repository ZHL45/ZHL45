package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.KucunTuihuo;
import cn.neusoft.domain.Peisong_ku;
import cn.neusoft.mapper.KufangMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.KucunQuery;
import cn.neusoft.query.KufangaChaxunQuery;
import cn.neusoft.service.kufangService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class kufangServiceImp implements kufangService {
    @Autowired
    KufangMapper kufangMapper;
    @Override
    public Integer add(Peisong_ku peisongKufang){
        return kufangMapper.add(peisongKufang);
    }

    public Integer edit(Peisong_ku peisongKufang){
        return kufangMapper.edit(peisongKufang);
    }

    public Peisong_ku search(String cname){
        return kufangMapper.search(cname);
    }

    public PageQueryBean<Peisong_ku> findByPage(BaseQuery query){
        //构建结果对象
        PageQueryBean<Peisong_ku> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<Peisong_ku> kufangList = kufangMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<Peisong_ku> pageInfo = new PageInfo<>(kufangList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;

    }
    public Integer delete(String cname){
        return kufangMapper.delete(cname);
    }


    public PageQueryBean<KucunTuihuo> kucun(KucunQuery query){

        //构建结果对象
        PageQueryBean<KucunTuihuo> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<KucunTuihuo> kucunList = kufangMapper.kucun(query);
        //创建一个分页的实体PageInfo
        PageInfo<KucunTuihuo> pageInfo = new PageInfo<>(kucunList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;

    }

}
