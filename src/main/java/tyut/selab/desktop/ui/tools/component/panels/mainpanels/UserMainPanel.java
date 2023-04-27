package tyut.selab.desktop.ui.tools.component.panels.mainpanels;

<<<<<<< HEAD
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.ui.tools.component.buttons.Download;
import tyut.selab.desktop.ui.tools.component.panels.userpanels.UserDownload;
import tyut.selab.desktop.ui.tools.component.panels.userpanels.UserQuery;
import tyut.selab.desktop.ui.tools.component.panels.userpanels.UserUpload;
import tyut.selab.desktop.ui.tools.component.buttons.query.Query;
import tyut.selab.desktop.ui.tools.component.buttons.Upload;
=======
import tyut.selab.desktop.moudle.login.service.impl.LoginService;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.ui.tools.component.buttons.Download;
import tyut.selab.desktop.ui.tools.component.buttons.Upload;
import tyut.selab.desktop.ui.tools.component.buttons.query.Query;
import tyut.selab.desktop.ui.tools.component.panels.userpanels.UserDownload;
import tyut.selab.desktop.ui.tools.component.panels.userpanels.UserQuery;
import tyut.selab.desktop.ui.tools.component.panels.userpanels.UserUpload;
>>>>>>> baizerong
import tyut.selab.desktop.ui.tools.myexception.MyException;
import tyut.selab.desktop.ui.tools.set.panelset.mainset.UserMain;
import tyut.selab.desktop.ui.tools.utils.FileChooser;

import javax.swing.*;

/**
 * ClassName:UserMainPanel
 * Package:tools.panels
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:52
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class UserMainPanel {
    public static JPanel getUserPanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            try {
                throw new MyException("初始化失败");
            } catch (MyException ex) {
                ex.printStackTrace();
            }
        }
        //获取用户信息
<<<<<<< HEAD
//        User user = LoginService.getUser();
        User user = new User();
        user.setStudentNumber(2022005565);
=======
        User user = LoginService.getUser();
>>>>>>> baizerong
        FileChooser.fileUp.setUser(user);
        FileChooser.fileUpVo.setUser(user);

        JButton upload = new Upload(UserMain.p8, UserUpload.getUploadPanel());
        JButton download = new Download(UserMain.p8, UserDownload.getDownloadPanel());
        JButton query = new Query(UserMain.p8, UserQuery.getQueryPanel());

        JPanel userPanel = new UserMain(upload, download, query);
        userPanel.setVisible(true);

        return userPanel;
    }
}
