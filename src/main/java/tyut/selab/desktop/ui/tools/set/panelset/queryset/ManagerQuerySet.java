package tyut.selab.desktop.ui.tools.set.panelset.queryset;

import tyut.selab.desktop.ui.tools.component.buttons.query.QueryAll;
import tyut.selab.desktop.ui.tools.component.buttons.query.QueryById;
import tyut.selab.desktop.ui.tools.set.panelset.queryset.jscrollpane.QueryAllDate;
import tyut.selab.desktop.ui.tools.set.panelset.panelutils.PanelCenter;
import tyut.selab.desktop.ui.tools.set.panelset.panelutils.PanelWest;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:ManagerQuerySet
 * Package:tools.set.panelset.queryset
 * Description:
 * 管理员查询界面设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/17 - 9:28
 * @Version:v1.0
 */
public class ManagerQuerySet extends JPanel {
    public static JPanel p6 = new JPanel(new CardLayout()){
        private static final long serialVersionUID = -6352788025440244338L;

        private Image image = (Image) new ImageIcon(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/background.jpg")).getImage();

        // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    };

    public ManagerQuerySet() {
        JLabel welcome = new JLabel("欢迎来到管理员查询界面");
        welcome.setFont(new Font("楷体", Font.BOLD, 40));
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setForeground(Color.blue);

        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(1, 4));
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel(){
            private static final long serialVersionUID = -6352788025440244338L;
            // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
            private Image backgroundImage = (Image) new ImageIcon(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/Search.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        JScrollPane queryAllSet = new QueryAllDate();

        JButton queryAll = new QueryAll(p6, queryAllSet);
        JButton queryById = new QueryById(p6);

        JPanel west = new PanelWest(queryAll);
        JPanel center = new PanelCenter(queryById);


        p1.setPreferredSize(new Dimension(500, 80));
        p3.setPreferredSize(new Dimension(500, 20));
        p4.setPreferredSize(new Dimension(14, 500));
        p5.setPreferredSize(new Dimension(14, 500));
        p3.setBackground(new Color(173,216,230));
        p4.setBackground(new Color(173,216,230));
        p5.setBackground(new Color(173,216,230));
        p7.setBackground(new Color(173,216,230));
        p8.setBackground(new Color(173,216,230));

        p1.add(west);
        p1.add(center);
        p1.add(p7);
        p1.add(p8);
        p2.add(p3, BorderLayout.SOUTH);
        p2.add(p4, BorderLayout.WEST);
        p2.add(p5, BorderLayout.EAST);
        p6.add(welcome);
        p2.add(p6, BorderLayout.CENTER);
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
    }
}
