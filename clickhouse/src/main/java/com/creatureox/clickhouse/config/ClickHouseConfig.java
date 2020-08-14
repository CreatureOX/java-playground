package com.creatureox.clickhouse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CreatureOX
 * date: 2020/8/14
 * description:
 */
@Component
public class ClickHouseConfig {

    private static String clickhouseAddress;

    private static String clickhouseUsername;

    private static String clickhousePassword;

    private static String clickhouseDB;

    private static Integer clickhouseSocketTimeout;

    @Value("${spring.clickhouse.address}")
    public void setClickhouseAddress(String clickhouseAddress){
        ClickHouseConfig.clickhouseAddress = clickhouseAddress;
    }

    @Value("${spring.clickhouse.username}")
    public void setClickhouseUsername(String clickhouseUsername){
        ClickHouseConfig.clickhouseUsername = clickhouseUsername;
    }

    @Value("${spring.clickhouse.password}")
    public void setClickhousePassword(String clickhousePassword){
        ClickHouseConfig.clickhousePassword = clickhousePassword;
    }

    @Value("${spring.clickhouse.db}")
    public void setClickhouseDB(String clickhouseDB){
        ClickHouseConfig.clickhouseDB = clickhouseDB;
    }

    @Value("${spring.clickhouse.socketTimeout}")
    public void setClickhouseSocketTimeout(Integer clickhouseSocketTimeout){
        ClickHouseConfig.clickhouseSocketTimeout = clickhouseSocketTimeout;
    }

    public static Connection getConnection(){
        ClickHouseConnection connection = null;
        ClickHouseProperties properties = new ClickHouseProperties();
        properties.setUser(clickhouseUsername);
        properties.setPassword(clickhousePassword);
        properties.setDatabase(clickhouseDB);
        properties.setSocketTimeout(clickhouseSocketTimeout);
        String[] urls = clickhouseAddress.split(",");
        for (String url: urls){
            ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource(url, properties);
            try {
                return clickHouseDataSource.getConnection();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Map> execSql(String sql){
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            List<Map> list = new ArrayList<>();
            while (resultSet.next()){
                Map row = new HashMap();
                for (int i=1; i<= resultSetMetaData.getColumnCount(); i++){
                    row.put(resultSetMetaData.getCatalogName(i), resultSet.getString(resultSetMetaData.getColumnName(i)));
                }
                list.add(row);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
