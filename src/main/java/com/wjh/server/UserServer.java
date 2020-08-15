package com.wjh.server;

import com.wjh.model.PageEntity;
import com.wjh.model.User;

import java.util.Map;


public interface UserServer {
    User findById(Integer id);
    boolean toLogin(String username, String password);

    boolean toRegister(User user);

    PageEntity<User> findUser(Integer currPage, String username);
    User findUserByUsername(String username);

    Integer countFollowByUid(Integer Uid);

    void updateLoginTimeByUsername(String username);

    boolean updateUser(User user);

    PageEntity<Map<String, Object>> findMyUserByUid(Integer id, Integer currPage);

    void updateUrl(int id, String picUrl);
    Integer countAll(Integer id);
}
