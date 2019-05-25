package com.software.pm.controller;

import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.vo.ProjectViewVO;
import com.software.pm.domain.Project;
import com.software.pm.domain.User;
import com.software.pm.service.ProjectService;
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
 * @ClassName ProjectController
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-22 下午 07:43
 **/
@Slf4j
@RestController
@RequestMapping("/pm")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @PostMapping("/addProject")
    R addProject(Project project) {
        // 构建Project对象
        project.setId(UUIDUtils.generateShortUUID());
//        project.setDays(DateUtils.subtractDays(project.getBegin(),project.getEnd()));
        project.setCreatedDate(new Date());
        Integer count = projectService.addProject(project);
        if (1 == count) {
            return R.ok();
        } else {
            return R.error("添加失败！");
        }
    }

    @PostMapping("/projectList")
    R getProjectList(PageDTO pageDTO) {
        Map map = projectService.getProjectList(pageDTO);
        return R.ok(map);
    }

    @GetMapping("/getProjectDesc")
    R getProjectDesc(String id) {
        Map res = new HashMap();
        String projectDesc = projectService.getProjectDesc(id);
        res.put("desc", projectDesc);
        return R.ok(res);
    }

    @PostMapping("/updateProjectDesc")
    R updateProjectDesc(String id, String desc) {
        Integer count = projectService.updateProjectDesc(id, desc);
        if (1 == count) {
            return R.ok();
        } else {
            return R.error("更新失败！");
        }
    }

    @PostMapping("/deleteProject")
    R deleteProject(String password, String userId, String deleteId) {
        User user = userService.getUserById(userId);
        if (null == user || !MD5Utils.toEquals(password, user.getPassword())) {
            return R.error("密码错误！");
        } else {
            Integer count = projectService.deleteProject(deleteId);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("删除失败！");
            }
        }
    }

    @GetMapping("/projectInfo")
    R getProjectInfo(String id){
        Map res = new HashMap();
        ProjectViewVO projectViewVO = projectService.getProjectInfo(id);
        res.put("projectInfo", projectViewVO);
        return R.ok(res);
    }

}
