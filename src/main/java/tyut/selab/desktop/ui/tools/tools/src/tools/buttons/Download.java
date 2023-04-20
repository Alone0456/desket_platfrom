package tyut.selab.desktop.ui.tools.tools.src.tools.buttons;

import tools.utils.SwitchPanel;

import javax.swing.*;
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
    public Download(JPanel panel, JPanel switchPanel){
        this.setText("下载文件");
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwitchPanel.switchPanel(panel,switchPanel);
            }
        });
    }
}
