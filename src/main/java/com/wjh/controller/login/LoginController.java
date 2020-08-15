package com.wjh.controller.login;

import com.wjh.controller.BaseServlet;
import com.wjh.model.User;
import com.wjh.server.Impl.UserServerImpl;
import com.wjh.server.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/login/*")
public class LoginController extends BaseServlet {

    private UserServer userServer= new UserServerImpl();
    public void  tologin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> param = getParam(req);
        String username = param.get("form-username");
        String password = param.get("form-password");
        boolean b = userServer.toLogin(username, password);
        userServer.updateLoginTimeByUsername(username);
        if (b){
            User user = userServer.findUserByUsername(username);
            req.getSession().setAttribute("username",username);
            req.getSession().setAttribute("loginUser",user);
            String realName = user.getRealName();
            String deptName = user.getDeptName();
            int id = user.getId();
            if (realName!=null){
                req.getSession().setAttribute("name",realName);
            }else {
                req.getSession().setAttribute("name",username);
            }
            req.getSession().setAttribute("uId",id);
            req.getSession().setAttribute("deptName",deptName);
            resp.sendRedirect("/html/home.jsp");
        }else {
            System.out.println("错误");
        }

    }
    public void toRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> param = getParam(req);
        String username = param.get("form-username");
        String password = param.get("form-password");
        String email = param.get("form-email");
        String p2 = param.get("form-password2");
        if (password.equals(p2)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            boolean b = userServer.toRegister(user);
            if (b){
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.print("<html><head><meta charset='UTF-8'></head>");
                out.println("<script>");
                out.println("alert('注册成功！');");
                out.println("window.location='/'");
                out.println("</script>");
            }else {
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.print("<html><head><meta charset='UTF-8'></head>");
                out.println("<script>");
                out.println("alert('注册失败！');");
                out.println("window.location='/register.html'");
                out.println("</script>");
            }
        }else {
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.print("<html><head><meta charset='UTF-8'></head>");
            out.println("<script>");
            out.println("alert('密码不一致！');");
            out.println("window.location='/register.html'");
            out.println("</script>");
        }

    }
}
