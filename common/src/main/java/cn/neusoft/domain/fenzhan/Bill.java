package cn.neusoft.domain.fenzhan;

import cn.neusoft.vo.PageBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
账单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends PageBean {
    Integer startnum;//开始号码
    Integer endnum;//结束号码
    Integer batch;//批次
    String opera;//操作
    String hname;//姓名
    String did;//订单号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date date;//录入时间

    Bill_find bill_find;//发票联查


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date date111;//录入时间


    String invoiceId;



    //    Test test;//模拟联查
}
