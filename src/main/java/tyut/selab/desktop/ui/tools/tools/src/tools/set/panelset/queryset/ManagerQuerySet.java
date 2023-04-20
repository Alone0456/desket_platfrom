package tyut.selab.desktop.ui.tools.tools.src.tools.set.panelset.queryset;

import tools.buttons.query.QueryAll;
import tools.buttons.query.QueryById;
import tools.set.panelset.queryset.jscrollpane.QueryAllDate;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:ManagerQuerySet
 * Package:tools.set.panelset.queryset
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/17 - 9:28
 * @Version:v1.0
 */
public class ManagerQuerySet extends JPanel {
    public static JPanel p6 = new JPanel(new CardLayout());

    public ManagerQuerySet() {
        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(1, 4));
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();

        JScrollPane queryAllSet = new QueryAllDate();

        JButton queryAll = new QueryAll(p6, queryAllSet);
        JButton queryById = new QueryById(p6);

        JPanel west = new tools.set.queryset.panelutils.PanelWest(queryAll);
        JPanel center = new tools.set.queryset.panelutils.PanelCenter(queryById);


        p1.setPreferredSize(new Dimension(500, 80));
        p3.setPreferredSize(new Dimension(500, 20));
        p4.setPreferredSize(new Dimension(14, 500));
        p5.setPreferredSize(new Dimension(14, 500));
        p6.setBackground(Color.pink);

        p1.add(west);
        p1.add(center);
        p1.add(p7);
        p1.add(p8);
        p2.add(p3, BorderLayout.SOUTH);
        p2.add(p4, BorderLayout.WEST);
        p2.add(p5, BorderLayout.EAST);
        p2.add(p6, BorderLayout.CENTER);
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
    }
}
