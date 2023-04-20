package tyut.selab.desktop.ui.tools.tools.src.tools.buttons;

import tools.utils.SwitchPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:UploadSet
 * Package:tools.buttons
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:50
 * @Version:v1.0
 */
public class Upload extends JButton{
        public Upload(JPanel panel, JPanel switchPanel){
            this.setText("上传文件");
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    SwitchPanel.switchPanel(panel,switchPanel);
                }
            });
        }

}
