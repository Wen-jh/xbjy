package com.wjh.dao;

import com.wjh.dao.base.BaseDao;
import com.wjh.model.Dept;
import com.wjh.utils.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class DeptDao extends BaseDao<Dept> {
    public DeptDao() {
        super(Dept.class);
    }
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    public List<Map<String, Object>> findAll() {
        String sql="select d.id as deptId,d.name as deptName,u.id as uId,u.username,u.real_name as realName from dept d left join user u on d.id = u.dept_id";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}
