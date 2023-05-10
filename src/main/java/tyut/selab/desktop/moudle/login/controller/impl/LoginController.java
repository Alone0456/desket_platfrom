package tyut.selab.desktop.moudle.login.controller.impl;

import tyut.selab.desktop.moudle.login.controller.ILoginController;
import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.login.service.ILoginService;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;

import javax.xml.crypto.Data;
import java.util.List;

public class LoginController implements ILoginController{
    private ILoginService loginService;

    @Override
    public String login(String accountNumber, String password) {
        return null;
    }

    @Override
    public String register(UserRegisterVo user) {
        return null;
    }

    @Override
    public void autoLogin() {

    }

    @Override
    public void rememberAccount() {

    }

    @Override
    public void rememberPassword() {

    }

    @Override
    public List<LoginLog> showLoginLog() {
        return null;
    }

    @Override
    public List<LoginLog> showLoginLog(Data startTime, Data endingTime) {
        return null;
    }
}
