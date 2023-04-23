package tyut.selab.desktop.ui.tools.component.panels.mainpanels;

import tyut.selab.desktop.ui.tools.component.buttons.Download;
import tyut.selab.desktop.ui.tools.component.buttons.query.Query;
import tyut.selab.desktop.ui.tools.component.buttons.Upload;
import tyut.selab.desktop.ui.tools.myexception.MyException;
import tyut.selab.desktop.ui.tools.component.panels.managerpanels.ManagerDownload;
import tyut.selab.desktop.ui.tools.component.panels.managerpanels.ManagerQuery;
import tyut.selab.desktop.ui.tools.component.panels.managerpanels.ManagerUpload;
import tyut.selab.desktop.ui.tools.set.panelset.mainset.ManagerMain;

import javax.swing.*;

/**
 * ClassName:ManagerMainPanel
 * Package:tools.panels.mainpanels
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:01
 * @Version:v1.0
 */
public class ManagerMainPanel {

    public static JPanel getManagerPanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            try {
                throw new MyException("初始化失败");
            } catch (MyException ex) {
                ex.printStackTrace();
            }
        }
        JButton upload = new Upload(ManagerMain.p8, ManagerUpload.getUploadPanel());
        JButton download = new Download(ManagerMain.p8, ManagerDownload.getDownloadPanel());
        JButton query = new Query(ManagerMain.p8, ManagerQuery.getQueryPanel());

        JPanel managerPanel = new ManagerMain(upload, download, query);
        managerPanel.setVisible(true);

        return managerPanel;
    }
}
