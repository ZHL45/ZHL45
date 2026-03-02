package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quehuofanhui {
    // 商品名称、订单号、客户名、订购总额、订购日期、订单状态

    String  o_id;           // 订单号
    String p_name;            // 商品名称
    String c_name;               // 客户名
    String p_amount;                 // 订购总额
    String o_date;                  //  订购日期
    String o_state;             // 订单状态


}
