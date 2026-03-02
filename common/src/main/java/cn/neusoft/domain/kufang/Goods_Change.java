package cn.neusoft.domain.kufang;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*
中心库房
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods_Change {
    String allocateid;//调拨单号
    String cid;//商品代码
    String cname;//商品名称
    String measure_unit;//计量单位
    Integer cnum;//出库数量
    String tid;//任务号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date date;//日期
    String station;//中心or分站
}
