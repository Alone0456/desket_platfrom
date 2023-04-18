package tyut.selab.desktop.moudle.student.userdao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.utils.MysqlConnect;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    private QueryRunner qr = new QueryRunner();
    @Override
    public User queryUserByAccount(String accountNumber, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        String sql  ="select account_number,password,name,student_number,gender,phone,post,register_time,login_status,user_role.duty from user,user_role where user.role_id = user_role.role_id and account_number = ? and password = ?";
        try {
            connection  = MysqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,accountNumber);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            return utility(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MysqlConnect.close(connection);
        }
    }

    @Override
    public List<User> queryUser() {
        return null;
    }

    @Override
    public User queryUserByStudentNumber(Integer studentNumber) {
        return null;
    }

    @Override
    public User queryUserByStudentName(String name) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        Role role = new Role();
        Date date;
        Connection connection =null;
        try {
            role = user.getRole();
            date = user.getRegisterTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s_time = dateFormat.format(date);
            Timestamp t_time = Timestamp.valueOf(s_time);
            connection = MysqlConnect.getConnection();
            String sql1 = "insert into user value(null,?,?,?,?,?,?,?,?,?,0)";
            int insert = qr.update(connection,sql1,user.getAccountNumber(),
                    user.getPassword(),user.getName(),user.getStudentNumber(),
                    user.getGender(),user.getPhone(),
                    user.getPost(),t_time,
                    user.getLoginStatus());
            String sql2 = "select role_id from user_role where duty = ?";
            String sql3 = "update user set role_id = ? where student_number =?";
            int update = qr.update(connection,sql3,qr.query(connection,sql2,new ScalarHandler(),role.getDuty()),user.getStudentNumber());
            if(update >0 && insert >0){
                return 1;
            }else{
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MysqlConnect.close(connection);
        }
    }

    @Override
    public int updateUser(String password, User oldUser) {
        return 0;
    }

    @Override
    public int updateUser(User oldUser, User newUser) {
        return 0;
    }

    @Override
    public int deleteUser(int studentNumber) {
        return 0;
    }

    @Override
    public List<Role> queryAllRole() {
        return null;
    }

    @Override
    public int insertRole(Role role) {
        return 0;
    }

    @Override
    public int deleteRole(Role role) {
        return 0;
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
        //resultSet.close();
        return user;
    }
}
