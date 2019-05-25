package com.software.pm.mapper;

import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.*;
import com.software.pm.domain.Task;

import java.util.ArrayList;
import java.util.Date;

public interface TaskMapper {

    Integer addTask(Task task);

    ArrayList<TaskVO> getTaskList(String createdBy);

    Integer deleteProject(String id);

    String getTaskDesc(String id);

    Integer updateTaskDesc(String id, String desc);

    ArrayList<TaskVO> getMyTaskList(String assignedTo);

    Integer finishedTask(String finishedBy, String taskId, Date finishedDate);

    TaskViewVO getTaskInfo(String id);

    ArrayList<TaskVO> getTestTaskList();

    Integer closeTask(SubmitDTO submitDTO);

    RelationVO getRelation(String taskId);

    Integer isExist(String taskId);

    Integer countTaskByProjectId(String projectId);

    Integer countTaskByProductId(String productId);
}
