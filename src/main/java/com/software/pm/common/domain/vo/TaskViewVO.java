package com.software.pm.common.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName TaskViewVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-24 下午 09:14
 **/
@Data
public class TaskViewVO {
    // 任务id
    private String id;
    // 任务名称
    private String name;
    // 任务描述
    private String description;
    // 项目id
    private String projectId;
    // 所属项目
    private String projectName;
    // 创建人
    private String create;
    // 创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    // 完成人
    private String finish;
    // 完成时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date finishedDate;
    // 取消人
    private String cancel;
    // 取消时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date canceledDate;
    // 关闭人
    private String close;
    // 关闭时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date closedDate;
    // 关闭原因
    private String closedReason;
    // 是否已经产生Bug
    private Boolean haveBug;

    public void setHaveBug(Integer haveBug) {
        if (0 == haveBug){
            this.haveBug = false;
        }else {
            this.haveBug = true;
        }
    }
}
