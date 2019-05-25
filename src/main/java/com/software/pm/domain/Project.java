package com.software.pm.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.software.pm.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Project
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-22 下午 06:11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    //项目ID
    private String id;
    //关联产品
    private String productId;
    //项目名称
    private String name;
    //项目代号
    private String code;
    //开始日期
    @JSONField(format = "yyyy-MM-dd")
    private Date begin;
    //截止日期
    @JSONField(format = "yyyy-MM-dd")
    private Date end;
    //可用工时
    private Integer days;
    //项目描述
    private String description;
    //由谁创建
    private String createdBy;
    //创建日期
    @JSONField(format="yyyy-MM-dd")
    private Date createdDate;
    //是否删除
    @JSONField(serialize = false)
    private String deleted;

    public void setBegin(String begin) {
        this.begin = DateUtils.toDate(begin);
    }

    public void setEnd(String end) {
        this.end = DateUtils.toDate(end);
    }
}
