package tyut.selab.desktop.moudle.login.dao;

import tyut.selab.desktop.moudle.login.domain.LoginLog;

import javax.xml.crypto.Data;
import java.util.List;

public interface ILoginDao {
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
     * 查看某段时间内的登录日志
     * @param startTime
     * @param endingTime
     * @return
     */
    List<LoginLog> showLoginLog(Data startTime, Data endingTime);

    /**
     * 增加记录
     * @param log
     * @return 结果
     */
    int insertLoginLog(LoginLog log);
}
