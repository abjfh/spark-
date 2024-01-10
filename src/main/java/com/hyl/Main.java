package com.hyl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson2.JSONObject;
import com.hyl.utils.DruidConfig;
import com.hyl.utils.ThreadPoolFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version: java version 1.8
 * @version: scala version 2.12
 * @Author: hyl
 * @description:
 * @date: 2024-01-06 19:30
 */
public class Main {

    public static void main(String[] args) {
        producer(getSize());
    }

    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5, new ThreadPoolFactory("scheduledThread"));
    static DruidDataSource druidDataSource = DruidConfig.getdataSource();

    public static void producer(int size) {

        AtomicInteger atomicInteger = new AtomicInteger(1);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                DruidPooledConnection connection = null;
                try {
                    connection = druidDataSource.getConnection();
                    System.out.println(atomicInteger.get());
                    if(size<atomicInteger.get()*100) {
                        executorService.shutdown();
                        return;
                    }
                    String sql = "select * from enterprise.datadie order by death_data limit "
                            + atomicInteger.getAndAdd(1) * 100 + ",100";
//                    System.out.println(sql);
                    ResultSet rs = connection.createStatement().executeQuery(sql);
                    if (rs != null) {
                        // 获取列数
                        ResultSetMetaData metaData = rs.getMetaData();
                        int columnCount = metaData.getColumnCount();
                        Socket socket = new Socket("hadoop102", 9999);
                        OutputStream outputStream = socket.getOutputStream();

                        // 遍历ResultSet中的每条数据
                        while (rs.next()) {
                            JSONObject jsonObj = new JSONObject();
                            // 遍历每一列
                            for (int i = 1; i <= columnCount; i++) {
                                String columnName = metaData.getColumnLabel(i);
                                String value = rs.getString(columnName);
                                jsonObj.put(columnName, value);
                            }
                            outputStream.write((jsonObj.toString() + "\n").getBytes(StandardCharsets.UTF_8));
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public static int getSize() {

        DruidPooledConnection connection = null;
        String sql = "select count(*) from enterprise.datadie ";
        try {
            connection = druidDataSource.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if (rs != null) {
                rs.next();
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


