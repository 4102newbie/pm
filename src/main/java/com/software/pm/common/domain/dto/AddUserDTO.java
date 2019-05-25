package com.software.pm.common.domain.dto;

import lombok.Data;

/**
 * @ClassName AddUserDTO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-20 上午 11:14
 **/
@Data
public class AddUserDTO {

    // 创建人id
    private String id;
    // 账户
    private String account;
    // 密码
    private String password1;
    // 姓名
    private String realname;
    // 入职日期
    private String join;
    // 职位
    private String role;
    // 性别
    private String gender;
    // 创建人登录密码
    private String verifyPassword;
}
