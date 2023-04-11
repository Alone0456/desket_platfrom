package tyut.selab.desktop.moudle.student.domain;

import java.util.Date;

public class User {
    private String accountNumber; //用户账号
    private String password; //用户密码
    private String name;   //姓名
    private Integer studentNumber;  //用户学号
    private int gender; //性别
    private String phone; //电话
    private String post; //邮箱
    private Date registerTime; //登录时间
    private int loginStatus; //登录状态
    private Role role; //用户职责
}
