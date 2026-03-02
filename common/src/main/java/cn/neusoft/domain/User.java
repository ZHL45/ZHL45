package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
分站数据库登录管理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String id;//账号
    String psd;//密码
    Integer role;//角色类型
    String phone;//手机号
}
