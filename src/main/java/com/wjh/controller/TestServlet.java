package com.wjh.controller;

import com.wjh.model.PageEntity;
import com.wjh.model.User;
import com.wjh.server.Impl.UserServerImpl;
import com.wjh.server.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends BaseServlet{
    public void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServerImpl userServer = new UserServerImpl();
        User user = userServer.findUserByUsername("admin");
        System.out.println(user);
    }
}
