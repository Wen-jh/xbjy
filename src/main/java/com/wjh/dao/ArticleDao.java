package com.wjh.dao;

import com.wjh.dao.base.BaseDao;
import com.wjh.model.Article;
import com.wjh.model.User;
import com.wjh.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ArticleDao extends BaseDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    public ArticleDao( ) {
        super(Article.class);
    }
    public  List<Map<String, Object>>  findAll(String title, Integer startIndex, Integer pageSize) {
        List<Map<String, Object>>  list=null;
        if (title!=null){
            list = jdbcTemplate.queryForList("select title,content,publish_real_name,publish_date from article where title like ? limit ?,?", "%"+title+"%",startIndex,pageSize);
        }else {
             list = jdbcTemplate.queryForList("select title,content,publish_real_name,publish_date from article where length(id>0)limit ?,?",startIndex,pageSize);
        }
        return list;
    }
    public  List<Map<String, Object>>  findFavorite(String title, Integer startIndex, Integer pageSize) {
        List<Map<String, Object>>  list=null;
        if (title!=null){
            list = jdbcTemplate.queryForList("SELECT a.id,a.title,a.content,a.publish_real_name,a.publish_date,a.browse_count FROM article a WHERE  EXISTS(  SELECT a_id FROM `favorite` f WHERE f.u_id=1 AND a.user_id=f.`a_id`) AND  title LIKE ? LIMIT ?,?", "%"+title+"%",startIndex,pageSize);
        }else {
            list = jdbcTemplate.queryForList("SELECT a.id,a.title,a.content,a.publish_real_name,a.publish_date,a.browse_count FROM article a WHERE  EXISTS(  SELECT a_id FROM `favorite` f WHERE f.u_id=1 AND a.user_id=f.`a_id`) LIMIT ?,?",startIndex,pageSize);
        }
        return list;
    }
    public Integer countAll(String title) {
        Integer count=0;
        if (title!=null){
            count = jdbcTemplate.queryForObject("select count(*) from article where title like ? ", Integer.class, "%" + title + "%");
        }else {
            count = jdbcTemplate.queryForObject("select count(*) from article  ", Integer.class);
        }
        return count;
    }
    public Integer countAllFavorite(String title) {
        Integer count=0;
        if (title!=null){
            count = jdbcTemplate.queryForObject("select count(*) from  article a WHERE  EXISTS(  SELECT a_id FROM `favorite` f WHERE f.u_id=1 AND a.user_id=f.`a_id`) AND  title LIKE ? ", Integer.class, "%" + title + "%");
        }else {
            count = jdbcTemplate.queryForObject("select count(*) from  article a WHERE  EXISTS(  SELECT a_id FROM `favorite` f WHERE f.u_id=1 AND a.user_id=f.`a_id`) ", Integer.class);
        }
        return count;
    }

    public List<Map<String, Object>> findAllFollowById(Integer id) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT username,real_name FROM USER u WHERE  EXISTS(  SELECT u_id FROM `favorite` f WHERE f.a_id=? AND u.id=f.`u_id`)", id);
        return maps;
    }
}
