package com.software.pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.software.pm.common.config.Constants;
import com.software.pm.domain.User;
import com.software.pm.mapper.AdminMapper;
import com.software.pm.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-19 下午 01:00
 **/
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Override
    public Map getUserList(Integer startPage) {
        Map res = new HashMap();
        PageHelper.startPage(startPage, Constants.PAGESIZE);
        ArrayList<User> userList = adminMapper.getUserList();
        for (User user : userList) {
            user.setRole(Constants.Role.valueOf(user.getRole().toUpperCase()).getName());
        }
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        res.put("queryList", userPageInfo);
        return res;
    }

    @Override
    public Integer addUserInfo(User user) {
        return adminMapper.addUserInfo(user);
    }

    @Override
    public Integer deleteUser(String id) {
        return adminMapper.deleteUser(id);
    }
}
