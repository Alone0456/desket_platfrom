package tyut.selab.desktop.moudle.sharecenter.domain.vo;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BugVo {
    private String bugTitle; //bug标题
    private String bugSolve; //bug解决办法
    private Date releaseTime; //发布时间
    private UserVo userVo; //用户
    private List<String> bugType = new ArrayList<>(); //bug类型

    public BugVo() {
    }

    /**
     *
     * @param bugTitle
     * @param bugSolve
     * @param releaseTime
     * @param userVo
     * @param bugType  String类型
     */
    public BugVo(String bugTitle, String bugSolve, Date releaseTime, UserVo userVo, String bugType) {
        this.bugTitle = bugTitle;
        this.bugSolve = bugSolve;
        this.releaseTime = releaseTime;
        this.userVo = userVo;
        this.bugType.add(bugType);
    }

    @Override
    public String toString() {
        return "BugVo{" +
                "bugTitle='" + bugTitle + '\'' +
                ", bugSolve='" + bugSolve + '\'' +
                ", releaseTime=" + releaseTime +
                ", userVo=" + userVo +
                ", bugType=" + bugType +
                '}';
    }

    public void addBugType(String bugType){
        this.bugType.add(bugType);
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

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public List<String> getBugType() {
        return bugType;
    }

    public void setBugType(List<String> bugType) {
        this.bugType = bugType;
    }


}
