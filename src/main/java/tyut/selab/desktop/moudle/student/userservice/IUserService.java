package tyut.selab.desktop.moudle.student.userservice;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.List;

public interface IUserService {
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
     * 管理员
     */
    int insertUser(UserRegisterVo user);

    /**
     * 修改密码
     * @param password
     * @param user
     * @return 成功返回1，失败返回-1
     */
    int updateUserPassword(String password,UserVo user);

    /**
     * 修改用户信息
     * @param oldUser
     * @param newUser
     * @return
     */
    int updateUser(UserVo oldUser,UserVo newUser);

    /**
     * 注销用户
     * @param studentNumber
     * @return 成功返回1，失败返回-1
     * 管理员
     */
    int deleteUser(int studentNumber);

    /**
     * 查询全部职责
     * @return
     */
    List<Role> queryAllRole();

    /**
     * 添加职责
     * @param role
     * @return
     * 管理员
     */
    int insertRole(Role role);

    /**
     * 删除职责
     * @param role
     * @return
     * 管理员
     */
    int deleteRole(Role role);
}
