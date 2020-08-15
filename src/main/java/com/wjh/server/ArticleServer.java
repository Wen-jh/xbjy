package com.wjh.server;

import com.wjh.model.Article;
import com.wjh.model.PageEntity;
import com.wjh.model.User;

import java.util.List;
import java.util.Map;

public interface ArticleServer {
    PageEntity<Map<String, Object>> findArticle(String title,Integer currPage);
    PageEntity<Map<String, Object>> findFavorite(String title,Integer currPage);
    Integer countAll(String title);
    Article findArticleById(Integer id);

    List<Map<String, Object>> findAllFollowById(Integer id);
}
