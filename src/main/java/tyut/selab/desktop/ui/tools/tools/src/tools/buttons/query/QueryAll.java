package tyut.selab.desktop.ui.tools.tools.src.tools.buttons.query;

import tools.utils.SwitchPanel;

import javax.swing.*;
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
        this.setText("查询所有");
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwitchPanel.switchQueryPanel(panel,switchPanel);
            }
        });
    }
}
