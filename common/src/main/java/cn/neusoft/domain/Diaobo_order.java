package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diaobo_order extends PageBean {
    // 商品调拨单号、出库库房、入库库房、商品分类 、商品名称、库存量、调拨数量、计量单位、要求出库日期
    Integer d_id;           // 调拨单号
    String chuku_kufang;         // 出库库房
    String ruku_kufang;          // 入库库房
    String p_sort;                 // 商品分类
    String p_name;                // 商品名称
    String diaobo_num;         // 调拨数量
    String unit;                  //  计量单位
    String o_date;             //     出库日期

}
