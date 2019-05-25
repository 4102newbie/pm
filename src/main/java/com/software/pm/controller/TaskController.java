package com.software.pm.controller;

import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.TaskViewVO;
import com.software.pm.domain.Task;
import com.software.pm.domain.User;
import com.software.pm.service.TaskService;
import com.software.pm.service.UserService;
import com.software.pm.utils.MD5Utils;
import com.software.pm.utils.R;
import com.software.pm.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName TaskController
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-23 下午 07:39
 **/
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @PostMapping("/addTask")
    R addTask(Task task){
        // 构建 task 对象
        task.setId(UUIDUtils.generateShortUUID());
        task.setCreatedDate(new Date());
        task.setAssignedDate(new Date());
//        System.out.println(task);
        Integer count = taskService.addTask(task);
        if (1 == count) {
            return R.ok();
        } else {
            return R.error("添加失败！");
        }
    }

    @PostMapping("/taskList")
    R getTaskList(PageDTO pageDTO){
        Map map = taskService.getTaskList(pageDTO);
        return R.ok(map);
    }

    @PostMapping("/deleteTask")
    R deleteTask(String password, String userId, String deleteId){
        User user = userService.getUserById(userId);
        if (null == user || !MD5Utils.toEquals(password, user.getPassword())) {
            return R.error("密码错误！");
        }else {
            Integer count = taskService.deleteProject(deleteId);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("删除失败！");
            }
        }
    }

    @GetMapping("/getTaskDesc")
    R getTaskDesc(String id){
        Map res = new HashMap();
        String projectDesc = taskService.getTaskDesc(id);
        res.put("desc", projectDesc);
        return R.ok(res);
    }

    @PostMapping("/updateTaskDesc")
    R updateTaskDesc(String id, String desc){
        Integer count = taskService.updateTaskDesc(id, desc);
        if (1 == count) {
            return R.ok();
        } else {
            return R.error("更新失败！");
        }
    }

    @PostMapping("/myTaskList")
    R getMyTaskList(PageDTO pageDTO){
        Map map = taskService.getMyTaskList(pageDTO);
        return R.ok(map);
    }

    @PostMapping("/finTask")
    R finishedTask(String password, String userId, String taskId){
        User user = userService.getUserById(userId);
        if (null == user || !MD5Utils.toEquals(password, user.getPassword())) {
            return R.error("密码错误！");
        }else {
            Integer count = taskService.finishedTask(userId, taskId);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("操作失败！");
            }
        }
    }

    @GetMapping("/getTaskInfo")
    R getTaskInfo(String id){
        Map res = new HashMap();
        TaskViewVO taskInfo = taskService.getTaskInfo(id);
        res.put("taskInfo", taskInfo);
        return R.ok(res);
    }

    @GetMapping("/testTaskList")
    R getTestTaskList(Integer startPage){
        Map map = taskService.getTestTaskList(startPage);
        return R.ok(map);
    }

    @PostMapping("/closeTask")
    R closeTask(SubmitDTO submitDTO){
        User user = userService.getUserById(submitDTO.getUserId());
        if (null == user || !MD5Utils.toEquals(submitDTO.getPassword(), user.getPassword())) {
            return R.error("密码错误！");
        }else {
            Integer count = taskService.closeTask(submitDTO);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("操作失败！");
            }
        }
    }

    @PostMapping("/devBugList")
    R getDevBugList(PageDTO pageDTO){
        Map map = taskService.getDevBugList(pageDTO);
        return R.ok(map);
    }
}
