package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.Diaobo_order;
import cn.neusoft.domain.DiaoduShowXiangqing;
import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.mapper.OrderlistMapper;
import cn.neusoft.query.DiaoduOrderQuery;
import cn.neusoft.service.OrderlistService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderlistServiceImp implements OrderlistService {
    @Autowired
    OrderlistMapper orderlistMapper;
    @Override
    public DiaoduShowXiangqing search(String id) {
        return orderlistMapper.search(id);
    }

    @Override
    public DiaoduShowXiangqing show(String oid) {
        return orderlistMapper.show(oid);
    }

    public Integer shoudong(String p_id,String fzname) {
        // 改分站名
        int a = orderlistMapper.shoudong(p_id,fzname);
        // 改o_state状态
        int b = orderlistMapper.editO_state(p_id);

        // 将已分配的分站那一行的信息增添到shangpin_diaobo里
        // 取出来
        Diaobo_order diaoboOrder = orderlistMapper.get(p_id);
        diaoboOrder.setChuku_kufang("中心库房");
        System.out.println(diaoboOrder);

        // 插入shangpin_diaobo里
        // 检查shangpin_diaobo里是否有这个主键
        int id = diaoboOrder.getD_id();
        String d_id = String.valueOf(id);
        int is_have = orderlistMapper.check2(d_id);
        if (is_have!=0){
            // 删除shangpin_diaobo里原有数据
            orderlistMapper.deleteid(d_id);
        }
        orderlistMapper.insert(diaoboOrder);
        return a ;
    }

    // 自动调度只能调度状态为可调度的商品，并且调度完成后只是把分站名显示在页面，不对数据库进行修改操作，真正修改数据库还得手动调度来确定？？？不一定
    public Integer autoDiaodu() {
        int a = orderlistMapper.autoDiaodu();

        // 先把shangpin_diaobo表所有信息删除了
        orderlistMapper.shanchu();

        // 将新信息赋值给新表（jia）shangpin_diaobo
        orderlistMapper.fuzhi();

        // 自动调度成功后，将刚刚的调度订单状态都设置为可分配，进而页面按钮全部变灰
        orderlistMapper.autoeditO_state();
        return a;
    }

    public Integer autoDiaodu2() {
        int a = orderlistMapper.autoDiaodu2();
        orderlistMapper.shanchu();
        // 重置自动调度成功后，将刚刚的成功调度订单状态都设置为可调度，变灰的按钮再次变绿
        orderlistMapper.redoAutoeditO_state();
        return a;
    }
    public PageQueryBean<DiaoduCulue> findByPage(DiaoduOrderQuery diaoduOrderQuery){
        //构建结果对象
        PageQueryBean<DiaoduCulue> pageQueryBean = new PageQueryBean<>();
        System.out.println("当前页:" + diaoduOrderQuery.getPageNow());
        System.out.println("总量:" + diaoduOrderQuery.getPageSize());
        //开启分页
        PageHelper.startPage(diaoduOrderQuery.getPageNow(),diaoduOrderQuery.getPageSize());
        //获得当页集合
        List<DiaoduCulue> diaoduculueList = orderlistMapper.findByPage(diaoduOrderQuery);

        //创建一个分页的实体PageInfo
        PageInfo<DiaoduCulue> pageInfo = new PageInfo<>(diaoduculueList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }
}
