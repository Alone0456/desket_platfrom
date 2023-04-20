package tyut.selab.desktop.ui.tools.tools.src.tools.set.panelset.panelutils;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:PanelWest
 * Package:ui.test
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/11 - 20:38
 * @Version:v1.0
 */
public class PanelWest extends JPanel {
    public PanelWest(JButton button) {
        this.setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JPanel p5=new JPanel(new BorderLayout());
        p5.setBackground(Color.white);
        p1.setPreferredSize(new Dimension(500,20));
        p3.setPreferredSize(new Dimension(14,90));
        p4.setPreferredSize(new Dimension(7,90));
        p2.setPreferredSize(new Dimension(500,10));

        this.add(p1,BorderLayout.NORTH);
        this.add(p2,BorderLayout.SOUTH);
        this.add(p3,BorderLayout.WEST);
        this.add(p4,BorderLayout.EAST);
        this.add(p5,BorderLayout.CENTER);
        p5.add(button,BorderLayout.CENTER);
    }
}
