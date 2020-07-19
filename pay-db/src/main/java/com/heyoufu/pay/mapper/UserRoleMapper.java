package com.heyoufu.pay.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.heyoufu.pay.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByUserId(@Param("userId")Long userId);


}