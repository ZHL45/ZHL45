package cn.neusoft.domain.order;

import lombok.Data;

@Data
public class OrderSub {
    String o_substation;
    String p_type;
    String p_subtype;
    String p_name;
    String o_afterSales;
    String is_jiesuan;
    int p_number = 0;
    int p_amount = 0;
    int song_num = 0;
    float song_amount = 0;
    int tui_num = 0;
    float tui_amount = 0;
    float yingjiao = 0;
}
