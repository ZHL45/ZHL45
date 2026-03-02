package cn.neusoft.domain.order;

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
public class OrderAll {
    String o_id;
    String c_id;
    String op_id;
    String c_name;
    String p_type;
    String p_subtype;
    String p_name;
    int p_number;
    int p_amount;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty("创建时间，格式：yyyy-MM-dd HH:mm:ss")
//    Date o_date;
    String o_date;
    String o_address;
    String o_state;
    String o_Munit;
    int o_Uprice;
    String p_ins;
    String o_remark;
    String o_afterSales;
    String o_receiver;
    String o_recPhone;
    String o_postcode;
    String o_invoice;
}
