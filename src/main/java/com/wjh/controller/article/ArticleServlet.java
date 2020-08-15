package com.wjh.controller.article;

import com.wjh.controller.BaseServlet;
import com.wjh.model.Article;
import com.wjh.model.PageEntity;
import com.wjh.model.User;
import com.wjh.server.Impl.ArticleServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/article/*")
public class ArticleServlet extends BaseServlet {
    ArticleServerImpl articleServer = new ArticleServerImpl();

    public void findArticle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Map<String, String> param = getParam(req);
        String title = param.get("title");
        // 当前页
        Integer currPage;
        if (param.get("currPage") == null) {
            currPage = 1;
        } else {
            currPage = Integer.parseInt(param.get("currPage"));
        }
        PageEntity<Map<String, Object>> article = articleServer.findArticle(title, currPage);
        req.setAttribute("allArticle",article);
        req.getRequestDispatcher("/html/article.jsp").forward(req,resp);
    }
    public void articleCollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> param = getParam(req);
        String title = param.get("title");
// 当前页
        Integer currPage;
        if (param.get("currPage") == null) {
            currPage = 1;
        } else {
            currPage = Integer.parseInt(param.get("currPage"));
        }
        PageEntity<Map<String, Object>> article = articleServer.findFavorite(title, currPage);
        req.setAttribute("allFavorite",article);
        req.getRequestDispatcher("/html/article_collect.jsp").forward(req,resp);
    }
    public void articleDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> param = getParam(req);
        Integer id = Integer.valueOf(param.get("aId"));
        Article article = articleServer.findArticleById(id);
        List<Map<String, Object>> allFollowById = articleServer.findAllFollowById(id);
        req.setAttribute("allFollowById",allFollowById);
        req.setAttribute("Farticle",article);
        req.getRequestDispatcher("/html/article_detail.jsp").forward(req,resp);
    }
}
