package com.software.pm.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Bug
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-24 下午 06:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bug implements Serializable {
    private static final long serialVersionUID = 1L;

    //BugID
    private String id;
    //关联产品
    private String productId;
    //关联项目
    private String projectId;
    //关联任务
    private String taskId;
    //Bug名称
    private String name;
    //截止日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date deadline;
    // Bug描述
    private String description;
    //由谁创建
    private String createdBy;
    //创建日期
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    //由谁解决
    private String resolvedBy;
    //何时解决
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date resolvedDate;
    //由谁关闭
    private String closedBy;
    //何时关闭
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date closedDate;
    //验证情况
    private String verification;
    //是否删除
    @JSONField(serialize = false)
    private String deleted;
}
