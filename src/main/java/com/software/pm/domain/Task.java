package com.software.pm.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Task
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-23 下午 07:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    //任务ID
    private String id;
    //关联项目
    private String projectId;
    //任务名称
    private String name;
    //开始日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date begin;
    //截止日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date end;
    //任务描述
    private String description;
    //由谁创建
    private String createdBy;
    //创建日期
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    //指派给
    private String assignedTo;
    //何时指派
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date assignedDate;
    //由谁完成
    private String finishedBy;
    //何时完成
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date finishedDate;
    //由谁取消
    private String canceledBy;
    //何时取消
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date canceledDate;
    //由谁关闭
    private String closedBy;
    //何时关闭
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date closedDate;
    //关闭原因
    private String closedReason;
    //是否删除
    @JSONField(serialize = false)
    private String deleted;
}
