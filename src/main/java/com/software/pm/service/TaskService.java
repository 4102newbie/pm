package com.software.pm.service;

import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.RelationVO;
import com.software.pm.common.domain.vo.TaskViewVO;
import com.software.pm.domain.Task;

import java.util.Map;

public interface TaskService {
    Integer addTask(Task task);

    Map getTaskList(PageDTO pageDTO);

    Integer deleteProject(String deleteId);

    String getTaskDesc(String id);

    Integer updateTaskDesc(String id, String desc);

    Map getMyTaskList(PageDTO pageDTO);

    Integer finishedTask(String userId,String taskId);

    TaskViewVO getTaskInfo(String id);

    Map getTestTaskList(Integer startPage);

    Integer closeTask(SubmitDTO submitDTO);

    RelationVO getRelation(String taskId);

    Map getDevBugList(PageDTO pageDTO);
}
