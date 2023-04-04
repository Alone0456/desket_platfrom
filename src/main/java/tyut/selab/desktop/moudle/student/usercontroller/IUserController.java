package tyut.selab.desktop.moudle.student.usercontroller;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.List;

public interface IUserController {
    /**
     * 查询全部用户
     * @return
     */
    List<UserVo> queryUser();

    /**
     * 通过学号查询用户
     * @param studentNumber
     * @return
     */
    UserVo queryUserByStudentNumber(Integer studentNumber);

    /**
     * 通过姓名查询用户(包括角色)
     * @param name
     * @return
     */
    UserVo queryUserByStudentName(String name);

    /**
     * 增加学生
     * @param user
     * @return 成功返回1，失败返回-1
     */
    int insertUser(UserVo user);

    /**
     * 修改密码
     * @param password
     * @param user
     * @return 成功返回1，失败返回-1
     */
    int updateUserPassword(String password,UserVo user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    UserVo updateUser(UserVo user);

    /**
     * 注销用户
     * @param studentNumber
     * @return 成功返回1，失败返回-1
     */
    int deleteUser(Integer studentNumber);
}
