package com.wjh.dao.base;

import com.wjh.annotation.MyField;
import com.wjh.annotation.MyTable;
import com.wjh.model.Article;
import com.wjh.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseDao<T> {
        private Class<T> tClass;
        private String tableName;
        private String keyName;
        private JdbcTemplate jdbcTemplate;

    public BaseDao(Class<T> tClass) {
        this.tClass = tClass;
        MyTable myTable = tClass.getDeclaredAnnotation(MyTable.class);
        if (null!=myTable){
            tableName=myTable.value();
            keyName=myTable.KeyName();
        }
        jdbcTemplate=new JdbcTemplate(JDBCUtil.getDataSource());
    }
    public boolean update(T obj) {
        //受影响的行数
        int row = 0;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" update ").append(tableName).append(" set ");
            Class<?> objClass = obj.getClass();
            Field[] fields = objClass.getDeclaredFields();
            int count = 0;
            for (Field field : fields) {
                String fieldName = field.getName();
                String colName = field.getName();
                MyField myField = field.getDeclaredAnnotation(MyField.class);
                if (null != myField) {
                    colName = myField.value();
                }

                String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method method = objClass.getDeclaredMethod(methodName);
                Object value = method.invoke(obj);
                if (null != value&&value!="") {
                    sb.append("`").append(colName).append("`").append(" = ?, ");
                    count++;
                }
            }
            sb.delete(sb.lastIndexOf(","), sb.length());
            sb.append(" where ").append(keyName).append(" = ? ");

            Object[] objects = new Object[count + 1];
            Object id = null;
            int index = 0;
            for (Field field : fields) {
                String fieldName = field.getName();
                String colName = field.getName();
                MyField myField = field.getDeclaredAnnotation(MyField.class);
                if (null != myField) {
                    colName = myField.value();
                }
                String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method method = objClass.getDeclaredMethod(methodName);
                Object value = method.invoke(obj);
                if (null != value) {
                    objects[index] = value;
                    index++;
                }

                if (colName.equals(keyName)) {
                    id = value;
                }

            }
            objects[count] = id;
            row = jdbcTemplate.update(sb.toString(), objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }
    public boolean save(T obj){
        Class<?> objClass = obj.getClass();
        int row=0;
        try {
            Field[] fields = tClass.getDeclaredFields();
            int length = fields.length;
            StringBuilder sb = new StringBuilder();
            sb.append("insert into ").append(tableName).append("(");
            for (int i = 0; i <length ; i++) {
                Field field = fields[i];
                String colName = field.getName();
                MyField myField = field.getDeclaredAnnotation(MyField.class);
                if (myField!=null){
                    colName=myField.value();
                }
                if (i==length-1){
                    sb.append("`").append(colName).append("`");
                }else {
                    sb.append("`").append(colName).append("`").append(",");
                }
            }
            sb.append(") value (");
            for (int i = 0; i <length ; i++) {
                if (i==length-1){
                    sb.append("?)");
                }else {
                    sb.append("?").append(",");
                }
            }
            Object[] objects = new Object[length];
            for (int i = 0; i <length ; i++) {
                Field field = fields[i];
                String name = field.getName();
                String getMethodName="get"+name.substring(0,1).toUpperCase()+name.substring(1);
                Method method = objClass.getDeclaredMethod(getMethodName);
                Object value = method.invoke(obj);
                objects[i]=value;
            }

            row = jdbcTemplate.update(sb.toString(),objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row>0;
    }
    public T findById(Object id){
        T t=null;

        try {
            t = jdbcTemplate.queryForObject("select * from " + tableName + " where " + keyName + "= ?", new BeanPropertyRowMapper<>(tClass), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    public boolean delete(Object id){

        int row=0;

        try {
            row = jdbcTemplate.update( "DELETE from " + tableName + "  WHERE " + keyName + "=? ", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row>0;
    }

}
