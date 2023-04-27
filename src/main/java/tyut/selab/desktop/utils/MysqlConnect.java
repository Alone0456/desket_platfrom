package tyut.selab.desktop.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接,使用Druid连接池
 */
public class MysqlConnect{


    private static final String URL = "jdbc:mysql://localhost:3306/desktop_platfrom";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private static DruidDataSource dataSource;
    static {
        dataSource = new DruidDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(10);
        dataSource.setMaxWait(30000);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}