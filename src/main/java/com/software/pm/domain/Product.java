package com.software.pm.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Product
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-21 下午 04:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    //产品ID
    private String id;
    //产品名称
    private String name;
    //产品代号
    private String code;
    //产品描述
    private String description;
    //由谁创建
    private String createdBy;
    //创建日期
    @JSONField(format = "yyyy-MM-dd")
    private Date createdDate;
    //是否删除
    @JSONField(serialize = false)
    private String deleted;

}
