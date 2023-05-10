package tyut.selab.desktop.utils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

/**
 * 数据库连接,使用Druid连接池
 */
public class MysqlConnect{

    private static DataSource dataSource = null;
    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    static {
        // TODO: 先读取配置文件，调用工厂类的静态方法去创建一个DataSource类对象
        Properties properties = new Properties();
        FileInputStream resourceAsStream = null;
        try {
           resourceAsStream = new FileInputStream(JdbcUtils.class.getResource("/").getPath() + "druid.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dataSource =  DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if( threadLocal.get() == null){
            Connection connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return threadLocal.get();
    }
    public static void closeConnection() throws SQLException {
        if(threadLocal.get() !=null){
            Connection connection = threadLocal.get();
            connection.close();
            threadLocal.remove();
        }
    }
}
