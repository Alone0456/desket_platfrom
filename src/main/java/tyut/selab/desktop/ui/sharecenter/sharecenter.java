package tyut.selab.desktop.ui.sharecenter;

import tyut.selab.desktop.moudle.login.service.impl.LoginService;
import tyut.selab.desktop.moudle.sharecenter.controller.impl.ShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class sharecenter extends JPanel {
    public sharecenter(){
        User user = LoginService.getUser();
        UserVo userVo = new UserVo(user.getStudentNumber(), user.getName(), user.getAccountNumber(),
                user.getGender(), user.getPhone(),
                user.getPost(), user.getRole().getDuty());
        function functions = new function(userVo);
        add(functions.getUi().getHomeJPanel());
        functions.showBugInfo();
        functions.ShowBugInfo(userVo);
        functions.ShowBugInfo(new Vector<String>());

        functions.addAllType();
        BugVo bugVo = new BugVo();
        bugVo.setUserVo(userVo);
        bugVo.setBugType(new Vector<String>());
        functions.insertBugInfo(userVo);
        functions.updateBugInfo(userVo);
        functions.deleteBugInfo();
        functions.getUi().init();

    }
}
