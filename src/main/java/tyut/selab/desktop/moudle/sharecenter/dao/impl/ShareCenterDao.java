package tyut.selab.desktop.moudle.sharecenter.dao.impl;

import tyut.selab.desktop.moudle.sharecenter.dao.IShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.utils.MysqlConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShareCenterDao extends BaseDao implements IShareCenterDao {
    @Override
    public List<BugMessage> queryAllBugInfo() throws Exception {
        BugMessage bugMessage = null;
        User user = null;
        Role role = null;

        String sql = "SELECT a.bug_id,a.bug_titile,a.bug_solve,a.release_time,d.*,e.duty,c.type\n" +
                "from user_bug_message as a \n" +
                "join user_bug_type as b\n" +
                "on a.bug_id = b.bug_id \n" +
                "join bug_type c\n" +
                "on b.bug_type_id = c.type_id\n" +
                "join user as d\n" +
                "on a.user_student_number = d.student_number\n" +
                "join user_role as e\n" +
                "on d.role_id = e.role_id\n" +
                ";";

        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //无占位符，不用赋值

        ResultSet resultSet = ps.executeQuery();
        ArrayList<BugMessage> list = new ArrayList<>();

        while(resultSet.next()){
            //封装对象
            bugMessage = new BugMessage();
            bugMessage.setBugId(resultSet.getInt("bug_id"));
            bugMessage.setBugTitle(resultSet.getString("bug_titile"));
            bugMessage.setBugSolve(resultSet.getString("bug_solve"));
            bugMessage.setReleaseTime(resultSet.getDate("release_time"));
            {
                user = new User();
                user.setAccountNumber(resultSet.getString("account_number"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setStudentNumber(resultSet.getInt("student_number"));
                user.setGender(resultSet.getInt("gender"));
                user.setPhone(resultSet.getString("phone"));
                user.setPost(resultSet.getString("post"));
                user.setRegisterTime(resultSet.getDate("register_time"));
                user.setLoginStatus(resultSet.getInt("login_status"));
                {
                    role = new Role(resultSet.getString("duty"));
                }
                user.setRole(role);
            }
            bugMessage.setUser(user);
            bugMessage.setBugType(resultSet.getString("type"));

            // 添加集合
            list.add(bugMessage);
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
    public List<BugMessage> queryBugInfoByType(List<String> bugType) throws SQLException {
        BugMessage bugMessage = null;
        User user = null;
        Role role = null;

        StringBuffer sql = new StringBuffer("SELECT a.bug_id,a.bug_titile,a.bug_solve,a.release_time,d.*,e.duty,c.type\n" +
                "from user_bug_message as a \n" +
                "join user_bug_type as b\n" +
                "on a.bug_id = b.bug_id \n" +
                "join bug_type as c\n" +
                "on b.bug_type_id = c.type_id\n" +
                "join user as d\n" +
                "on a.user_student_number = d.student_number\n" +
                "join user_role as e\n" +
                "on d.role_id = e.role_id\n" +
                "where c.type = ? ");
        for (int i = 1; i < bugType.size(); i++) {
            sql.append("or c.type = ? ");
        }
        sql.append(";");

        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(String.valueOf(sql));
        //占位符赋值
        for (int i = 1; i <= bugType.size(); i++) {
            ps.setObject(i,bugType.get(i-1));
        }

        ResultSet resultSet = ps.executeQuery();
        ArrayList<BugMessage> list = new ArrayList<>();

        while(resultSet.next()){
            //封装对象
            bugMessage = new BugMessage();
            bugMessage.setBugId(resultSet.getInt("bug_id"));
            bugMessage.setBugTitle(resultSet.getString("bug_titile"));
            bugMessage.setBugSolve(resultSet.getString("bug_solve"));
            bugMessage.setReleaseTime(resultSet.getDate("release_time"));
            {
                user = new User();
                user.setAccountNumber(resultSet.getString("account_number"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setStudentNumber(resultSet.getInt("student_number"));
                user.setGender(resultSet.getInt("gender"));
                user.setPhone(resultSet.getString("phone"));
                user.setPost(resultSet.getString("post"));
                user.setRegisterTime(resultSet.getDate("register_time"));
                user.setLoginStatus(resultSet.getInt("login_status"));
                {
                    role = new Role(resultSet.getString("duty"));
                }
                user.setRole(role);
            }
            bugMessage.setUser(user);
            bugMessage.setBugType(resultSet.getString("type"));

            // 添加集合
            list.add(bugMessage);
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
    public List<BugMessage> ShowBugInfo(User user) throws Exception {
        BugMessage bugMessage = null;

        String sql = "SELECT a.bug_id,a.bug_titile,a.bug_solve,a.release_time,c.type\n" +
                "from user_bug_message as a \n" +
                "join user_bug_type as b\n" +
                "on a.bug_id = b.bug_id \n" +
                "join bug_type c\n" +
                "on b.bug_type_id = c.type_id\n" +
                "where a.user_student_number = ?\n"+
                ";";

        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //占位符赋值
        ps.setObject(1,user.getStudentNumber());

        ResultSet resultSet = ps.executeQuery();
        ArrayList<BugMessage> list = new ArrayList<>();

        while(resultSet.next()){
            //封装对象
            bugMessage = new BugMessage();
            bugMessage.setBugId(resultSet.getInt("bug_id"));
            bugMessage.setBugTitle(resultSet.getString("bug_titile"));
            bugMessage.setBugSolve(resultSet.getString("bug_solve"));
            bugMessage.setReleaseTime(resultSet.getDate("release_time"));
            bugMessage.setUser(user);
            bugMessage.setBugType(resultSet.getString("type"));

            // 添加集合
            list.add(bugMessage);
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
    public int insertBugInfo(BugMessage bugMessage) throws Exception {
        int i = 0;
        if(bugMessage.getBugTitle()!=null){
            // 插入 user_bug_message 表数据
            String sql1 = "insert into user_bug_message values(null,?,?,?,?);";
            i = executeUpdate(sql1, bugMessage.getBugTitle(), bugMessage.getBugSolve(),
                    bugMessage.getReleaseTime(), bugMessage.getUser().getStudentNumber());
        }
        // 查到 bug_type 对应的 id
        int bugTypeId = queryBugTypeId(bugMessage.getBugType());
        // 查到 bug 对应的 id
        int bugId = queryMaxBugId();
        // 插入 user_bug_type 表数据
        String sql4 = "insert into user_bug_type values(?,?);";
        int j = executeUpdate(sql4, bugTypeId, bugId);
        return i+j;
    }

    @Override
    public int updateBugInfo(BugMessage newBugMessage, BugMessage oldBugMessage) throws SQLException {
        int oldBugId = queryBugId(oldBugMessage);
        int newBugId = queryBugId(newBugMessage);
        // 设置bugId值
        oldBugMessage.setBugId(oldBugId);
        newBugMessage.setBugId(newBugId);
        int i = 0,j = 0,k;
        if (newBugMessage.getBugSolve()!=null) {
            // 更新 user_bug_message 表
            String sql1 = "update user_bug_message set bug_titile = ?,bug_solve = ?,release_time = ? where bug_id = ?;";
            i = executeUpdate(sql1, newBugMessage.getBugTitle(), newBugMessage.getBugSolve(),
                    newBugMessage.getReleaseTime(), oldBugMessage.getBugId());
            // 删除 user_bug_type 表该 bug_id 对应的所有内容
            String sql2 = "DELETE FROM user_bug_type WHERE bug_id = ?;";
            j = executeUpdate(sql2, oldBugMessage.getBugId());
        }
        if (newBugMessage.getBugSolve()!=null) {
            // 插入 user_bug_type 表该 bug_id 对应的新内容
            int newBugTypeId = queryBugTypeId(newBugMessage.getBugType());
            String sql3 = "insert into user_bug_type values(?,?);";
            k = executeUpdate(sql3, newBugTypeId, oldBugId);
        }else {
            int newBugTypeId = queryBugTypeId(newBugMessage.getBugType());
            String sql3 = "insert into user_bug_type values(?,?);";
            k = executeUpdate(sql3, newBugTypeId, newBugId);
        }
        return i+j+k;
    }

    @Override
    public int deleteBugInfo(BugMessage bugMessage) throws SQLException {
        int bugId = queryBugId(bugMessage);
        // 设置bugId值
        bugMessage.setBugId(bugId);
        // 删 user_bug_message 表数据
        String sql1 = "DELETE FROM user_bug_message WHERE bug_id = ?;" ;
        int i = executeUpdate(sql1, bugMessage.getBugId());
        // 删 user_bug_type 表数据
        String sql2 = "DELETE FROM user_bug_type WHERE bug_id = ?;" ;
        int j = executeUpdate(sql2, bugMessage.getBugId());
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
            MysqlConnect.free();
        }
        return 0;
    }

    /**
     * 用于查到刚插入的数据的 id
     * @return
     * @throws SQLException
     */
    private int queryMaxBugId() throws SQLException {
        String sql = "select max(bug_id) from user_bug_message;";
        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            int bug_id = resultSet.getInt(1);
            return bug_id;
        }
        resultSet.close();
        ps.close();
        //这里检查下是否开启事务,开启不关闭连接,业务方法关闭!
        //没有开启事务的话,直接回收关闭即可!
        if (connection.getAutoCommit()) {
            //回收
            MysqlConnect.free();
        }
        return 0;
    }

    /**
     * 用于根据 bug_titile and user_student_number 查到 id
     * @param bugMessage
     * @return
     * @throws SQLException
     */
    private int queryBugId(BugMessage bugMessage) throws SQLException {
        int bugId = 0;
        String sql = "SELECT bug_id FROM user_bug_message WHERE bug_titile = ? and user_student_number = ?;";
        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //占位符赋值
        ps.setObject(1,bugMessage.getBugTitle());
        ps.setObject(2,bugMessage.getUser().getStudentNumber());
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            bugId = resultSet.getInt(1);
            return bugId;
        }
        resultSet.close();
        ps.close();
        //这里检查下是否开启事务,开启不关闭连接,业务方法关闭!
        //没有开启事务的话,直接回收关闭即可!
        if (connection.getAutoCommit()) {
            //回收
            MysqlConnect.free();
        }
        return 0;
    }
}

