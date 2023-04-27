package tyut.selab.desktop.moudle.student.usercontroller.impl;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.IUserController;
import tyut.selab.desktop.moudle.student.userservice.IUserService;
import tyut.selab.desktop.moudle.student.userservice.impl.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController implements IUserController {
    private static IUserService userService=new UserService();

    @Override
    public List<UserVo> queryUser() {
        List<UserVo> userVos= userService.queryUser();
        return userVos;
    }
    @Override
    public UserVo queryUserByStudentNumber(Integer studentNumber) {
        UserVo userVo=userService.queryUserByStudentNumber(studentNumber);
        if(userVo == null){
            return null;
        }else {
            return userVo;
        }
    }

    @Override
    public UserVo queryUserByStudentName(String name) {
        UserVo userVo=userService.queryUserByStudentName(name);
        if(userVo == null){
            return null;
        }else {
            return userVo;
        }
    }

    @Override
    public int insertUser(UserRegisterVo user) {
        int judge=userService.insertUser(user);
        return judge;
    }

    @Override
    public int updateUserPassword(String password, UserRegisterVo user)
    {
        int judge=userService.updateUserPassword(password,user);
        return judge;

    }

    @Override
    public int updateUser(UserVo oldUser, UserVo newUser) {
        int judge=userService.updateUser(oldUser,newUser);
        return judge;
    }

    @Override
    public int deleteUser(Integer studentNumber) {
        int judge=userService.deleteUser(studentNumber);
        return judge;

    }

    @Override
    public List<Role> queryAllRole() {
        List<Role> list=userService.queryAllRole();
        return list;
    }

    @Override
    public int insertRole(Role role) {
        int judge =userService.insertRole(role);
        return judge;
    }

    @Override
    public int deleteRole(Role role) {
        int judge =userService.deleteRole(role);
        return judge;
    }

    public static void main(String[] args) {
        IUserController iUserController = new UserController();
//        UserRegisterVo userRegisterVo = new UserRegisterVo();
//        userRegisterVo.setAccountNumber("yyty");
//        userRegisterVo.setGender(1);
//        userRegisterVo.setDuty("daa");
//        userRegisterVo.setName("ttom");
//        userRegisterVo.setPhone("16424342");
//        userRegisterVo.setStudentNumber(4534);
//        userRegisterVo.setPost("dawe233");
//        userRegisterVo.setPassword(232432);
    }
}
