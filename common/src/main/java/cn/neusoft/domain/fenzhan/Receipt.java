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
回执管理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt extends PageBean {
    String tid=null;//任务单号
    String hname=null;//姓名
    String hphone=null;//联系电话
    String tstation=null;//任务分站
    String ttype=null;//任务类型
    String addr=null;//送货地址
    String pman=null;//配送员
    String cname=null;//商品名称
    Integer cunit=null;//单价
    Integer cnum=null;//商品数量
    Integer summoney=null;//总额
    String tstate=null;//任务状态
    Integer billnum=null;//发票号
    String note=null;//备注
    String satisfaction;//客户满意度
    String backaddr=null;//退货地址
    String backcname=null;//退货商品名称
    Integer backcnum=null;//退货数量
    Integer backmoney=null;//退货金额
    Float price;//单价
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("客户要求完成时间，格式 yyyy-MM-dd HH:mm:ss")
    Date date;//要求完成日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("查询起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date start;//要求完成日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("查询终止时间，格式 yyyy-MM-dd HH:mm:ss")
    Date end;//要求完成日期



    String billnum1;//发票号
}
