package tyut.selab.desktop.ui.tools.component.buttons.query;

import tyut.selab.desktop.ui.tools.set.buttonset.ButtonSet;
import tyut.selab.desktop.ui.tools.utils.SwitchPanel;

import javax.swing.*;
import java.awt.*;
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
@SuppressWarnings("all")
public class Query extends JButton {

    public Query(JPanel panel, JScrollPane switchPanel) {
        ButtonSet.setButton(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/query.png"), new Color(0, 206, 209), this);
        this.setText("查询个人信息");
        this.setFont(new Font("微软雅黑", Font.BOLD, 25));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwitchPanel.switchQueryPanel(panel, switchPanel);
            }
        });
    }

    public Query(JPanel panel, JPanel switchPanel) {
        ButtonSet.setButton(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/query.png"), new Color(0, 206, 209), this);
        this.setText("查询");
        this.setFont(new Font("微软雅黑", Font.BOLD, 25));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwitchPanel.switchPanel(panel, switchPanel);
            }
        });
    }
}
