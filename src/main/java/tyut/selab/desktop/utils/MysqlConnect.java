package tyut.selab.desktop.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
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
        Properties properties = new Properties();
        try {
            //获取配置文件
            properties.load(new FileInputStream("resources\\druid.properties"));
            //创建数据源
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    //关闭连接
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null)
            {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
