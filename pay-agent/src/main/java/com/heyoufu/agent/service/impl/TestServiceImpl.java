package com.heyoufu.agent.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import  com.heyoufu.agent.service.*;

/***
 Create  by lgl  on  2020-05-08.

 ***/
@Service
public class TestServiceImpl implements  TestService {


    @Value("${server.port}")
    String port;

    public  String  test()
    {
        return  "agent service   test,  from port "+ port;

    }
}
