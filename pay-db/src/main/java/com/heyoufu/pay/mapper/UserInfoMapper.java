package com.heyoufu.pay.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.heyoufu.pay.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectByUsername(@Param("username")String username);

    UserInfo selectByPhone(@Param("phone")String phone);

	UserInfo selectByMail(@Param("mail")String mail);

}