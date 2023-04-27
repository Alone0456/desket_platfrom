package tyut.selab.desktop.moudle.sharecenter.domain.vo;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.Date;
import java.util.List;

public class BugVo {
    private String bugTitle; //bug标题
    private String bugSolve; //bug解决办法
    private Date releaseTime; //发布时间
    private UserVo userVo; //用户
    private List<String> bugType; //bug类型
}
