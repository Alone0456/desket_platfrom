package tyut.selab.desktop.ui.tools.tools.src.tools.main;

import tools.myframe.MyFrame;
import tools.panels.mainpanels.ManagerMainPanel;
import tools.panels.mainpanels.UserMainPanel;

import javax.swing.*;

/**
 * ClassName:MainSet
 * Package:tools
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 15:24
 * @Version:v1.0
 */
public class Main {
    public static void main(String[] args) {
        JPanel userPanel = UserMainPanel.getUserPanel();
        JPanel managerPanel = ManagerMainPanel.getManagerPanel();

        new MyFrame().addPanel(userPanel);
        new MyFrame().addPanel(managerPanel);
    }
}
