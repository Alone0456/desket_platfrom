package tyut.selab.desktop.ui.tools.component.buttons.query;

import tyut.selab.desktop.ui.tools.component.jtextfield.IdText;

import tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane.QueryByIdDate;
import tyut.selab.desktop.ui.tools.utils.FileChooser;
import tyut.selab.desktop.ui.tools.utils.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:Ensure
 * Package:tools.buttons.query
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 16:31
 * @Version:v1.0
 */
public class Ensure extends JButton {
    public Ensure(){
        this.setText("确定");
        this.setFont(new Font("华文行楷",Font.BOLD,15));
        this.setBackground(Color.blue);
        this.setForeground(Color.black);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JScrollPane queryByIdDate = new QueryByIdDate();
                SwitchPanel.switchQueryPanel(QueryById.queryByIdSet,queryByIdDate);
            }
        });
    }
}
