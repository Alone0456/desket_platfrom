package tyut.selab.desktop.moudle.sharecenter.domain;

import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.Date;
import java.util.List;

public class BugMessage {
    private Integer bugId;
    private String bugTitle;  //bug标题
    private String bugSolve; //bug的解决方法
    private Date releaseTime; //发布时间
    private User user; //用户
    private String bugType; //bug类型

    /**
     *
     * @return
     */
    public BugVo toBugVo(){
        BugVo bugVo = new BugVo(getBugTitle(), getBugSolve(),
                getReleaseTime(), getUserVo(), getBugType());
        return bugVo;
    }

    /**
     *
     * @return
     */
    public UserVo getUserVo() {
        UserVo userVo = new UserVo(user.getStudentNumber(),user.getName(),
                user.getAccountNumber(),user.getGender(),user.getPhone(),
                user.getPost(),user.getAccountNumber());
        return userVo;
    }

    public BugMessage() {
    }

    public BugMessage(Integer bugId, String bugTitle, String bugSolve, Date releaseTime, User user, String bugType) {
        this.bugId = bugId;
        this.bugTitle = bugTitle;
        this.bugSolve = bugSolve;
        this.releaseTime = releaseTime;
        this.user = user;
        this.bugType = bugType;
    }

    public String getBugType() {
        return bugType;
    }

    public void setBugType(String bugType) {
        this.bugType = bugType;
    }
    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle;
    }

    public String getBugSolve() {
        return bugSolve;
    }

    public void setBugSolve(String bugSolve) {
        this.bugSolve = bugSolve;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
