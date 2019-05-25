package com.software.pm.common.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.software.pm.utils.DateUtils;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ProjectViewVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-26 下午 05:48
 **/
@Data
public class ProjectViewVO {
    // 项目名称
    private String name;
    // 项目代码
    private String code;
    // 项目描述
    private String description;
    // 关联产品id
    private String productId;
    // 产品名称
    private String productName;
    // 开始日期
    @JSONField(format = "yyyy-MM-dd")
    private Date begin;
    // 截止日期
    @JSONField(format = "yyyy-MM-dd")
    private Date end;
    // 可用工日
    private long days;
    // 激活任务数
    private Integer taskNum;
    // 未解决Bug数
    private Integer bugNum;
    // 关联任务
    private Boolean haveTask;

    public void setHaveTask(String haveTask) {
        if ("TRUE".equals(haveTask)) {
            this.haveTask = true;
        } else {
            this.haveTask = false;
        }
    }

    public long getDays() {
        return DateUtils.subtractDays(this.begin, this.end);
    }
}
