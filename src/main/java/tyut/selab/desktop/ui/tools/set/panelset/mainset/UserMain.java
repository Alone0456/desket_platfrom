package tyut.selab.desktop.ui.tools.set.panelset.mainset;

import tyut.selab.desktop.ui.tools.set.panelset.panelutils.PanelCenter;
import tyut.selab.desktop.ui.tools.set.panelset.panelutils.PanelEast;
import tyut.selab.desktop.ui.tools.set.panelset.panelutils.PanelWest;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:UserMain
 * Package:tools.set.panelset.mainset
 * Description:
 * 用户主界面设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 0:26
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class UserMain extends JPanel {
    public static JPanel p8 = new JPanel(new CardLayout()) {
        private static final long serialVersionUID = -6352788025440244338L;

        private Image image = (Image) new ImageIcon(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/background.jpg")).getImage();

        // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    };

    public UserMain(JButton upload, JButton download, JButton query) {
        JLabel welcome = new JLabel("欢迎来到周报管理系统");
        welcome.setFont(new Font("楷体", Font.BOLD, 55));
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setForeground(Color.blue);

        //以下为面板设置
        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(1, 2));
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel(new GridLayout(1, 2));
        JPanel p4 = new JPanel(new BorderLayout());
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p9 = new JPanel(new GridLayout(1, 2));
        JPanel p10 = new JPanel(new GridLayout(1, 2));
        JPanel p11 = new JPanel(new BorderLayout());
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p14 = new JPanel(){
            private static final long serialVersionUID = -6352788025440244338L;

            private Image image = (Image) new ImageIcon(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/admin.png")).getImage();

            // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        JLabel label = new JLabel("用户周报管理系统");
        label.setFont(new Font("楷体", Font.BOLD, 22));
        label.setForeground(Color.DARK_GRAY);
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        PanelWest west = new PanelWest(upload);
        PanelEast east = new PanelEast(query);
        PanelCenter center = new PanelCenter(download);

        Color red = new Color(240, 128, 128);
        Color blue = new Color(173, 216, 230);

        p11.setBackground(red);
        p12.setBackground(red);
        p13.setBackground(red);
        p14.setBackground(red);
        p5.setBackground(blue);
        p6.setBackground(blue);
        p7.setBackground(blue);
        p1.setPreferredSize(new Dimension(500, 60));
        p3.setPreferredSize(new Dimension(500, 110));
        p5.setPreferredSize(new Dimension(500, 20));
        p6.setPreferredSize(new Dimension(14, 500));
        p7.setPreferredSize(new Dimension(14, 500));
        p8.setBackground(Color.white);

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);

        p1.add(p9);
        p10.add(p13);
        p10.add(p14);
        p1.add(p10);
        p11.add(label);
        p9.add(p11);
        p9.add(p12);
        p2.add(p3, BorderLayout.NORTH);
        p2.add(p4, BorderLayout.CENTER);
        p3.add(west);
        p3.add(center);
        p3.add(east);
        p4.add(p5, BorderLayout.SOUTH);
        p4.add(p6, BorderLayout.EAST);
        p4.add(p7, BorderLayout.WEST);
        p8.add(welcome);
        p4.add(p8, BorderLayout.CENTER);


        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
