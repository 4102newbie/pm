package com.software.pm.controller;

import com.software.pm.common.domain.dto.AddUserDTO;
import com.software.pm.common.domain.dto.UserInfoDTO;
import com.software.pm.domain.User;
import com.software.pm.service.AdminService;
import com.software.pm.service.UserService;
import com.software.pm.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AdminController
 * @Description 管理员
 * @Author liziguang
 * @Date 2019-04-19 下午 12:28
 **/
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;

    @GetMapping("/userList")
    R getUserList(Integer startPage) {
        Map map = adminService.getUserList(startPage);
        return R.ok(map);
    }

    @PostMapping("/addUserInfo")
    R addUserInfo(AddUserDTO addUserDTO) {
        User userInfo = userService.getUserById(addUserDTO.getId());
        if (null == userInfo || !MD5Utils.toEquals(addUserDTO.getVerifyPassword(), userInfo.getPassword())) {
            return R.error("密码错误！");
        } else if (userService.getAccount().contains(addUserDTO.getAccount())) {
            // 判断账号是否已经存在
            return R.error("账号已存在！");
        } else {
            // 构建 user 对象
            String avatar = StringUtils.getAvatar(addUserDTO.getRealname().isEmpty() ? addUserDTO.getAccount() : addUserDTO.getRealname());
            String realname = addUserDTO.getRealname().isEmpty() ? addUserDTO.getAccount() : addUserDTO.getRealname();
            Integer sort = userService.count() + 1;
            User user = new User(UUIDUtils.generateShortUUID(), addUserDTO.getAccount(), MD5Utils.encrypt(addUserDTO.getPassword1()),
                    addUserDTO.getRole(), realname, avatar, addUserDTO.getGender(), null, null, null,
                    DateUtils.toDate(addUserDTO.getJoin()), "0", sort);
            Integer count = adminService.addUserInfo(user);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("添加失败！");
            }
        }
    }

    @GetMapping("/getUserInfo")
    R getUserInfo(String id) {
        Map res = new HashMap();
        User user = userService.getUserById(id);
        if (null == user) {
            return R.error("非法查询！");
        } else {
            res.put("userInfo", user);
            return R.ok(res);
        }
    }

    @PostMapping("/editUserInfo")
    R editUserInfo(UserInfoDTO userInfoDTO) {
        User userInfo = userService.getUserById(userInfoDTO.getId());
        if (null == userInfo || !MD5Utils.toEquals(userInfoDTO.getOriginalPassword(), userInfo.getPassword())) {
            return R.error("密码错误！");
        } else {
            String avatar = StringUtils.getAvatar(userInfoDTO.getRealname().isEmpty() ? userInfoDTO.getAccount() : userInfoDTO.getRealname());
            String realname = userInfoDTO.getRealname().isEmpty() ? userInfoDTO.getAccount() : userInfoDTO.getRealname();
            User user = new User(userInfoDTO.getId(), userInfoDTO.getAccount(), MD5Utils.encrypt(userInfoDTO.getNewPassword()),
                    userInfoDTO.getRole(), realname, avatar, userInfoDTO.getGender(), null, null, null,
                    DateUtils.toDate(userInfoDTO.getJoin()), "0", 0);
//            System.out.println(user);
            Integer count = userService.updateUserInfo(user);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("更新失败！");
            }
        }
    }

    @PostMapping("/deleteUser")
    R deleteUser(String password, String userId, String deleteId) {
        User user = userService.getUserById(userId);
        if (null == user || !MD5Utils.toEquals(password, user.getPassword())) {
            return R.error("密码错误！");
        } else {
            Integer count = adminService.deleteUser(deleteId);
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("删除失败！");
            }
        }
    }
}
