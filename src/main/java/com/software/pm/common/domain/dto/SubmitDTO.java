package com.software.pm.common.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName SubmitDTO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-25 下午 02:32
 **/
@Data
public class SubmitDTO {
    // 提交用户
    private String userId;
    // 用户密码
    private String password;
    // 提交id
    private String id;
    // 提交关联id
    private String sec_id;
    // 提交时间（提供当前时间）
    private Date date;
    // 提交原因
    private String reason;

    public Date getDate() {
        return new Date();
    }
}
