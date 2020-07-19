package com.heyoufu.agent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import  com.heyoufu.agent.service.*;

@Controller
@RequestMapping("/agent")
public class ServiceTestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTestController.class);

    @Autowired
    private   TestService  testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test ( )
    {
        return  testService.test();
    }

}
