package com.wjh.controller.user;

import com.wjh.controller.BaseServlet;
import com.wjh.model.PageEntity;
import com.wjh.model.User;
import com.wjh.server.Impl.UserServerImpl;
import com.wjh.server.UserServer;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@WebServlet("/user/*")
public class UserController extends BaseServlet {
    UserServer userServer = new UserServerImpl();
    public void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = null;
        Integer currPage=1;
        if (req.getParameter("currPage")!=null){
            currPage = Integer.valueOf(req.getParameter("currPage"));
        }
        if (req.getParameter("findUsername") != null) {
            username = req.getParameter("findUsername");
        }

        PageEntity<User> pageEntity;
        pageEntity = userServer.findUser(currPage,username);
        req.setAttribute("pageEntity",pageEntity);
        req.getRequestDispatcher("/html/user.jsp").forward(req, resp);
    }
    public void userLook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("targetName");
        User user = userServer.findUserByUsername(name);
        Integer follow = userServer.countFollowByUid(user.getId());
        req.setAttribute("targetUser",user);
        req.setAttribute("follow",follow);
        req.getRequestDispatcher("/html/user_look.jsp").forward(req,resp);
    }
    public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> param = getParam(req);
        Integer upId = Integer.valueOf(param.get("upId"));
        System.out.println(upId);
        String upIsSecret = param.get("upIsSecret");
        String upGender = param.get("upGender");
        String upPhone = param.get("upPhone");
        String upRealName = param.get("upRealName");
        User user = new User();
        user.setId(upId);
        user.setRealName(upRealName);
        user.setPhone(upPhone);
        user.setGender(upGender);
        if (upIsSecret!=null){
            user.setIsSecret("0");
        }else {
            user.setIsSecret("1");
        }
        boolean b = userServer.updateUser(user);
        if (b){
            Object name = req.getSession().getAttribute("username");
            resp.sendRedirect("/user/userLook?targetName="+name);
        }else {
            Object name = req.getSession().getAttribute("username");
            resp.sendRedirect("/user/userLook?targetName="+name);
        }
    }
    public void myUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer uId = (Integer) req.getSession().getAttribute("uId");
        Map<String, String> param = getParam(req);
        // 当前页
        Integer currPage;
        if (param.get("currPage") == null) {
            currPage = 1;
        } else {
            currPage = Integer.parseInt(param.get("currPage"));
        }
        User user = (User) req.getSession().getAttribute("loginUser");
        // 查询分页信息
        PageEntity<Map<String, Object>> pageData=userServer.findMyUserByUid(uId,currPage);
        req.setAttribute("pageData", pageData);
        req.getRequestDispatcher("/html/my_user.jsp").forward(req, resp);
    }
    public void userDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public void updatePic(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setFileSizeMax(1024*400*1024);
        try {
            List<FileItem> items = sfu.parseRequest(req);
            String fileName = "";
            for (int i = 0; i < items.size(); i++) {
                FileItem item = items.get(i);
                if (!item.isFormField()) {
                    String name = item.getName();
                    String suffix = name.substring(name.lastIndexOf("."));
                    fileName = UUID.randomUUID().toString() + suffix;
                    File file = new File(  "D:\\work\\img\\" + fileName);
                    if (!file.exists()) {
                        item.write(file);
                    }
                }
            }
            String picUrl = "/img/" + fileName;
            Object loginUser = req.getSession().getAttribute("loginUser");
            User  user = (User) loginUser;
            user.setPic(picUrl);
            userServer.updateUrl(user.getId(), picUrl);
            resp.getWriter().write(picUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void wx_login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            // 加载配置文件
            Properties prop=new Properties();
            prop.load(this.getClass().getClassLoader().getResourceAsStream("wx.properties"));
            String appid = prop.getProperty("wx.AppID");
//微信授权成功后的回调地址
            String redirect_uri = prop.getProperty("wx.redirect_uri");
//Step1：获取Authorization Code
            String url = "https://open.weixin.qq.com/connect/qrconnect?response_type=code"+
                    "&appid=" + appid +
                    "&redirect_uri=" + URLEncoder.encode(redirect_uri) +
                    "&scope=snsapi_login";
// 重定向到微信登录指定的地址进行微信登录授权,授权成功后返回code
            response.sendRedirect(url);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
