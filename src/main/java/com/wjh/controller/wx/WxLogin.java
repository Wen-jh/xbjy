package com.wjh.controller.wx;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.HttpKit;
import com.wjh.model.User;
import com.wjh.server.Impl.UserServerImpl;
import com.wjh.server.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/wx_login")
public class WxLogin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String code = req.getParameter("code");
// 加载配置文件
        Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
// https://api.weixin.qq.com/sns/oauth2/access_token?
        //appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
        String appid = prop.getProperty("wx.AppID");
        String AppSecret = prop.getProperty("wx.AppSecret");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid +
                "&secret=" + AppSecret +
                "&code=" + code +
                "&grant_type=authorization_code";
        String jsonString = HttpKit.get(url);

    }
}
