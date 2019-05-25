package com.software.pm.mapper;

import com.software.pm.domain.User;
import java.util.ArrayList;

public interface AdminMapper {

    ArrayList<User> getUserList();

    Integer addUserInfo(User user);

    Integer deleteUser(String id);
}
