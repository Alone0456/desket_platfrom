package tyut.selab.desktop.moudle.login.controller.impl;

import tyut.selab.desktop.moudle.login.controller.ILoginController;
import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.login.service.ILoginService;
import tyut.selab.desktop.moudle.login.service.impl.LoginService;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.xml.crypto.Data;
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
    public void autoLogin() throws Exception {
        loginService.autoLogin();
    }

    @Override
    public void rememberAccount() {
        loginService.rememberAccount();
    }

    @Override
    public void rememberPassword() {
        loginService.rememberPassword();
    }

    @Override
    public List<LoginLog> showLoginLog() throws Exception {
        return loginService.showLoginLog();
    }

    @Override
    public List<LoginLog> showLoginLog(Data startTime, Data endingTime) throws Exception {
        return loginService.showLoginLog(startTime,endingTime);
    }

    @Override
    public UserVo getUserVo() {
        return loginService.getUserVo();
    }

    public void changeLoginState(){
        loginService.changeLoginState();
    }



}
