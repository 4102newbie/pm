package com.software.pm.controller;

import com.software.pm.common.config.Constants;
import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.BugViewVO;
import com.software.pm.common.domain.vo.RelationVO;
import com.software.pm.common.domain.vo.TaskViewVO;
import com.software.pm.domain.Bug;
import com.software.pm.domain.User;
import com.software.pm.service.BugService;
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
 * @ClassName BugController
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-25 下午 04:12
 **/
@Slf4j
@RestController
@RequestMapping("/bug")
public class BugController {
    @Autowired
    BugService bugService;
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @PostMapping("/addBug")
    R addBug(Bug bug){
        // 构建Bug对象
        bug.setId(UUIDUtils.generateShortUUID());
        bug.setVerification(Constants.Verification.NOTFIN.getValue());
        bug.setCreatedDate(new Date());
//        System.out.println(bug.toString());
        Integer count = bugService.addBug(bug);
        if (1 == count) {
            return R.ok();
        } else {
            return R.error("添加失败！");
        }
    }

    @GetMapping("/getRelation")
    R getRelation(String taskId){
        Map res = new HashMap();
        RelationVO relationVO = taskService.getRelation(taskId);
        res.put("relation", relationVO);
        return R.ok(res);
    }

    @PostMapping("/getBugList")
    R getBugList(PageDTO pageDTO){
        Map map = bugService.getBugList(pageDTO);
        return R.ok(map);
    }

    @GetMapping("/getBugInfo")
    R getBugInfo(String id){
        Map res = new HashMap();
        BugViewVO bugViewVO = bugService.getBugInfo(id);
        res.put("bugInfo", bugViewVO);
        return R.ok(res);
    }

    @PostMapping("/resolvedBug")
    R resolvedBug(SubmitDTO submitDTO){
        User user = userService.getUserById(submitDTO.getUserId());
        if (null == user || !MD5Utils.toEquals(submitDTO.getPassword(), user.getPassword())) {
            return R.error("密码错误！");
        }else {
            Integer count = bugService.resolvedBug(submitDTO);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("操作失败！");
            }
        }
    }

    @GetMapping("/verifyBugFall")
    R verifyBugFall(String id){
        Integer count = bugService.verifyBugFall(id);
        if (1 == count) {
            return R.ok();
        } else {
            return R.error("操作失败！");
        }
    }

    @PostMapping("/verifyBugPass")
    R verifyBugPass(SubmitDTO submitDTO){
        User user = userService.getUserById(submitDTO.getUserId());
        if (null == user || !MD5Utils.toEquals(submitDTO.getPassword(), user.getPassword())) {
            return R.error("密码错误！");
        }else {
            Integer count = bugService.verifyBugPass(submitDTO);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("操作失败！");
            }
        }
    }
}
