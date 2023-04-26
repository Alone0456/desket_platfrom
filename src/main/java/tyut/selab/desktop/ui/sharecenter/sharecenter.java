package tyut.selab.desktop.ui.sharecenter;

import tyut.selab.desktop.moudle.sharecenter.controller.impl.ShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class sharecenter extends JPanel {
    public sharecenter(){
        UserVo userVo = new UserVo();

        userVo.setDuty("管理员");
        ShareCenterController controller = new ShareCenterController(userVo);
        add(controller.getUi().getHomeJPanel());
        controller.showBugInfo();
        controller.ShowBugInfo(userVo);
        controller.ShowBugInfo(new Vector<String>());

        controller.addAllType();
        BugVo bugVo = new BugVo();
        bugVo.setUserVo(userVo);
        bugVo.setBugType(new Vector<String>());

        controller.insertBugInfo(bugVo);
        controller.deleteBugInfo(bugVo);
        controller.getUi().init();
    }
}
