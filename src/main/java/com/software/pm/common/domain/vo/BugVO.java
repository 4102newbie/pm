package com.software.pm.common.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName BugVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-26 下午 01:45
 **/
@Data
public class BugVO {
    // Bug id
    private String id;
    // Bug名称
    private String name;
    // 截止日期
    @JSONField(format = "yyyy-MM-dd")
    private Date deadline;
    // 指派给
    private String realname;
    // 由谁创建
    private String createBy;
    // 由谁关闭
    private String closedBy;
}
