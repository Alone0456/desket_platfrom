package tyut.selab.desktop.moudle.login.controller;

import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
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
    List<LoginLog> showLoginLog(Date startTime, Date endingTime) throws Exception;
     UserVo getUserVo();

       void save(boolean automaticLogin, boolean rememberNumber, JTextField uField, JPasswordField pFd) throws IOException;
      String read() throws FileNotFoundException;
}
