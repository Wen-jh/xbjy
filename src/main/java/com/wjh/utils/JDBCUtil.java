package com.wjh.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.util.Properties;

public class JDBCUtil {

    private DruidDataSource dataSource;

    private static class Holder {
        private static final JDBCUtil INSTANCE = new JDBCUtil();
    }

    private JDBCUtil() {
        // 创建druid数据源
        dataSource = new DruidDataSource();
        Properties prop = new Properties();
        try {
            // 加载配置文件
            prop.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource.setUsername(prop.getProperty("jdbc.username"));
        dataSource.setPassword(prop.getProperty("jdbc.password"));
        dataSource.setUrl(prop.getProperty("jdbc.url"));
        dataSource.setDriverClassName(prop.getProperty("jdbc.driverClassName"));
    }

    public static DruidDataSource getDataSource() {
        return Holder.INSTANCE.dataSource;
    }




}
