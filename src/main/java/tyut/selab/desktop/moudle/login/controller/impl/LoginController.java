package tyut.selab.desktop.moudle.login.controller.impl;

import tyut.selab.desktop.moudle.login.controller.ILoginController;
import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.login.service.ILoginService;
import tyut.selab.desktop.moudle.login.service.impl.LoginService;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class LoginController implements ILoginController{
    private ILoginService loginService=new LoginService();

    @Override
    public String login(String accountNumber, String password) throws Exception {
        return loginService.login(accountNumber,password);
    }

    @Override
    public String register(UserRegisterVo user) {

        return loginService.register(user);
    }

    @Override
    public List<LoginLog> showLoginLog() throws Exception {
        return loginService.showLoginLog();
    }

    @Override
    public List<LoginLog> showLoginLog(Date startTime, Date endingTime) throws Exception {
        return loginService.showLoginLog(startTime,endingTime);
    }

    @Override
    public UserVo getUserVo() {
        return loginService.getUserVo();
    }

    @Override
    public void save(boolean automaticLogin, boolean rememberNumber, JTextField uField, JPasswordField pFd) throws IOException {
        loginService.save( automaticLogin,  rememberNumber,  uField,  pFd);
    }


    @Override
    public String read() throws FileNotFoundException {
        return loginService.read();
    }

    public void changeLoginState(){
        loginService.changeLoginState();
    }
}
