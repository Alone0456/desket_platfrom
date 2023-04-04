package tyut.selab.desktop.moudle.login.service.impl;

import tyut.selab.desktop.moudle.login.dao.impl.LoginDao;
import tyut.selab.desktop.moudle.login.service.ILoginService;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;

public class LoginService implements ILoginService {

    private LoginDao loginDao;

    private UserDao userDao;

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
