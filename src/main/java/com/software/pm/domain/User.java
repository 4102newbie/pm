package com.software.pm.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-16 下午 05:04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户ID
    private String id;
    //账号
    private String account;
    //密码
    @JSONField(serialize = false)
    private String password;
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
    @JSONField(format = "yyyy-MM-dd")
    private Date join;
    //是否删除
    @JSONField(serialize = false)
    private String deleted;
    //排序字段
    @JSONField(serialize = false)
    private Integer sort;

}
