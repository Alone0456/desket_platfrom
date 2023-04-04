package tyut.selab.desktop.moudle.login.dao;

import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.student.domain.User;

import java.util.List;

public interface ILoginDao {
    /**
     * 通过账号，密码查询用户
     * @param accountNumber
     * @param password
     * @return
     */
    Boolean queryUser(String accountNumber, String password);

    /**
     * 添加用户
     * @param user
     * @return 结果
     */
    int insertUser(User user);

    /**
     * 查询所有记录
     * @return 结果
     */
    List<LoginLog> queryAllLoginLog();

    /**
     * 通过学号查询记录
     * @param studentNumber
     * @return 结果
     */
    List<LoginLog> queryLoginLogByStudentNumber(String studentNumber);

    /**
     * 增加记录
     * @param log
     * @return 结果
     */
    int insertLoginLog(LoginLog log);
}
