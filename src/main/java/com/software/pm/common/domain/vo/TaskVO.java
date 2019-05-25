package com.software.pm.common.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName TaskVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-24 下午 04:13
 **/
@Data
public class TaskVO {
    // 任务id
    private String id;
    // 任务名称
    private String name;
    // 开始时间
    @JSONField(format = "yyyy-MM-dd")
    private Date begin;
    // 截止时间
    @JSONField(format = "yyyy-MM-dd")
    private Date end;
    // 指派给
    private String realname;
    // 完成时间
    @JSONField(format = "yyyy-MM-dd")
    private Date finishedDate;
    @JSONField(format = "yyyy-MM-dd")
    private Date canceledDate;
}
