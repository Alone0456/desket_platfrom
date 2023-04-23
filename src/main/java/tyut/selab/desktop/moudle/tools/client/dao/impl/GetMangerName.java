package tyut.selab.desktop.moudle.tools.client.dao.impl;



import tyut.selab.desktop.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetMangerName {
    //查询所有管理
    public static List<String> queryAllManger(){
        List<String> names = new ArrayList<>();
        try{
            //获取连接
            Connection con = MysqlConnect.getConnection();
            //sql语句
            String sql = "select a.name from user a , user_role b where  b.duty like '%管理%'";
            //获取执行对象
            PreparedStatement ps = con.prepareStatement(sql);
            //执行
            ResultSet rs = ps.executeQuery(sql);
            //处理返回结果

            while (rs.next()){
                //获取数据并封装
                String name = rs.getString("name");
                names.add(name);
            }

            //关闭资源

            rs.close();
            ps.close();
            con.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return names;

    }
}
