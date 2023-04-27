package tyut.selab.desktop.moudle.tools.client.domain;

import tyut.selab.desktop.moudle.student.domain.User;

import java.util.Date;

public class FileUp {
    private Integer upId;
    private User user;
    private String upFilePath;
    private Date upTime;
    private String upIp;

    public Integer getUpId() {
        return upId;
    }

    public void setUpId(Integer upId) {
        this.upId = upId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUpFilePath() {
        return upFilePath;
    }

    public void setUpFilePath(String upFilePath) {
        this.upFilePath = upFilePath;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getUpIp() {
        return upIp;
    }

    public void setUpIp(String upIp) {
        this.upIp = upIp;
    }

    @Override
    public String toString() {
        return "FileUp{" +
                "upId=" + upId +
                ", user=" + user +
                ", upFilePath='" + upFilePath + '\'' +
                ", upTime=" + upTime +
                ", upIp='" + upIp + '\'' +
                '}';
    }
}
