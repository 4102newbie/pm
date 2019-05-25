package com.software.pm.common.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ProjectVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-27 下午 02:23
 **/
@Data
public class ProjectVO {
    //项目ID
    private String id;
    //项目名称
    private String name;
    // 项目代号
    private String code;
    //开始日期
    @JSONField(format = "yyyy-MM-dd")
    private Date begin;
    //截止日期
    @JSONField(format = "yyyy-MM-dd")
    private Date end;
    // 关联任务
    private Boolean haveTask;

    public void setHaveTask(String haveTask) {
        if ("TRUE".equals(haveTask)) {
            this.haveTask = true;
        } else {
            this.haveTask = false;
        }
    }
}
