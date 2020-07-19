package com.heyoufu.pay.common.util;

import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {

    public static void write(HttpServletResponse response, Object data) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSONUtil.toJsonStr(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
