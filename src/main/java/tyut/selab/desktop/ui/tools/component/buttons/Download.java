package tyut.selab.desktop.ui.tools.component.buttons;

import tyut.selab.desktop.ui.tools.set.buttonset.ButtonSet;
import tyut.selab.desktop.ui.tools.utils.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:Download
 * Package:tools.buttons
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:50
 * @Version:v1.0
 */
public class Download extends JButton {
    public Download(JPanel panel, JPanel switchPanel) {
        ButtonSet.setButton(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/download.png"), new Color(255, 160, 122), this);
        this.setText("下载文件");
        this.setFont(new Font("微软雅黑", Font.BOLD, 25));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwitchPanel.switchPanel(panel, switchPanel);
            }
        });
    }
}
