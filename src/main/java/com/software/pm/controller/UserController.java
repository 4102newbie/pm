package com.software.pm.controller;

import com.software.pm.common.domain.dto.UserInfoDTO;
import com.software.pm.domain.User;
import com.software.pm.service.UserService;
import com.software.pm.utils.MD5Utils;
import com.software.pm.utils.R;
import com.software.pm.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PmUserController
 * @Description 用户管理
 * @Author liziguang
 * @Date 2019-04-16 下午 05:02
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    R userLogin(String account, String password) {
        Map res = new HashMap();
        User user = userService.getUserByAccount(account);
        if (null == user || !MD5Utils.toEquals(password, user.getPassword())) {
            return R.error("账户或密码错误！");
        } else {
            res.put("user", user);
            return R.ok(res);
        }
    }

    @PostMapping("/updateUserInfo")
    R updateUserInfo(User user) {
        Map res = new HashMap();
        User userInfo = userService.getUserById(user.getId());
        if (null == userInfo || !MD5Utils.toEquals(user.getPassword(), userInfo.getPassword())) {
            return R.error("密码错误！");
        } else {
            user.setPassword(null);
            if (!"".equals(user.getRealname()) || null != user.getRealname()) {
                user.setAvatar(StringUtils.getAvatar(user.getRealname()));
            }
            System.out.println(user);
            Integer count = userService.updateUserInfo(user);
            if (1 == count) {
                res.put("user", userService.getUserById(user.getId()));
                return R.ok(res);
            } else {
                return R.error("更新失败！");
            }
        }
    }

    @PostMapping("/updatePassword")
    R updatePassword(UserInfoDTO userInfoDTO) {
        User userInfo = userService.getUserById(userInfoDTO.getId());
        if (null == userInfo || !MD5Utils.toEquals(userInfoDTO.getOriginalPassword(), userInfo.getPassword())) {
            return R.error("密码错误！");
        } else {
            userInfoDTO.setPassword(MD5Utils.encrypt(userInfoDTO.getNewPassword()));
            Integer count = userService.updatePassword(userInfoDTO);
            if (1 == count) {
                return R.ok();
            }else {
                return R.error("更新失败！");
            }
        }
    }
}
