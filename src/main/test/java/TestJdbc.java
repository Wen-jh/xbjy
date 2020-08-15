import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.sql.visitor.functions.Now;
import com.alibaba.fastjson.JSONArray;
import com.wjh.dao.ArticleDao;
import com.wjh.dao.DeptDao;
import com.wjh.dao.UserDao;
import com.wjh.dao.base.BaseDao;
import com.wjh.model.Article;
import com.wjh.model.Dept;
import com.wjh.model.PageEntity;
import com.wjh.model.User;
import com.wjh.server.Impl.ArticleServerImpl;
import com.wjh.server.Impl.DeptServerImpl;
import com.wjh.server.Impl.UserServerImpl;
import com.wjh.server.UserServer;
import com.wjh.utils.JDBCUtil;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.*;

public class TestJdbc {
    @Test
    public void method1(){
// 创建druid数据源
 DruidDataSource dataSource = new DruidDataSource();
 Properties prop = new Properties();
 try {
// 加载配置文件
 prop.load(this.getClass().getClassLoader().getResourceAsStream
         ("jdbc.properties"));
 } catch (IOException e)
 {
     e.printStackTrace();
 }
 dataSource.setUsername(prop.getProperty("jdbc.username"));
 dataSource.setPassword(prop.getProperty("jdbc.password"));
 dataSource.setUrl(prop.getProperty("jdbc.url"));
 dataSource.setDriverClassName(prop.getProperty("jdbc.driverClassName"));
 // 创建jdbcTemplate并传入数据源
         JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
         // 执行DDL语句
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from user where id=1");
        System.out.println(map);
    }
    @Test
    public void method2(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from user limit 1");
        System.out.println(
                map
        );

    }
    @Test
    public void method3(){
        List<Map<String, Object>> allFollowById = new ArticleDao().findAllFollowById(1);
        for (Map<String, Object> map : allFollowById) {
            System.out.println(map);
        }

    }
}
