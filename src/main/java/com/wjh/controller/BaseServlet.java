package com.wjh.controller;

import com.wjh.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseServlet extends HttpServlet {
    public HttpSession session;


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session=req.getSession();

        String uri = req.getRequestURI();
        String s = uri.substring(uri.lastIndexOf("/") + 1);
        Class<? extends BaseServlet> aClass = this.getClass();
        String name = aClass.getName();

        Method method;
        try {
             method = aClass.getDeclaredMethod(s, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(aClass.newInstance(),req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected Map<String,String> getParam(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        HashMap<String, String> returnMap = new HashMap<>();
        for (Map.Entry<String,String[]> entry: entries) {
            String[] values = entry.getValue();
            if (values.length>1){
                String val = Arrays.toString(values);
                returnMap.put(entry.getKey(),val);
            }else {
                returnMap.put(entry.getKey(),values[0]);
            }
        }
        return returnMap;
    }
}
