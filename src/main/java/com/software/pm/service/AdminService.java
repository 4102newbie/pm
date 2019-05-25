package com.software.pm.service;

import com.software.pm.domain.User;

import java.util.Map;

public interface AdminService {

    Map getUserList(Integer startPage);

    Integer addUserInfo(User user);

    Integer deleteUser(String id);
}
