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
分站库房退货
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kufangfzback extends PageBean {
    String allocateid;//调拨单号
    String o_id;//调拨单号
    String cid;//商品代码
    String cname;//商品名称
    String cunit;//计量单位
    Integer cnum;//出库数量
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date date;//日期
    String type;//退货出库
    String c_class;//商品分类

    String station;//分站名
    String offer;//供应商
}
