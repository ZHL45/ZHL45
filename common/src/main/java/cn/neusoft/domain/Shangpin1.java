package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shangpin1 extends PageBean {
    // 商品代码、商品名称、商品一级分类、商品二级分类、计量单位、原价、商品折扣、成本价、
    // 型号、供应商、厂商、保质期限、可否退货、可否换货、备注

    int  cid;
    String cname;
    String first_classification;
    String second_classification;
    String measure_unit;
    String factory;
    int    original_price;
    float  discount;
    int    cost;
    String model;
    String offerer;
    String period;
    String if_back;
    String if_change;
    String remark;


}
