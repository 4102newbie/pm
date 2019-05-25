package com.software.pm.service;


import com.software.pm.common.domain.dto.UserInfoDTO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.User;

import java.util.ArrayList;

public interface UserService {

     User getUserById(String id);

     User getUserByAccount(String account);

     Integer updateUserInfo(User user);

     Integer updatePassword(UserInfoDTO userInfoDTO);

     Integer count();

     ArrayList<SelectOptionVO> getSelectOption();

     ArrayList<String> getAccount();
}
