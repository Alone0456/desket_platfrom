package tyut.selab.desktop.ui.tools.set.panelset.panelutils;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:PanelCenter
 * Package:ui.test
 * Description:
 * 面板设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/11 - 20:02
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class PanelCenter extends JPanel {
    public PanelCenter(JButton button) {
        this.setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JPanel p5=new JPanel(new BorderLayout());
        Color blue=new Color(173,216,230);
        p5.setBackground(Color.white);
        p1.setBackground(blue);
        p2.setBackground(blue);
        p3.setBackground(blue);
        p4.setBackground(blue);
        p1.setPreferredSize(new Dimension(500,15));
        p3.setPreferredSize(new Dimension(7,90));
        p4.setPreferredSize(new Dimension(7,90));
        p2.setPreferredSize(new Dimension(500,8));

        this.add(p1,BorderLayout.NORTH);
        this.add(p2,BorderLayout.SOUTH);
        this.add(p3,BorderLayout.WEST);
        this.add(p4,BorderLayout.EAST);
        this.add(p5,BorderLayout.CENTER);
        p5.add(button,BorderLayout.CENTER);

    }


}