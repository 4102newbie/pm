package com.software.pm.common.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ProductViewVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-26 下午 06:46
 **/
@Data
public class ProductViewVO {
    // 产品名称
    private String name;
    // 产品代码
    private String code;
    // 产品描述
    private String description;
    // 由谁创建
    private String createdBy;
    // 创建日期
    @JSONField(format = "yyyy-MM-dd")
    private Date createdDate;
    // 激活任务数
    private Integer taskNum;
    // 未解决Bug数
    private Integer bugNum;
    // 能否进行关闭操作
    private boolean close;

    public void setIsClose(String isClose) {
        if ("TRUE".equals(isClose)) {
            this.close = true;
        } else {
            this.close = false;
        }
    }
}
