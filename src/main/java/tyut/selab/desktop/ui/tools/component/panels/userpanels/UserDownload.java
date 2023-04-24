package tyut.selab.desktop.ui.tools.component.panels.userpanels;

import tyut.selab.desktop.ui.tools.set.panelset.downloadset.User;

import javax.swing.*;

/**
 * ClassName:UserDownload
 * Package:tools.panels.userpanels
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:55
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class UserDownload {
    public static JPanel getDownloadPanel() {
        return User.setDown();
    }
}
