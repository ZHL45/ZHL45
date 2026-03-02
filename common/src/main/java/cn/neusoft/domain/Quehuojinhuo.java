package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quehuojinhuo extends PageBean {
    // 商品分类、商品代码、商品名称、现有库存量、
    // 安全库存量(预警值)、缺货数量、计量单位、 日期

    String o_id;//
    String   cid;           // 商品代码
    String p_type;         //商品分类
    String p_name;          // 商品名称
    String cnum;              // 现有库存量
    String yujing;             // 安全库存量(预警值)、
    String lack_number;        // 缺货数量              ?
    String measure_unit;        // 计量单位
    String jinhuo_num;            // 进货量
    String date;                  //  日期


}
