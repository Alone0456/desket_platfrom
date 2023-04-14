package tyut.selab.desktop.moudle.student.userdao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao {
    private QueryRunner qr = new QueryRunner();
    public User queryUserByAccount(String accountNumber, String password) {
        Connection connection =null;
        try {
            String sql = "select * from user"+
                    "where accounterNumber ="+accountNumber+",password"+password
                    ;
            connection = MysqlConnect.getConnection();
            return (User) qr.query(connection,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MysqlConnect.close(null,null,connection);
        }



    }

    @Override
    public List<User> queryUser() {
        Connection connection =null;
        try {
            String sql = "select * from actor";
            connection = MysqlConnect.getConnection();
            return qr.query(connection,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MysqlConnect.close(null,null,connection);
        }

    }

    @Override
    public User queryUserByStudentNumber(Integer studentNumber) {
        Connection connection =null;
        try {
            String sql = "select * from user"+
                    "where studentNumber ="+studentNumber
                    ;
            connection = MysqlConnect.getConnection();
            return (User) qr.query(connection,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MysqlConnect.close(null,null,connection);
        }

    }

    @Override
    public User queryUserByStudentName(String name) {
        Connection connection =null;
        try {
            String sql = "select * from user"+"where studentNumber ="+name;
            connection = MysqlConnect.getConnection();
            return (User) qr.query(connection,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MysqlConnect.close(null,null,connection);
        }

    }

    @Override
    public int insertUser(User user) {  Connection connection =null;
        try {
            String sql = "insert into actor(account_number,password,name,gender,phone,register_time,role_id) value(?,?,?,?,?,?,?)";
            connection = MysqlConnect.getConnection();

            qr.query(connection,sql,new BeanListHandler<>(User.class));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            MysqlConnect.close(null,null,connection);
        }
        return 0;
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
}
