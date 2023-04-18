package tyut.selab.desktop.moudle.login.domain;

import javax.xml.crypto.Data;

public class LoginLog {
    private String name;  //用户名字
    private Integer studentNumber; //用户学号
    private Data LoginTime;  //登录时间
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

    public LoginLog(String name, Integer studentNumber, Data loginTime, String loginIp) {
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

    public Data getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(Data loginTime) {
        LoginTime = loginTime;
    }

    public String getLoginIp() {
        return LoginIp;
    }

    public void setLoginIp(String loginIp) {
        LoginIp = loginIp;
    }
}
