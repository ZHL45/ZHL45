package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zhongxin_yujing extends PageBean {
    // 订单号、订单类型、用户名、订单状态、送货日期、录入员、商品名称、商品数量、金额、收货人、地址、电话、邮编、执行任务分站、是否要发票、备注、分站}

    String p_name;
    String yujing;
    String maxStore;


}
