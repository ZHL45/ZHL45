package cn.neusoft.domain.fenzhan;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends OrderAll{
    String class1;
    String cname;
    Integer cnum;//送货商品数量
    Integer cmoney;//收款额
    Integer backnum;//退回商品数量
    Integer backmoney;//退款额

}
