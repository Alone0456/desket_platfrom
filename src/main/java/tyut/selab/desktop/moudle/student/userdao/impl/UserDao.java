package tyut.selab.desktop.moudle.student.userdao.impl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.utils.MysqlConnect;
import javax.security.sasl.SaslServer;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class UserDao implements IUserDao {
    private QueryRunner qr = new QueryRunner();

    @Override
    public User queryUserByAccount(String accountNumber, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id and account_number = ? and password = ?";
        try {
            connection = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return utility(resultSet);
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(resultSet, preparedStatement, connection);
        }
    }
    @Override
    public List<User> queryUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        String sql  ="select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id";
        try {
            connection  = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            User user = new User();
            List<User> list = new ArrayList<User>();
            while (resultSet.next()) {
                list.add(utility(resultSet));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MysqlConnect.close(resultSet,preparedStatement,connection);
        }
    }

    @Override
    public User queryUserByStudentNumber(Integer studentNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id and student_number = ?";
        try {
            connection = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentNumber);
            resultSet = preparedStatement.executeQuery();
            return utility(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public User queryUserByStudentName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id and name = ?";
        try {
            connection = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            return utility(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public int insertUser(User user) {
        Date date;
        Connection connection = null;
        try {
            date = user.getRegisterTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s_time = dateFormat.format(date);
            Timestamp t_time = Timestamp.valueOf(s_time);
            connection = MysqlConnect.getConnection();
            String sql1 = "insert into user value(null,?,?,?,?,?,?,?,?,?,null)";
            int insert = qr.update(connection, sql1, user.getAccountNumber(),
                    user.getPassword(), user.getName(), user.getStudentNumber(),
                    user.getGender(), user.getPhone(),
                    user.getPost(), t_time,
                    user.getLoginStatus());
            String sql2 = "select role_id from user_role where duty = ?";
            String sql3 = "update user set role_id = ? where student_number =?";
            int update = qr.update(connection, sql3,qr.query(connection, sql2, new ScalarHandler(), new Role().getDuty()), user.getStudentNumber());
            if (update > 0 && insert > 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(null, null, connection);
        }
    }

    @Override
    public int updateUser(String password, User oldUser) {
        Connection connection = null;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "update user set password =? where student_number =?";
            int update = qr.update(connection, sql, password, oldUser.getStudentNumber());
            return (update > 0 ? 1 : -1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(null, null, connection);
        }
    }

    @Override
    public int updateUser(User oldUser, User newUser) {
        Date date;
        Connection connection = null;
        try {
            date = newUser.getRegisterTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s_time = dateFormat.format(date);
            Timestamp t_time = Timestamp.valueOf(s_time);
            connection = MysqlConnect.getConnection();
            String sql1 = "update user set account_number =?,password =?,`name` =?,gender =?,phone =?,post =?,register_time =?,login_status =? where student_number = ?";
            int update1 = qr.update(connection, sql1, newUser.getAccountNumber(), newUser.getPassword(),
                    newUser.getName(), newUser.getGender(), newUser.getPhone(),
                    newUser.getPost(), t_time, newUser.getLoginStatus(),
                    oldUser.getStudentNumber());
            String sql2 = "select role_id from user_role where duty =?";
            String sql3 = "update user set role_id = ?,student_number =? where student_number";
            int update2 = qr.update(connection, sql3, qr.query(connection, sql2, new ScalarHandler(), newUser.getRole().getDuty()), newUser.getStudentNumber(), oldUser.getStudentNumber());
            if (update1 > 0 && update2 > 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(null, null, connection);
        }
    }

    @Override
    public int deleteUser(int studentNumber) {
        Connection connection = null;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "delete from user where student_number = ?";
            int delete = qr.update(connection, sql, studentNumber);
            return (delete > 0 ? 1 : -1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(null, null, connection);
        }
    }

    @Override
    public List<Role> queryAllRole() {
        Connection connection = null;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "select duty from user_role";
            return qr.query(connection, sql, new BeanListHandler<Role>(Role.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(null, null, connection);
        }
    }

    @Override
    public int insertRole(Role role) {
        Connection connection = null;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "insert into user_role value(null,?)";
            int insert = qr.update(connection, sql, role.getDuty());
            return (insert > 0 ? 1 : -1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(null, null, connection);
        }
    }

    @Override
    public int deleteRole(Role role) {
        Connection connection = null;
        try {
            connection = MysqlConnect.getConnection();
            String sql = "delete from user_role where duty = ?";
            int delete = qr.update(connection, sql, role.getDuty());
            return (delete > 0 ? 1 : -1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MysqlConnect.close(null, null, connection);
        }
    }

    public static User utility(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setAccountNumber(resultSet.getString("account_number"));
        user.setPassword(resultSet.getString("password"));
        user.setName(resultSet.getString("name"));
        user.setStudentNumber(resultSet.getInt("student_number"));
        user.setGender(resultSet.getInt("gender"));
        user.setPhone(resultSet.getString("phone"));
        user.setPost(resultSet.getString("post"));
        user.setRegisterTime(resultSet.getDate("register_time"));
        user.setLoginStatus(resultSet.getInt("login_status"));
        user.setRole(new Role(resultSet.getString("user_role.duty")));
        //resultSet.close();
        return user;
    }

}
