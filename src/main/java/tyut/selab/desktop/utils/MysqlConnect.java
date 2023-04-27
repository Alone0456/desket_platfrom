package tyut.selab.desktop.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 数据库连接,使用Druid连接池
 */
public class MysqlConnect{
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            properties.load(MysqlConnect.class.getClassLoader().getResourceAsStream("druid.properties"));

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(Statement statement,Connection connection){
        close(statement,null,connection);
    }

    public static void close(Statement statement, ResultSet resultSet ,Connection connection){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
