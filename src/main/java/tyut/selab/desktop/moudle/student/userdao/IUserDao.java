package tyut.selab.desktop.moudle.student.userdao;

import tyut.selab.desktop.moudle.student.domain.User;

import java.util.List;

public interface IUserDao {
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
     * 修改用户
     * @param newUser
     * @param oldUser
     * @return 成功返回1，失败返回-1
     */
    int updateUser(User newUser,User oldUser);

    /**
     * 删除学生
     * @param studentNumber
     * @return 成功返回1，失败返回-1
     */
    int deleteUser(int studentNumber);
}
