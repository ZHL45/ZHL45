package cn.neusoft.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
在前端返回json数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> {
    private Integer code=200;
    private String msg="success";
    private T data;
    public static <T> ResultBean success()
    {
        return new ResultBean(200,"success",null);
    }

    public static <T> ResultBean success(String msg,T data)
    {
        return new ResultBean(200,msg,data);
    }

    public static <T> ResultBean success(T data)
    {
        return new ResultBean(200,"success",data);
    }

    public static <T> ResultBean success(String msg)
    {
        return new ResultBean(200,msg,null);
    }


    public static ResultBean fail(Integer integer,String msg)
    {
        return new ResultBean(integer,msg,null);
    }


    public static<T> ResultBean fail(Integer integer,String msg,T data)
    {
        return new ResultBean(integer,msg,data);
    }

    public static <T> ResultBean error(){
        return new ResultBean(500,"服务器内部异常",null);
    }

    public static <T> ResultBean error(Integer code,String msg){
        return new ResultBean(code,msg,null);
    }



}
