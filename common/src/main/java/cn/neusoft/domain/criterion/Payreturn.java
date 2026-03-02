package cn.neusoft.domain.criterion;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payreturn {
    String class1;
    String cname;
    Integer cnum;//送货商品数量
    Integer cmoney;//收款额
    Integer backnum;//退回商品数量
    Integer backmoney;//退款额
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date o_date;
}
