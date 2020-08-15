package com.wjh.dao;

import com.wjh.dao.base.BaseDao;
import com.wjh.model.User;
import com.wjh.model.Userfocus;
import com.wjh.utils.JDBCUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    public boolean toLogin(String username,String password){

        List<User> list = jdbcTemplate.query("select *from user where username=? and password=? ", new BeanPropertyRowMapper<>(User.class), username, password);
        if (list!=null){
            return true;
        }else {
            return false;
        }

    }

    public boolean toRegister(User user) {
        int row = jdbcTemplate.update("insert into user (username,password) values (?,?);", user.getUsername(), user.getPassword());
        return row>0;
    }

    public List<User> findUser(Integer startIndex, Integer pageSize, String username) {
        List<User> list = null;

        if (username!=null&username!=""){
            String rname="%" + username + "%";
            list=jdbcTemplate.query( "select * from user where real_name like ? limit ?,?", new BeanPropertyRowMapper<>(User.class),rname,startIndex,pageSize);
        }else {
            list = jdbcTemplate.query( "select * from user limit ?,?", new BeanPropertyRowMapper<>(User.class),startIndex,pageSize);
        }
        return list;
    }
    public Integer findAll(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from user ", Integer.class);
        return count;
    }

    public User findUserByUsername(String username) {

        User user = jdbcTemplate.queryForObject("select * from user where username=?", new BeanPropertyRowMapper<>(User.class), username);
        return user;
    }

    public Integer countFollowByUid(Integer uId) {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from userfocus where user_id=?", Integer.class, uId);
        return integer;
    }

    public void updateLoginTimeByUsername(String username) {
        int updateLoginTime = jdbcTemplate.update("UPDATE user set login_time=NOW() where username=? ", username);
    }

    public  List<Map<String, Object>> findMyUserByUid(Integer id, Integer startIndex, Integer pageSize) {
        String sql = "select u.id userId,u.real_name realName,u.is_secret isSecret from user u where u.id in (\n" +"SELECT\n" + "\tuf.user_focus_id userId \n" + "FROM\n" + "\tuserfocus uf\n" + "\tLEFT JOIN USER u ON u.id = uf.user_id \n" + "WHERE\n" + "\tuf.user_id = ?\n" + ") limit ?,?";
        return jdbcTemplate.queryForList(sql,id,startIndex,pageSize);
    }
    public  Integer countAll(Integer id){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from user where id=?", Integer.class, id);
        return integer;
    }
}
