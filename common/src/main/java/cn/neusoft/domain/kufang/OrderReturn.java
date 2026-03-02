package cn.neusoft.domain.kufang;


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
public class OrderReturn extends PageBean {
    String o_id;
    String o_l_id;
    String c_name;
    String p_name;
    int p_number;
    int p_amount;
    String o_reason;
    String o_address;
    String o_state;
    String c_class;

    String state;
    String cid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date date;
}
