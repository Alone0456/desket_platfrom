package tyut.selab.desktop.moudle.login.service;

import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface ILoginService {
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

    /**
     * 改变用户的的登录状态
     */
     void changeLoginState();
     UserVo getUserVo();

    /**
     * 将账号，密码，记住密码和自动登录的选中状态保存到本地文件中
     * @param automaticLogin
     * @param rememberNumber
     * @param uField
     * @param pFd
     * @throws IOException
     */
       void save(boolean automaticLogin, boolean rememberNumber, JTextField uField, JPasswordField pFd) throws IOException;

    /**
     * 从本地文件中读取账号，密码，记住账号和记住密码的选中状态
     * @return
     * @throws FileNotFoundException
     */
      String read() throws FileNotFoundException;

}
