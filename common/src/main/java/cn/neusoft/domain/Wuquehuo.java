package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wuquehuo {
    // 商品名称、订单号、客户名、订购总额、订购日期、订单状态

    String c_name;               // 客户名
    String c_id;                // 客户编号
    String c_mTele;            // 移动电话
    String c_identity;             // 身份证号
    String p_amount;                 // 订购总额


}
