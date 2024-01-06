package com.hyl.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @version: java version 1.8
 * @version: scala version 2.12
 * @Author: hyl
 * @description:
 * @date: 2024-01-06 19:39
 */
public class DruidConfig {
    public static DruidDataSource getdataSource() {
        // 创建Druid数据源
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/Enterprise");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 配置连接池参数
        dataSource.setInitialSize(5); // 初始化连接数
        dataSource.setMaxActive(20);  // 最大连接数
        dataSource.setMinIdle(3);    // 最小空闲连接数

        return dataSource;
    }
}