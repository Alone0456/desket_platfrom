package tyut.selab.desktop.moudle.login.dao;

import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ILoginDao {
    /**
     * 查询所有记录
     * @return 结果
     */
    List<LoginLog> queryAllLoginLog() throws Exception;

    /**
     * 通过学号查询记录
     * @param studentNumber
     * @return 结果
     */
    List<LoginLog> queryLoginLogByStudentNumber(String studentNumber) throws Exception;

    /**
     * 查看某段时间内的登录日志
     * @param startTime
     * @param endingTime
     * @return
     */
    List<LoginLog> showLoginLog(Date startTime, Date endingTime) throws Exception;

    /**
     * 增加记录
     * @param log
     * @return 结果
     */
    int insertLoginLog(LoginLog log) throws Exception;

}
