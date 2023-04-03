package tyut.selab.desktop.moudle.login.service;

public interface ILoginService {
    /**
     * 登录
     * @return
     */
    int login();

    /**
     * 注册
     * @return
     */
    int register();

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
