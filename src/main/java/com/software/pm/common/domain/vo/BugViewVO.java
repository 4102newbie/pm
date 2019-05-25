package com.software.pm.common.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName BugViewVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-26 下午 03:31
 **/
@Data
public class BugViewVO {
    // bug名称
    private String bugName;
    // bug描述
    private String description;
    // 产品id
    private String productId;
    // 项目id
    private String projectId;
    // 任务id
    private String taskId;
    // 产品名称
    private String productName;
    // 项目名称
    private String projectName;
    // 任务名称
    private String taskName;
    // 由谁创建
    private String createdBy;
    // 创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    // 由谁解决
    private String resolvedBy;
    // 解决时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date resolvedDate;
    // 由谁关闭
    private String closedBy;
    // 关闭时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date closedDate;
    // 验证状态
    private Boolean verification;

    public void setVerification(String verification) {
        if ("TRUE".equals(verification)) {
            this.verification = true;
        } else {
            this.verification = false;
        }

    }
}
