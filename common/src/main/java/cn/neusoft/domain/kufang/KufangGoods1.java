package cn.neusoft.domain.kufang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KufangGoods1  {
    String o_id;
    Integer cid;
    String cname;
    String first_classification;
    String second_classification;
    String measure_unit;
    String jinhuo_num;
    String tuihuo_num;
    String offerer;
    Integer original_price;
    Float  discount;
    Float  cost;
    String model;
    String factory;
    String period;
    String if_back;
    String if_change;
    String remark;
    String is_jinhuo;
    String is_jiesuan;
    String is_tuihuo;
}
