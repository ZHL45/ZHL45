package cn.neusoft.query;

import lombok.Data;

@Data
public class JinhuoQuery extends BaseQuery{
    String o_id;
    int    cid;
    String cname;
    String first_classification;
    String second_classification;
    String measure_unit;
    String jinhuo_num;
    String tuihuo_num = "0";
    String offerer;
    int    original_price;
    float  discount;
    float   cost;
    String model;
    String factory;
    String period;
    String if_back;
    String if_change;
    String remark;
    String is_jinhuo = "未进货";
    String is_jiesuan = "未结算";
    String is_tuihuo = "未退货";
}
