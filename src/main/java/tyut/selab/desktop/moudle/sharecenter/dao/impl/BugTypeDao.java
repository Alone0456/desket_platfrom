package tyut.selab.desktop.moudle.sharecenter.dao.impl;

import tyut.selab.desktop.moudle.sharecenter.dao.IBugTypeDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.utils.sharecenter.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BugTypeDao extends BaseDao implements IBugTypeDao {
    @Override
    public List<BugType> queryAllType() throws Exception {
        ArrayList<BugType> list = new ArrayList<>();
        String sql = "SELECT * FROM bug_type ;";
        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            BugType bugType = new BugType();
            bugType.setBugTypeId(resultSet.getInt("type_id"));
            bugType.setBugType(resultSet.getString("type"));
            list.add(bugType);
        }
        resultSet.close();
        ps.close();
        //这里检查下是否开启事务,开启不关闭连接,业务方法关闭!
        //没有开启事务的话,直接回收关闭即可!
        if (connection.getAutoCommit()) {
            //回收
            MysqlConnect.close(connection);
        }
        return list;
    }

    @Override
    public int insertBugType(BugType bugType) throws SQLException {
        String sql = "insert into bug_type values(null,?);";
        return executeUpdate(sql,bugType.getBugType());
    }

    @Override
    public int updateBugType(BugType newBugType, BugType oldBugType) throws SQLException {
        String sql = "update bug_type set type = ? where type = ?;";
        return executeUpdate(sql,newBugType.getBugType(),oldBugType.getBugType());
    }

    @Override
    public int delete(BugType bugType) throws SQLException {
        int bugTypeId = queryBugTypeId(bugType.getBugType());
        String sql1 = "delete from bug_type where type = ?;";
        int i = executeUpdate(sql1,bugType.getBugType());
        String sql2 = "delete from user_bug_type where bug_type_id = ?;";
        int j = executeUpdate(sql2,bugTypeId);
        return i+j;
    }
    /**
     * 用于根据 bugType 内容查到 bugTypeId
     * @param bugType
     * @return
     * @throws SQLException
     */
    public int queryBugTypeId(String bugType) throws SQLException {
        String sql = "SELECT * FROM bug_type WHERE type = ?;";
        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //占位符赋值
        ps.setObject(1,bugType);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            int bug_type_id = resultSet.getInt("type_id");
            return bug_type_id;
        }
        resultSet.close();
        ps.close();
        //这里检查下是否开启事务,开启不关闭连接,业务方法关闭!
        //没有开启事务的话,直接回收关闭即可!
        if (connection.getAutoCommit()) {
            //回收
            MysqlConnect.close(connection);
        }
        return 0;
    }
}