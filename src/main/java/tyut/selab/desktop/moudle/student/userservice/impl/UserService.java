package tyut.selab.desktop.moudle.student.userservice.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;
import tyut.selab.desktop.moudle.student.userservice.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private UserDao userDao;

    @Override
    public List<UserVo> queryUser() {
        return null;
    }

    @Override
    public UserVo queryUserByStudentNumber(Integer studentNumber) {
        return null;
    }

    @Override
    public UserVo queryUserByStudentName(String name) {
        return null;
    }

    @Override
    public int insertUser(UserVo user) {
        return 0;
    }

    @Override
    public int updateUserPassword(String password, UserVo user) {
        return 0;
    }

    @Override
    public UserVo updateUser(UserVo user) {
        return null;
    }

    @Override
    public int deleteUser(int studentNumber) {
        return 0;
    }
}
