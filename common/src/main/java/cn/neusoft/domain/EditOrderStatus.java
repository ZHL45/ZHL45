package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditOrderStatus extends PageBean {
    // 商品名称、订单号、客户名、订购总额、订购日期、地址、邮编、电话、到货状态

    String p_name;            // 商品名称
    int    o_id;           // 订单号
    String c_name;          // 用户名
    String p_amount;             //   总额
    String o_date;                // 送货日期
    String o_address;               // 地址
    String o_postcode;               // 邮编
    String o_recPhone;               // 电话
    String o_state;                 // 订单状态

}
