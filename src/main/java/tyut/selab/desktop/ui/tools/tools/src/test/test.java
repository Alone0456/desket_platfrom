package tyut.selab.desktop.ui.tools.tools.src.test;

import tools.set.queryset.panelutils.PanelCenter;
import tools.set.queryset.panelutils.PanelEast;
import tools.set.queryset.panelutils.PanelWest;
import tools.utils.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * ClassName:test
 * Package:test
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/04 - 16:33
 * @Version:v1.0
 */
public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(20, 20, 1010, 700);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel p1=new JPanel();
        JPanel p2=new JPanel(new BorderLayout());
        JPanel p3 = new JPanel(new GridLayout(1, 2));
        JPanel p4 = new JPanel(new BorderLayout());
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel(new CardLayout());
        JPanel p9 = new JPanel();
        JButton button = new JButton();
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                SwitchPanel.switchPanel(p8,p9);
            }
        });
        PanelWest west = new PanelWest(button);
        PanelEast east = new PanelEast(new JButton());
        PanelCenter center=new PanelCenter(new JButton());

        p1.setBackground(Color.white);
        p1.setPreferredSize(new Dimension(500, 50));
        p3.setPreferredSize(new Dimension(500, 110));
        p5.setPreferredSize(new Dimension(500, 20));
        p6.setPreferredSize(new Dimension(14, 500));
        p7.setPreferredSize(new Dimension(14, 500));
        p8.setBackground(Color.white);
        p9.setBackground(Color.black);

        mainPanel.add(p1, BorderLayout.NORTH);
        mainPanel.add(p2, BorderLayout.CENTER);

        p2.add(p3, BorderLayout.NORTH);
        p2.add(p4, BorderLayout.CENTER);
        p3.add(west);
        p3.add(center);
        p3.add(east);
        p4.add(p5, BorderLayout.SOUTH);
        p4.add(p6, BorderLayout.EAST);
        p4.add(p7, BorderLayout.WEST);
        p4.add(p8, BorderLayout.CENTER);



        mainPanel.add(p1,BorderLayout.NORTH);
        mainPanel.add(p2,BorderLayout.CENTER);
        frame.add(mainPanel);
    }
}
