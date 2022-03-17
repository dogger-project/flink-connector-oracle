package io.terminus.fdp.flink.oracle.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC连接Oracle
 * @author ouyangjun
 */
public class OracleJDBC {


    public static Connection getConnection(String driver, String url, String user, String password) {
        Connection conn = null;
        try {
            // 加载数据库驱动
            Class.forName(driver);
            // 获取数据库连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("获取Oracle 连接");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Class.forName(driver); // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//127.0.0.1:1521/helowinXDB",
                    "test",
                    "test"); // 获取数据库连接
            // Properties properties=new Properties();
            //properties.
            //  DriverManager.getConnection(url,)
            System.out.println(conn == null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}