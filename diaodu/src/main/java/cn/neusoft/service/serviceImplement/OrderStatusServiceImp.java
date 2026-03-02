package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.domain.EditOrderStatus;
import cn.neusoft.domain.Quehuofanhui;
import cn.neusoft.domain.Wuquehuo;
import cn.neusoft.mapper.OrderStatusMapper;
import cn.neusoft.query.ClientQuehuoQuery;
import cn.neusoft.query.DiaoduOrderQuery;
import cn.neusoft.service.OrderStatusService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImp implements OrderStatusService {
    @Autowired
    OrderStatusMapper orderStatusMapper;
    @Override
    public EditOrderStatus search(String id) {
        return orderStatusMapper.search(id);
    }
    public Integer check(String clientname) {
        return orderStatusMapper.check(clientname);
    }
    public List<Quehuofanhui> show(){
        return orderStatusMapper.show();
    }

   public Integer edit(String o_id){
       System.out.println("订单号是"+o_id);
        return orderStatusMapper.edit(o_id);
   }

    //  有缺货的客户
    public PageQueryBean<Quehuofanhui> findByPage1(ClientQuehuoQuery clientQuehuoQuery){
        //构建结果对象
        PageQueryBean<Quehuofanhui> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(clientQuehuoQuery.getPageNow(),clientQuehuoQuery.getPageSize());
        //获得当页集合
        List<Quehuofanhui> diaoduculueList = orderStatusMapper.findByPage1(clientQuehuoQuery);

        //创建一个分页的实体PageInfo
        PageInfo<Quehuofanhui> pageInfo = new PageInfo<>(diaoduculueList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }

    //  无缺货的客户
    public PageQueryBean<Wuquehuo> findByPage2(ClientQuehuoQuery clientQuehuoQuery){
        //构建结果对象
        PageQueryBean<Wuquehuo> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(clientQuehuoQuery.getPageNow(),clientQuehuoQuery.getPageSize());
        //获得当页集合
        List<Wuquehuo> diaoduculueList = orderStatusMapper.findByPage2(clientQuehuoQuery);

        //创建一个分页的实体PageInfo
        PageInfo<Wuquehuo> pageInfo = new PageInfo<>(diaoduculueList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }
}
