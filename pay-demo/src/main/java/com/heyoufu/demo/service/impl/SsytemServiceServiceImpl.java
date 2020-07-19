package com.heyoufu.demo.service.impl;

import com.heyoufu.demo.service.SystemServiceService;
import com.heyoufu.pay.mapper.SystemServiceMapper;
import com.heyoufu.pay.model.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SsytemServiceServiceImpl implements SystemServiceService {

    @Autowired
    private SystemServiceMapper systemServiceMapper;

    @Override
    public List<SystemService> findAll() {
        return systemServiceMapper.selectAll();
    }

}
