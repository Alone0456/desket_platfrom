package tyut.selab.desktop.moudle.todolist.dao.impl;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class baseDao {

    public baseDao() throws SQLException {
    }

    public   int executeUpdate(String sql, Object... parms) throws SQLException {
        //从连接池拿连接，创小车
        Connection connection = JDBC.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        //设置占位符的值
        if (parms != null && parms.length > 0) {
            for (int i = 0; i < parms.length; i++) {
                ps.setObject(i + 1, parms[i]);
            }
        }

        //执行sql
        int len = ps.executeUpdate();
        ps.close();//砸车

        //判断事务，不开启直接还连接
        if (connection.getAutoCommit()) {
            JDBC.free();
        }

        return len;

    }

    public <T> ArrayList<T> query(Class<T> clazz, String sql, Object... arg) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Connection connection = JDBC.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //赋值？
        if (arg != null && arg.length > 0) {
            for (int i = 0; i < arg.length; i++) {
                preparedStatement.setObject(i + 1, arg[i]);
            }
        }

        ArrayList<T>list =new ArrayList<>();
        ResultSet resultSet =preparedStatement.executeQuery();

        //对resultSet处理，把存在resultSet得数据放到二维数组（猜测），然后遍历把一行行封装成对象
        ResultSetMetaData metaData =resultSet.getMetaData();
        int  columCount =metaData.getColumnCount();//获得行数

        while (resultSet.next()){
            //在循环接数据得对象实例化，同时要求对象需要有无参构造
            T t = clazz.newInstance();


            for (int i = 0; i < columCount; i++) {
                Object value =resultSet.getObject(i);
                //这是对象得属性值
                String columName =metaData.getCatalogName(i);
                Field field =clazz.getDeclaredField(columName);
                field.setAccessible(true);
                field.set(t,value);
            }
            list.add(t);
        }

        resultSet.close();
        preparedStatement.close();
        if (connection.getAutoCommit()){
            JDBC.free();

        }
        return list;
    }
}