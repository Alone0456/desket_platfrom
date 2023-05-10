package tyut.selab.desktop.moudle.sharecenter.domain;

import tyut.selab.desktop.moudle.student.domain.User;

import java.util.Date;

public class BugMessage {
    private Integer bugId;
    private String bugTitle;  //bug标题
    private String bugSolve; //bug的解决方法
    private Date releaseTime; //发布时间
    private User user; //用户
}
