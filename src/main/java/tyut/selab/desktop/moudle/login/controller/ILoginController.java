package tyut.selab.desktop.moudle.login.controller;

import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.xml.crypto.Data;
import java.util.List;

public interface ILoginController {
    /**
     * 登录
     * @return
     */
    String login(String accountNumber, String password) throws Exception;

    /**
     * 注册
     * @return
     */
    String register(UserRegisterVo user);

    /**
     * 自动登录
     */
    void autoLogin() throws Exception;

    /**
     * 记住账号
     */
    void rememberAccount();

    /**
     * 记住密码
     */
    void rememberPassword();

    /**
     * 查询登录日志
     * @return
     */
    List<LoginLog> showLoginLog() throws Exception;

    /**
     * 查看某段时间内的登录日志
     * @param startTime
     * @param endingTime
     * @return
     */
    List<LoginLog> showLoginLog(Data startTime, Data endingTime) throws Exception;
    public UserVo getUserVo();
}
