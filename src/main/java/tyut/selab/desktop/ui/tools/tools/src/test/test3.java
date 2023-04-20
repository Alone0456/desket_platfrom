package tyut.selab.desktop.ui.tools.tools.src.test;

import tools.set.queryset.panelutils.PanelCenter;
import tools.set.queryset.panelutils.PanelEast;
import tools.set.queryset.panelutils.PanelWest;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:test3
 * Package:test
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 12:15
 * @Version:v1.0
 */
public class test3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(20, 20, 900, 500);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(1,4));
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();

        JButton b1=new JButton("查询所有");
        JButton b2=new JButton("查询个人");

        JPanel west=new PanelWest(b1);
        JPanel center=new PanelCenter(b2);


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
        mainPanel.add(p1, BorderLayout.NORTH);
        mainPanel.add(p2, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);

    }
}
