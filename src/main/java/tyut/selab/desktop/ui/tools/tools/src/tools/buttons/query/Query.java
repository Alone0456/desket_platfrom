package tyut.selab.desktop.ui.tools.tools.src.tools.buttons.query;

import tools.utils.SwitchPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:Query
 * Package:tools.buttons
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 16:49
 * @Version:v1.0
 */
public class Query extends JButton {
    public Query(JPanel panel, JScrollPane switchPanel){
        this.setText("查询个人信息");
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwitchPanel.switchQueryPanel(panel,switchPanel);
            }
        });
    }
    public Query(JPanel panel, JPanel switchPanel){
        this.setText("查询");
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwitchPanel.switchPanel(panel,switchPanel);
            }
        });
    }
}
