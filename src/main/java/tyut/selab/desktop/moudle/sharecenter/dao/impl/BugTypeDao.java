package tyut.selab.desktop.moudle.sharecenter.dao.impl;

import tyut.selab.desktop.moudle.sharecenter.dao.IBugTypeDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.utils.MysqlConnect;

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
            MysqlConnect.free();
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
        String sql = "delete from bug_type where type = ?";
        return executeUpdate(sql,bugType.getBugType());
    }
}