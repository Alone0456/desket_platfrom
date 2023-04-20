package tyut.selab.desktop.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接,使用Druid连接池
 */
public class MysqlConnect{
    private static DataSource ds = null;
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    //类初始化执行
    static{
        try {
            Properties pro = new Properties();

            pro.load(ClassLoader.getSystemResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        //线程本地变量中是否存在
        Connection connection = tl.get();
        //第一次没有
        if (connection == null) {
            connection = ds.getConnection();
            tl.set(connection);
        }
        return connection;
    }

    public static void free() throws SQLException {
        Connection connection = tl.get();
        if (connection != null) {
            tl.remove();//清空线程本地变量数据
            connection.setAutoCommit(true);//事务状态回归默认true
            connection.close();//还给连接池
        }
    }
}

