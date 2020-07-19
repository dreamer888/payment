package com.heyoufu.pay.mapper;
import java.util.List;

import com.heyoufu.pay.model.RoleInfo;import org.apache.ibatis.annotations.Param;

public interface RoleInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    RoleInfo selectByName(@Param("name") String name);

    RoleInfo selectByTag(@Param("tag") String tag);

    List<RoleInfo> selectAll();


}