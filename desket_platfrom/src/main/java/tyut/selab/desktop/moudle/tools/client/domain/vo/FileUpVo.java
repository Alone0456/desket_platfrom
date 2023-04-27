package tyut.selab.desktop.moudle.tools.client.domain.vo;

import tyut.selab.desktop.moudle.student.domain.User;

import java.util.Date;

public class FileUpVo {
    private User user;
    private String upFilePath;
    private Date upTime;
    private String upIp;

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
}
