package tyut.selab.desktop.moudle.student.usercontroller;

import tyut.selab.desktop.moudle.student.domain.User;

import java.util.List;

public interface IUserController {
    /**
     * 查询全部用户
     * @return
     */
    List<User> queryUser();

    /**
     * 通过学号查询用户
     * @param studentNumber
     * @return
     */
    User queryUserByStudentNumber(int studentNumber);

    /**
     * 增加学生
     * @param user
     * @return 成功返回1，失败返回-1
     */
    int insertUser(User user);

    /**
     * 修改密码
     * @param password
     * @param user
     * @return 成功返回1，失败返回-1
     */
    int updateUser(String password , User user);

    /**
     * 注销用户
     * @param studentNumber
     * @return 成功返回1，失败返回-1
     */
    int deleteUser(int studentNumber);
}
