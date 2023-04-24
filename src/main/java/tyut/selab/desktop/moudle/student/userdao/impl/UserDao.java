//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tyut.selab.desktop.moudle.student.userdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.utils.MysqlConnect;

public class UserDao implements IUserDao {
    private QueryRunner qr = new QueryRunner();

    public User queryUserByAccount(String accountNumber, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id and account_number = ? and password = ?";
        User var7 =null;
        try {
            connection = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                var7 = utility(resultSet);
            }
            return var7;
        } catch (SQLException var11) {
            throw new RuntimeException(var11);
        } finally {
            MysqlConnect.close(resultSet, preparedStatement, connection);
        }

    }

    public List<User> queryUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id";
        try {
            connection = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
           // new User();
            List<User> list = new ArrayList();
            while(resultSet.next()) {
                list.add(utility(resultSet));
            }
            ArrayList var7 = (ArrayList) list;
            return var7;
        } catch (SQLException var11) {
            throw new RuntimeException(var11);
        } finally {
            MysqlConnect.close(resultSet, preparedStatement, connection);
        }
    }

    public User queryUserByStudentNumber(Integer studentNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id and student_number = ?";
        User var6 = null;
        try {
            connection = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentNumber);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                var6 = utility(resultSet);
            }
            return var6;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        } finally {
            MysqlConnect.close(resultSet, preparedStatement, connection);
        }

    }

    public User queryUserByAccountNumber(String accountNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id and account_number = ?";
        User var9 = null;
        try {
            connection = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,accountNumber );
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                var9 = utility(resultSet);
            }
            return var9;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        } finally {
            MysqlConnect.close(resultSet, preparedStatement, connection);
        }
    }

    public User queryUserByStudentName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id and name = ?";
        User var6 = null ;
        try {
            connection = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                var6 = utility(resultSet);
            }
            return var6;
        } catch (SQLException var10) {
            throw new RuntimeException(var10);
        } finally {
            MysqlConnect.close(resultSet, preparedStatement, connection);
        }
    }

    public int insertUser(User user) {
        Connection connection = null;
        Role role = user.getRole();
        byte var12;
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s_time = dateFormat.format(date);
            Timestamp t_time = Timestamp.valueOf(s_time);
            connection = MysqlConnect.getConnection();
            String sql1 = "insert into user value(null,?,?,?,?,?,?,?,?,?,1)";
            int insert = this.qr.update(connection, sql1, new Object[]{user.getAccountNumber(), user.getPassword(), user.getName(), user.getStudentNumber(), user.getGender(), user.getPhone(), user.getPost(), t_time, user.getLoginStatus()});
            String sql2 = "select role_id from user_role where duty = ?";
            String sql3 = "update user set role_id = ? where student_number =?";
            int update = this.qr.update(connection, sql3, qr.query(connection, sql2, new ScalarHandler(),role.getDuty()), user.getStudentNumber());
            if (update <= 0 || insert <= 0) {
                byte var18 = -1;
                return var18;
            }

            var12 = 1;
        } catch (SQLException var16) {
            throw new RuntimeException(var16);
        } finally {
            MysqlConnect.close((ResultSet)null, (Statement)null, connection);
        }

        return var12;
    }

    public int updateUser(String password, User oldUser) {
        Connection connection = null;
        int var6;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "update user set password = ? where student_number = ?";
            int update = qr.update(connection,sql,password,oldUser.getStudentNumber());
            var6 = update > 0 ? 1 : -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(null,null, connection);
        }

        return var6;
    }

    public int updateUser(User oldUser, User newUser) {
        Connection connection = null;
        byte var13;
        try {
            connection = MysqlConnect.getConnection();
            String sql1 = "update user set account_number =?,password =?,`name` =?,gender =?,phone =?,post =?,login_status =? where student_number = ?";
            int update1 = this.qr.update(connection, sql1, new Object[]{newUser.getAccountNumber(), newUser.getPassword(), newUser.getName(), newUser.getGender(), newUser.getPhone(), newUser.getPost(), newUser.getLoginStatus(), oldUser.getStudentNumber()});
            String sql2 = "select role_id from user_role where duty =?";
            String sql3 = "update user set role_id = ?,student_number =? where student_number";
            int update2 = qr.update(connection,sql3,qr.query(connection,sql2,new ScalarHandler(),newUser.getRole().getDuty()),newUser.getStudentNumber());
            if (update1 <= 0 || update2 <= 0) {
                byte var19 = -1;
                return var19;
            }

            var13 = 1;
        } catch (SQLException var17) {
            throw new RuntimeException(var17);
        } finally {
            MysqlConnect.close((ResultSet)null, (Statement)null, connection);
        }

        return var13;
    }

    public int deleteUser(int studentNumber) {
        Connection connection = null;

        int var5;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "delete from user where student_number = ?";
            int delete = this.qr.update(connection, sql, studentNumber);
            var5 = delete > 0 ? 1 : -1;
        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        } finally {
            MysqlConnect.close((ResultSet)null, (Statement)null, connection);
        }

        return var5;
    }

    public List<Role> queryAllRole() {
        Connection connection = null;

        List var3;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "select duty from user_role";
            var3 = (List)this.qr.query(connection, sql, new BeanListHandler(Role.class));
        } catch (SQLException var7) {
            throw new RuntimeException(var7);
        } finally {
            MysqlConnect.close((ResultSet)null, (Statement)null, connection);
        }

        return var3;
    }

    public int insertRole(Role role) {
        Connection connection = null;

        int var5;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "insert into user_role value(null,?)";
            int insert = this.qr.update(connection, sql, role.getDuty());
            var5 = insert > 0 ? 1 : -1;
        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        } finally {
            MysqlConnect.close((ResultSet)null, (Statement)null, connection);
        }

        return var5;
    }

    public int deleteRole(Role role) {
        Connection connection = null;

        int var5;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "delete from user_role where duty = ?";
            int delete = this.qr.update(connection, sql, role.getDuty());
            var5 = delete > 0 ? 1 : -1;
        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        } finally {
            MysqlConnect.close((ResultSet)null, (Statement)null, connection);
        }

        return var5;
    }

    public static User utility(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setAccountNumber(resultSet.getString("account_number"));
        user.setPassword(resultSet.getString("password"));
        user.setName(resultSet.getString("name"));
        user.setGender(resultSet.getInt("gender"));
        user.setStudentNumber(resultSet.getInt("student_number"));
        user.setGender(resultSet.getInt("gender"));
        user.setPhone(resultSet.getString("phone"));
        user.setPost(resultSet.getString("post"));
        user.setRegisterTime(resultSet.getDate("register_time"));
        user.setLoginStatus(resultSet.getInt("login_status"));
        user.setRole(new Role(resultSet.getString("duty")));
        return user;
    }
}
