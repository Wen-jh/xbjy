package com.wjh.controller.dept;

import com.alibaba.fastjson.JSONArray;
import com.wjh.controller.BaseServlet;
import com.wjh.server.Impl.DeptServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/dept/*")
public class DtptServlet extends BaseServlet {

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptServerImpl deptServer = new DeptServerImpl();
        HashMap<String, ArrayList<Map<String, Object>>> all = deptServer.findAll();
        req.setAttribute("allDept",all);
        req.getRequestDispatcher("/html/department.jsp").forward(req,resp);
        //resp.sendRedirect("/html/department.jsp");
    }
}
