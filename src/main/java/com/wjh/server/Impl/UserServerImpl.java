package com.wjh.server.Impl;


import com.wjh.dao.UserDao;
import com.wjh.model.PageEntity;
import com.wjh.model.User;
import com.wjh.model.Userfocus;
import com.wjh.server.UserServer;

import java.util.List;
import java.util.Map;

public class UserServerImpl implements UserServer {

    UserDao userDao= new UserDao();

    @Override
    public boolean toRegister(User user) {
        boolean b = userDao.toRegister(user);
        return b;
    }

    @Override
    public PageEntity<User> findUser(Integer currPage, String username) {
        PageEntity<User> entity = new PageEntity<>();
        //页大小
        Integer pageSize = entity.getPageSize();
        //计算起始索引
        Integer startIndex=(currPage-1)*pageSize;
        //当前页数据
        List<User> list = userDao.findUser(startIndex,pageSize,username);
        //总记录数
        Integer totalCount = userDao.findAll();
        //总页数
        Integer totalPage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1;
        entity.setData(list);
        entity.setTotalCount(totalCount);
        entity.setTotalPage(totalPage);
        entity.setCurrPage(currPage);
        return entity;
    }

    @Override
    public boolean toLogin(String username, String password) {
        boolean b = userDao.toLogin(username, password);
        return b;
    }

    @Override
    public User findById(Integer id) {
        User user = userDao.findById(id);
        return user;
    }

    @Override
    public Integer countFollowByUid(Integer uId) {
        Integer integer = userDao.countFollowByUid(uId);
        return integer;
    }

    @Override
    public void updateUrl(int id, String picUrl) {
        User user = new User();
        user.setId(id);
        user.setPic(picUrl);
        userDao.update(user);
    }

    @Override
    public Integer countAll(Integer id) {
        return userDao.countAll(id);
    }

    @Override
    public  PageEntity<Map<String, Object>> findMyUserByUid(Integer id, Integer currPage) {
        PageEntity<Map<String, Object>> pageModel = new PageEntity<>();
        Integer pageSize = pageModel.getPageSize();
        Integer startIndex = (currPage - 1) * pageSize;
        List<Map<String, Object>> data = userDao.findMyUserByUid(id, startIndex, pageSize);
        Integer totalCount = userDao.countAll(id);
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pageModel.setData(data);
        pageModel.setTotalCount(totalCount);
        pageModel.setTotalPage(totalPage);
        pageModel.setCurrPage(currPage);
        return pageModel;
    }

    @Override
    public boolean updateUser(User user) {
        boolean b = userDao.update(user);
        return b;
    }

    @Override
    public void updateLoginTimeByUsername(String username) {
        userDao.updateLoginTimeByUsername(username);
    }

    @Override
    public User findUserByUsername(String username) {
        User user = userDao.findUserByUsername(username);
        return user;
    }
}
