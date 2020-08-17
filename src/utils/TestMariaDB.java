package utils;

import java.sql.*;

public class TestMariaDB {

    public static void main(String[] args) {
        try {
            String driver ="org.mariadb.jdbc.Driver";
            //从配置参数中获取数据库url
            String url = "jdbc:mariadb://39.97.234.153:3306/databaseinsummer";
            //从配置参数中获取用户名
            String user = "root";
            //从配置参数中获取密码
            String pass = "root";

            //注册驱动
            Class.forName(driver);
            //获取数据库连接
            Connection conn = DriverManager.getConnection(url,user,pass);
            //创建Statement对象
            Statement stmt = conn.createStatement();


            System.out.println("Success!");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}