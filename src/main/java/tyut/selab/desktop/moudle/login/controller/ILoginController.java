package tyut.selab.desktop.moudle.login.controller;

import tyut.selab.desktop.moudle.student.domain.User;

public interface ILoginController {
    /**
     * 登录
     * @return
     */
    Boolean login(String accountNumber, String password);

    /**
     * 注册
     * @return
     */
    Boolean register(User user);

    /**
     * 自动登录
     */
    void autoLogin();

    /**
     * 记住账号
     */
    void rememberAccount();

    /**
     * 记住密码
     */
    void rememberPassword();
}
