package tyut.selab.desktop.moudle.login.dao.impl;

import tyut.selab.desktop.moudle.login.dao.ILoginDao;
import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.student.domain.User;

import java.util.List;

public class LoginDao implements ILoginDao {
    @Override
    public Boolean queryUser(String accountNumber, String password) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public List<LoginLog> queryAllLoginLog() {
        return null;
    }

    @Override
    public List<LoginLog> queryLoginLogByStudentNumber(String studentNumber) {
        return null;
    }

    @Override
    public int insertLoginLog(LoginLog log) {
        return 0;
    }
}
