package com.software.pm.common.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName PageDTO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-19 下午 01:20
 **/
@Data
public class PageDTO {
    // 起始页
    private Integer startPage;
    // 由谁创建
    private String createdBy;
    // 指派给
    private String assignedTo;
}
