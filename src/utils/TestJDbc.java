package utils;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Dongao
 * @create 2020-02-16 19:26
 */
public class TestJDbc {
    public static void main(String[] args) {
        try {
            Connection conn = JDBCUtils.getConnection();
            System.out.println("成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

