package tyut.selab.desktop.ui.tools.tools.src.tools.set.panelset.mainset;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:UserMain
 * Package:tools.set.panelset.mainset
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 0:26
 * @Version:v1.0
 */
public class UserMain extends JPanel {
    public static JPanel p8 = new JPanel(new CardLayout());
    public UserMain(JButton upload, JButton download, JButton query) {
        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel(new GridLayout(1, 2));
        JPanel p4 = new JPanel(new BorderLayout());
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        tools.set.queryset.panelutils.PanelWest west = new tools.set.queryset.panelutils.PanelWest(upload);
        tools.set.queryset.panelutils.PanelEast east = new tools.set.queryset.panelutils.PanelEast(query);
        tools.set.queryset.panelutils.PanelCenter center = new tools.set.queryset.panelutils.PanelCenter(download);
        p1.setBackground(Color.white);
        p1.setPreferredSize(new Dimension(500, 50));
        p3.setPreferredSize(new Dimension(500, 110));
        p5.setPreferredSize(new Dimension(500, 20));
        p6.setPreferredSize(new Dimension(14, 500));
        p7.setPreferredSize(new Dimension(14, 500));
        p8.setBackground(Color.white);

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);

        p2.add(p3, BorderLayout.NORTH);
        p2.add(p4, BorderLayout.CENTER);
        p3.add(west);
        p3.add(center);
        p3.add(east);
        p4.add(p5, BorderLayout.SOUTH);
        p4.add(p6, BorderLayout.EAST);
        p4.add(p7, BorderLayout.WEST);
        p4.add(p8, BorderLayout.CENTER);


        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
