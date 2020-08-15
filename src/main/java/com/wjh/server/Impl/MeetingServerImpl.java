package com.wjh.server.Impl;

import com.wjh.dao.ArticleDao;
import com.wjh.dao.MeetingDao;
import com.wjh.model.PageEntity;
import com.wjh.server.MeetingServer;

import java.util.List;
import java.util.Map;

public class MeetingServerImpl implements MeetingServer {
    @Override
    public List<Map<String, Object>> findAllMeet(String title, Integer status, Integer currPage) {
        PageEntity<Map<String, Object>> pageModel = new PageEntity<>();
        Integer pageSize = pageModel.getPageSize();
        Integer startIndex = (currPage - 1) * pageSize;
        new MeetingDao().findAllMeet(title,status,startIndex,pageSize);
        Integer totalCount= new MeetingDao().CountAll(title,status);
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        return null;
    }
}
