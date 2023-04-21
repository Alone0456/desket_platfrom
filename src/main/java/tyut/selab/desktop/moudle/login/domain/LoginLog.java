package tyut.selab.desktop.moudle.login.domain;

import java.util.Date;

public class LoginLog {
    private String name;  //用户名字
    private Integer studentNumber; //用户学号
    private Date LoginTime;  //登录时间
    private String LoginIp; //登录IP

    @Override
    public String toString() {
        return "LoginLog{" +
                "name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", LoginTime=" + LoginTime +
                ", LoginIp='" + LoginIp + '\'' +
                '}';
    }

    public LoginLog(String name, Integer studentNumber, Date loginTime, String loginIp) {
        this.name = name;
        this.studentNumber = studentNumber;
        LoginTime = loginTime;
        LoginIp = loginIp;
    }

    public LoginLog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Date getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(Date loginTime) {
        LoginTime = loginTime;
    }

    public String getLoginIp() {
        return LoginIp;
    }

    public void setLoginIp(String loginIp) {
        LoginIp = loginIp;
    }
}
