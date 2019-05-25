package com.software.pm.service.impl;

import com.software.pm.common.domain.dto.UserInfoDTO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.mapper.UserMapper;
import com.software.pm.domain.User;
import com.software.pm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-16 下午 05:05
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public Integer updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public Integer updatePassword(UserInfoDTO userInfoDTO) {
        return userMapper.updatePassword(userInfoDTO);
    }

    @Override
    public Integer count() {
        return userMapper.count();
    }

    @Override
    public ArrayList<SelectOptionVO> getSelectOption() {
        return userMapper.getSelectOption();
    }

    @Override
    public ArrayList<String> getAccount() {
        return userMapper.getAccount();
    }
}
