package com.heyoufu.agent.config.oath2;

import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.common.util.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 身份验证入口
 * xzm 2020-5-18
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        CommonResult<Object> failed = CommonResult.failed(authException.getMessage());
        ResponseUtil.write(response, failed);
    }
}
