package tyut.selab.desktop.moudle.login.controller.impl;

import tyut.selab.desktop.moudle.login.controller.ILoginController;
import tyut.selab.desktop.moudle.login.service.ILoginService;
import tyut.selab.desktop.moudle.student.domain.User;

public class LoginController implements ILoginController{
    private ILoginService loginService;
    @Override
    public Boolean login(String accountNumber, String password) {
        return null;
    }

    @Override
    public Boolean register(User user) {
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
}
