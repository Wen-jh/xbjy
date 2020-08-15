package com.wjh.controller.meet;

import com.wjh.controller.BaseServlet;
import com.wjh.server.Impl.MeetingServerImpl;
import com.wjh.server.MeetingServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/meet/*")
public class MeetServlet extends BaseServlet {
        MeetingServer meetingServer=new MeetingServerImpl();
    public void findAllMeet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> param = getParam(req);
        String title = param.get("title");
        Integer status = Integer.valueOf(param.get("status"));
        Integer currPage = Integer.valueOf(param.get("currPage"));
        List<Map<String, Object>> allMeet = meetingServer.findAllMeet(title, status, currPage);
        req.getRequestDispatcher("/html/meet.jsp").forward(req,resp);
    }
}
