package tyut.selab.desktop.ui.tools.component.buttons.query;

import tyut.selab.desktop.ui.tools.set.buttonset.ButtonSet;
import tyut.selab.desktop.ui.tools.utils.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:QueryAll
 * Package:tools.buttons.query
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 12:20
 * @Version:v1.0
 */
public class QueryAll extends JButton {
    public QueryAll(JPanel panel, JScrollPane switchPanel){
        ButtonSet.setButton(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/queryAll.png"),new Color(0,206,209),this);
        this.setText("查询所有");
        this.setFont(new Font("微软雅黑", Font.BOLD, 20));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwitchPanel.switchQueryPanel(panel,switchPanel);
            }
        });
    }
}
