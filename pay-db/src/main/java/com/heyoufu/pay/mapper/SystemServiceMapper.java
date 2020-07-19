package com.heyoufu.pay.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.heyoufu.pay.model.SystemService;

public interface SystemServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemService record);

    int insertSelective(SystemService record);

    SystemService selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemService record);

    int updateByPrimaryKey(SystemService record);

    List<SystemService> selectAll();

    SystemService selectByServiceName(@Param("serviceName")String serviceName);

}