package tyut.selab.desktop.moudle.login.service.impl;

import tyut.selab.desktop.moudle.login.dao.ILoginDao;
import tyut.selab.desktop.moudle.login.service.ILoginService;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

public class LoginService implements ILoginService {

    private ILoginDao loginDao;

    private IUserDao userDao;

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
