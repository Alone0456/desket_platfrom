package tyut.selab.desktop.ui.tools.component.panels.managerpanels;

import tyut.selab.desktop.ui.tools.set.panelset.uploadset.ManagerUploadSet;

import javax.swing.*;

/**
 * ClassName:ManagerUploadSet
 * Package:tools.panels.managerpanels
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:56
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class ManagerUpload {
    public static JPanel getUploadPanel() {
        return ManagerUploadSet.setUpload();
    }
}
