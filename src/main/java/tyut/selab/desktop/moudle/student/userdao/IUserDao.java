package tyut.selab.desktop.moudle.student.userdao;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 通过账号,密码查询用户
     * @param accountNumber
     * @param password
     * @return
     */
    User queryUserByAccount(String accountNumber,String password);

    /**
     * 查询全部用户(包括角色)
     * @return
     */
    List<User> queryUser();

    /**
     * 通过学号查询用户(包括角色)
     * @param studentNumber
     * @return
     */
    User queryUserByStudentNumber(Integer studentNumber);

    /**
     * 通过姓名查询用户(包括角色)
     * @param name
     * @return
     */
    User queryUserByStudentName(String name);

    /**
     * 增加学生
     * @param user
     * @return 成功返回1，失败返回-1
     */
    int insertUser(User user);

    /**
     * 修改密码
     * @param password
     * @param oldUser
     * @return 成功返回1，失败返回-1
     */
    int updateUser(String password,User oldUser);

    /**
     * 修改用户信息
     * @param oldUser
     * @param newUser
     * @return
     */
    int updateUser(User oldUser, User newUser);

    /**
     * 删除学生
     * @param studentNumber
     * @return 成功返回1，失败返回-1
     */
    int deleteUser(int studentNumber);

    /**
     * 查询全部职责
     * @return
     */
    List<Role> queryAllRole();

    /**
     * 增加职责
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 删除职责
     * @param role
     * @return
     */
    int deleteRole(Role role);
}
