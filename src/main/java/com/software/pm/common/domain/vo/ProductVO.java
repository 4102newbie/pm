package com.software.pm.common.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ProductVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-27 下午 12:56
 **/
@Data
public class ProductVO {
    // 产品id
    private String id;
    // 产品名称
    private String name;
    // 关联项目id
    private String projectId;
    // 关联项目名称
    private String projectName;
    // 激活任务数
    private Integer taskNum;
    // 未解决Bug数
    private Integer bugNum;
}
