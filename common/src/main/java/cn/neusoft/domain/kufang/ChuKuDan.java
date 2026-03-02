package cn.neusoft.domain.kufang;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
出库单设计
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuKuDan {
    String allocateid;//调拨单号
    String cid;//商品编码
    String cname;//商品名称
    Integer cnum;//商品数量
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date date;//日期
    Goods goods;//联查

    Integer total;
    Integer sum;




}
