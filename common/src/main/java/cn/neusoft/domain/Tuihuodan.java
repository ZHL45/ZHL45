package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tuihuodan {
    // 供应商、商品编码、商品名称、进货数量、现库存量
    String o_id;
    String offerer;
    String p_id;
    String  p_name;
    String  jinhuo_num;
    String xiancun_num;
    String oReturntuihuo_num;

}
