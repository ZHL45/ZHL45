package cn.neusoft.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    String o_id;
    int cid;
    String cname;
    String measure_unit;
    String jinhuo_num;
    String offerer;
    float original_price;
    float discount;
    float cost;
    String model;
    String factory;
    String period;
    String if_back;
    String if_change;
    String remark;
    String is_jinhuo;
    String is_jiesuan;
    String is_tuihuo;
    String tuihuo_num;

//    String s_name;
//    String p_name;
//    float p_Uprice;
//    int p_pNumber;
//    int p_rNumber;
//    int p_number;
//    float p_amount;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty("创建时间，格式：yyyy-MM-dd HH:mm:ss")
//    Date date;
//    String state;
}
