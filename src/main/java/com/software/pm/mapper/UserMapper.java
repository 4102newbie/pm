package com.software.pm.mapper;

import com.software.pm.common.domain.dto.UserInfoDTO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.User;

import java.util.ArrayList;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-16 下午 05:03
 **/
public interface UserMapper {

    User getUserById(String id);

    User getUserByAccount(String account);

    Integer updateUserInfo(User user);

    Integer updatePassword(UserInfoDTO userInfoDTO);

    Integer count();

    ArrayList<SelectOptionVO> getSelectOption();

    ArrayList<String> getAccount();
}
