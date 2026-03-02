package cn.neusoft.domain.kufang;

import cn.neusoft.vo.PageBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
领货功能点，对应配送任务单数据库
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGoods extends PageBean {
    String allocateid;//调拨单号
    String order_num;//订单号
    String product_name;//商品名称
    String product_num;//商品数量
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd")
    Date date;//日期

}
