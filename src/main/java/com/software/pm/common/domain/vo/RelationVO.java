package com.software.pm.common.domain.vo;

import lombok.Data;

/**
 * @ClassName RelationVO
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-25 下午 04:20
 **/
@Data
public class RelationVO {
    // 产品id
    private String productId;
    // 项目id
    private String projectId;
    // 任务id
    private String taskId;
    // 任务名称
    private String taskName;
}
