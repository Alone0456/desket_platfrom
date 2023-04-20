package tyut.selab.desktop.ui.tools.tools.src.tools.panels.mainpanels;

import tools.buttons.Download;
import tools.buttons.query.Query;
import tools.buttons.Upload;
import tools.myexception.MyException;
import tools.panels.userpanels.UserDownload;
import tools.panels.userpanels.UserQuery;
import tools.panels.userpanels.UserUpload;
import tools.set.panelset.mainset.UserMain;

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

        JButton upload = new Upload(UserMain.p8, UserUpload.getUploadPanel());
        JButton download = new Download(UserMain.p8, UserDownload.getDownloadPanel());
        JButton query = new Query(UserMain.p8, UserQuery.getQueryPanel());

        JPanel userPanel = new UserMain(upload, download, query);
        userPanel.setVisible(true);

        return userPanel;
    }
}
