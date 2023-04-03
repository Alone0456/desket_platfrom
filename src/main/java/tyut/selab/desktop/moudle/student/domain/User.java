package tyut.selab.desktop.moudle.student.domain;

import java.util.Date;

public class User {
    private String accountNumber;
    private String password;
    private String name;
    private Integer studentNumber;
    private int gender;
    private String phone;
    private String post;
    private Date registerTime;
    private int loginStatus;
    private String duty;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountNumber='" + accountNumber + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", post='" + post + '\'' +
                ", registerTime=" + registerTime +
                ", loginStatus=" + loginStatus +
                ", duty='" + duty + '\'' +
                '}';
    }
}
