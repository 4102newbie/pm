package com.software.pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.software.pm.common.config.Constants;
import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.*;
import com.software.pm.domain.Task;
import com.software.pm.mapper.BugMapper;
import com.software.pm.mapper.TaskMapper;
import com.software.pm.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TaskServiceImpl
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-23 下午 07:40
 **/
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Resource
    TaskMapper taskMapper;
    @Resource
    BugMapper bugMapper;

    @Override
    public Integer addTask(Task task) {
        return taskMapper.addTask(task);
    }

    @Override
    public Map getTaskList(PageDTO pageDTO) {
        Map res = new HashMap();
        PageHelper.startPage(pageDTO.getStartPage(), Constants.PAGESIZE);
        ArrayList<TaskVO> taskList = taskMapper.getTaskList(pageDTO.getCreatedBy());
        PageInfo<TaskVO> taskPageInfo = new PageInfo<>(taskList);
        res.put("queryList",taskPageInfo);
        return res;
    }

    @Override
    public Integer deleteProject(String deleteId) {
        return taskMapper.deleteProject(deleteId);
    }

    @Override
    public String getTaskDesc(String id) {
        return taskMapper.getTaskDesc(id);
    }

    @Override
    public Integer updateTaskDesc(String id, String desc) {
        return taskMapper.updateTaskDesc(id, desc);
    }

    @Override
    public Map getMyTaskList(PageDTO pageDTO) {
        Map res = new HashMap();
        PageHelper.startPage(pageDTO.getStartPage(), Constants.PAGESIZE);
        ArrayList<TaskVO> taskList = taskMapper.getMyTaskList(pageDTO.getAssignedTo());
        PageInfo<TaskVO> taskPageInfo = new PageInfo<>(taskList);
        res.put("queryList",taskPageInfo);
        return res;
    }

    @Override
    public Integer finishedTask(String userId,String taskId) {
        return taskMapper.finishedTask(userId, taskId, new Date());
    }

    @Override
    public TaskViewVO getTaskInfo(String id) {
        return taskMapper.getTaskInfo(id);
    }

    @Override
    public Map getTestTaskList(Integer startPage) {
        Map res = new HashMap();
        PageHelper.startPage(startPage, Constants.PAGESIZE);
        ArrayList<TaskVO> taskList = taskMapper.getTestTaskList();
        PageInfo<TaskVO> taskPageInfo = new PageInfo<>(taskList);
        res.put("queryList",taskPageInfo);
        return res;
    }

    @Override
    public Integer closeTask(SubmitDTO submitDTO) {
        return taskMapper.closeTask(submitDTO);
    }

    @Override
    public RelationVO getRelation(String taskId) {
        return taskMapper.getRelation(taskId);
    }

    @Override
    public Map getDevBugList(PageDTO pageDTO) {
        Map res = new HashMap();
        PageHelper.startPage(pageDTO.getStartPage(), Constants.PAGESIZE);
        ArrayList<BugVO> bugList = bugMapper.getDevBugList(pageDTO.getAssignedTo());
        PageInfo<BugVO> bugVOPageInfo = new PageInfo<>(bugList);
        res.put("queryList",bugVOPageInfo);
        return res;
    }

}
