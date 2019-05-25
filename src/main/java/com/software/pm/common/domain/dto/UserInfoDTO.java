package com.software.pm.common.domain.dto;

import lombok.Data;

import java.sql.Date;

/**
 * @ClassName UserInfoDTO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-19 上午 11:21
 **/
@Data
public class UserInfoDTO {

    //用户ID
    private String id;
    //原密码
    private String originalPassword;
    //新密码
    private String newPassword;
    //新密码(加密)
    private String password;
    //账号
    private String account;
    //职位
    private String role;
    //真实姓名
    private String realname;
    //姓名首字母
    private String avatar;
    //性别
    private String gender;
    //邮箱
    private String email;
    //手机
    private String mobile;
    //通讯地址
    private String address;
    //入职日期
    private String join;

}
