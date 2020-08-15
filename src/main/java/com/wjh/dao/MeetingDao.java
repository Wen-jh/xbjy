package com.wjh.dao;

import com.wjh.dao.base.BaseDao;
import com.wjh.model.Meeting;
import com.wjh.utils.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class MeetingDao extends BaseDao {
    public MeetingDao( ) {
        super(Meeting.class);
    }
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    public void findAllMeet(String title, Integer status, Integer startIndex,Integer endIndex) {
        StringBuilder sql = new StringBuilder();
        List<Map<String, Object>> list;
        sql.append("SELECT * FROM meeting WHERE LENGTH(id>0) ");
        if (title!=null){
            sql.append("AND title LIKE '?' ");
        }
        if (status!=null){
            sql.append("AND `status`=?");
        }
        sql.append(" limit ?,?");

        if (title!=null&&status==null){
            List<Map<String, Object>> maps = jdbcTemplate.queryForList(String.valueOf(sql),"%"+title+"%",startIndex,endIndex);
        }
        if (title!=null&&status!=null){
            List<Map<String, Object>> maps = jdbcTemplate.queryForList(String.valueOf(sql),status,startIndex,endIndex);
        }
        if (title!=null&&status!=null){
            List<Map<String, Object>> maps = jdbcTemplate.queryForList(String.valueOf(sql),"%"+title+"%",startIndex,endIndex);
        }
        return;
    }

    public Integer CountAll(String title, Integer status) {
    return 1;
    }
}
