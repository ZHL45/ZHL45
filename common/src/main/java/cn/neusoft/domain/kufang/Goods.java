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
对应库房的数据库表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods extends PageBean {
    String cid;//商品代码
    String cname;//商品名称
    String first_classification;//商品一级分类
    String second_classification;//商品二级分类
    String measure_unit;//计量单位
    Integer cnum;//库存量
    String offerer;//供应商
    String note;//备注信息
    Integer original_price;//原价
    Float discount;//商品折扣
    Integer cost;//成本价
    String model;//型号
    String factory;//厂商
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date period;//保质期限
    String if_back;//可否退货
    String if_change;//可否换货
    String type;//购货类型
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date time;//入库时间
}
