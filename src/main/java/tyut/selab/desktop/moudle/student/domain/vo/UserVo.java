package tyut.selab.desktop.moudle.student.domain.vo;

public class UserVo {
    private Integer studentNumber;  //用户学号
    private String name; //用户姓名
    private String accountNumber; //用户账户
    private int gender; //用户性别
    private String phone; //用户电话
    private String post; //用户邮箱
    private String duty; //用户职责

    public UserVo() {
    }

    public UserVo(Integer studentNumber, String name, String accountNumber, int gender, String phone, String post, String duty) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.accountNumber = accountNumber;
        this.gender = gender;
        this.phone = phone;
        this.post = post;
        this.duty = duty;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
