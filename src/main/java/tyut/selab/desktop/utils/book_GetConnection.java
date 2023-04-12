package tyut.selab.desktop.utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class book_GetConnection {
   public int executeUpdate(String sql,Object...params) throws SQLException {
       Connection connection = MysqlConnect.getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
      if(params !=null && params.length >0){
          for (int i = 1; i <= params.length; i++) {
              preparedStatement.setObject(i,params[i-1]);
          }
      }
       int rows = preparedStatement.executeUpdate();
      preparedStatement.close();
      MysqlConnect.closeConnection();
       return rows;
   }
   public <T> List<T> executeQuery(Class<T> clazz,String sql,Object...params) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
       List<T> list = new ArrayList<>();
       Connection connection = MysqlConnect.getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       if(params !=null && params.length >0){
           for (int i = 1; i <= params.length; i++) {
               preparedStatement.setObject(i,params[i-1]);
           }
       }
       ResultSet resultSet = preparedStatement.executeQuery();
       ResultSetMetaData metaData = resultSet.getMetaData();
       while(resultSet.next()){
           T t = clazz.newInstance();
           for (int i = 1; i <= metaData.getColumnCount(); i++) {
               Object values = null;
               String name = metaData.getColumnLabel(i);
               Field field = clazz.getDeclaredField(name);
               if(field.getType() == Class.forName("java.util.Date")){
                   values = new Date(resultSet.getTimestamp(i).getTime());
               }else {
                    values = resultSet.getObject(i);
               }
               field.setAccessible(true);
               field.set(t,values);
           }
           list.add(t);
       }
          return list;
   }
}
