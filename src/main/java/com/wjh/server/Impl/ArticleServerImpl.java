package com.wjh.server.Impl;

import com.wjh.dao.ArticleDao;
import com.wjh.model.Article;
import com.wjh.model.PageEntity;
import com.wjh.model.User;
import com.wjh.server.ArticleServer;

import java.util.List;
import java.util.Map;

public class ArticleServerImpl implements ArticleServer {
    @Override
    public PageEntity<Map<String, Object>> findArticle(String title,Integer currPage) {
        PageEntity<Map<String, Object>> pageModel = new PageEntity<>();
        Integer pageSize = pageModel.getPageSize();
        Integer startIndex = (currPage - 1) * pageSize;
        List<Map<String, Object>>  data = new ArticleDao().findAll(title, startIndex, pageSize);
        Integer totalCount = new ArticleDao().countAll(title);
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pageModel.setData(data);
        pageModel.setTotalCount(totalCount);
        pageModel.setTotalPage(totalPage);
        pageModel.setCurrPage(currPage);
        return pageModel;
    }

    @Override
    public List<Map<String, Object>> findAllFollowById(Integer id) {
        List<Map<String, Object>> user = new ArticleDao().findAllFollowById(id);
        return user;
    }

    @Override
    public Article findArticleById(Integer id) {
        Article article = (Article) new ArticleDao().findById(id);
        return article;
    }

    @Override
    public PageEntity<Map<String, Object>> findFavorite(String title, Integer currPage) {
        PageEntity<Map<String, Object>> pageModel = new PageEntity<>();
        Integer pageSize = pageModel.getPageSize();
        Integer startIndex = (currPage - 1) * pageSize;
        List<Map<String, Object>>  data = new ArticleDao().findFavorite(title, startIndex, pageSize);
        Integer totalCount = new ArticleDao().countAllFavorite(title);
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pageModel.setData(data);
        pageModel.setTotalCount(totalCount);
        pageModel.setTotalPage(totalPage);
        pageModel.setCurrPage(currPage);
        return pageModel;
    }

    @Override
    public Integer countAll(String title) {
        return new ArticleDao().countAll(title);
    }
}
