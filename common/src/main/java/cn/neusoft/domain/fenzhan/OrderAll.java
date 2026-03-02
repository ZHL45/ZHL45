package cn.neusoft.domain.fenzhan;

import cn.neusoft.vo.PageBean;
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
public class OrderAll extends PageBean {
    String o_id;
    String c_id;
    String op_id;
    String c_name;
    String p_type;
    String p_subtype;
    String p_name;
    Integer p_number;
    Integer p_amount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间，格式：yyyy-MM-dd HH:mm:ss")
    Date o_date;
    String o_address;
    String o_state;
    String o_Munit;
    Integer o_Uprice;
    String p_ins;
    String o_remark;
    String o_afterSales;
    String o_receiver;
    String o_recPhone;
    String o_postcode;
    String o_invoice;

    String state;

    String station;
    String station_addr;
    String station_station;
    String station_phone;

    String khback;
    String khname;
//    、送货分站、分站地址、分站、电话、客户反馈、客户签名
}
