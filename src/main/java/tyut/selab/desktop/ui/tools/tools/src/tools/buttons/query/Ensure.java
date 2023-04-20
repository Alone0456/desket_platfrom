package tyut.selab.desktop.ui.tools.tools.src.tools.buttons.query;

import tools.jtextfield.IdText;
import tools.set.panelset.queryset.ManagerQuerySet;
import tools.set.panelset.queryset.jscrollpane.QueryAllDate;
import tools.set.panelset.queryset.jscrollpane.QueryByIdDate;
import tools.utils.SwitchPanel;

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
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO: 2023/04/19 传输用户id给DAO层
                JScrollPane queryByIdDate = new QueryByIdDate();
                SwitchPanel.switchQueryPanel(QueryById.queryByIdSet,queryByIdDate);
                System.out.println(IdText.id);
            }
        });
    }
}
