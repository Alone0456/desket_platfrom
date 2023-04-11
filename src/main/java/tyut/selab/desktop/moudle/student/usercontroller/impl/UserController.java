package tyut.selab.desktop.moudle.student.usercontroller.impl;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.IUserController;
import tyut.selab.desktop.moudle.student.userservice.IUserService;

import java.util.List;

public class UserController implements IUserController {
    private IUserService userService;

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
    public int insertUser(UserRegisterVo user) {
        return 0;
    }

    @Override
    public int updateUserPassword(String password, UserVo user) {
        return 0;
    }

    @Override
    public int updateUser(UserVo oldUser, UserVo newUser) {
        return 0;
    }

    @Override
    public int deleteUser(Integer studentNumber) {
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
