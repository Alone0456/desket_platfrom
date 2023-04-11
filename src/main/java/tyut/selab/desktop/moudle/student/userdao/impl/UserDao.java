package tyut.selab.desktop.moudle.student.userdao.impl;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public User queryUserByAccount(String accountNumber, String password) {
        return null;
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
