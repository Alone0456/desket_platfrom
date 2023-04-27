package tyut.selab.desktop.ui.tools.set.panelset.queryset;

import tyut.selab.desktop.ui.tools.component.buttons.query.Ensure;
import tyut.selab.desktop.ui.tools.component.jtextfield.IdText;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:QueryByIdSet
 * Package:tools.set.panelset.queryset
 * Description:
 * 查询个人界面设置
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 12:34
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class QueryByIdSet extends JPanel {
    private static final long serialVersionUID = -6352788025440244338L;
    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
    private Image backgroundImage = (Image) new ImageIcon(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/background.jpg")).getImage();

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    public QueryByIdSet() {
        this.setBackground(Color.pink);
        this.setLayout(new BorderLayout());

        JTextField jTextField =IdText.getIdText();

        JButton ensure = new Ensure();

        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(new GridLayout(3, 1));
        JPanel p3 = new JPanel(new GridLayout(1, 2));

        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel(new BorderLayout());
        JPanel p9 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel(new GridLayout(2, 1));
        JPanel p12 = new JPanel(new GridLayout(2, 1));
        JPanel p13 = new JPanel(new GridLayout(1, 3));
        JPanel p14 = new JPanel();
        JPanel p15 = new JPanel(new GridLayout(1, 3));
        JPanel p16 = new JPanel();
        JPanel p17 = new JPanel();
        JPanel p18 = new JPanel(new BorderLayout());
        JPanel p19 = new JPanel();


        p1.setPreferredSize(new Dimension(500, 70));
        p3.setPreferredSize(new Dimension(500, 110));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p7.setOpaque(false);
        p8.setOpaque(false);
        p9.setOpaque(false);
        p10.setOpaque(false);
        p11.setOpaque(false);
        p12.setOpaque(false);
        p13.setOpaque(false);
        p14.setOpaque(false);
        p15.setOpaque(false);
        p16.setOpaque(false);
        p17.setOpaque(false);
        p18.setOpaque(false);
        p19.setOpaque(false);


        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.add(p3, BorderLayout.SOUTH);
        p2.add(p10);
        p2.add(p11);
        p2.add(p12);
        p3.add(p7);
        p3.add(p8);
        p8.add(p9, BorderLayout.NORTH);
        p9.add(ensure);
        p11.add(p13);
        p11.add(p14);
        p12.add(p15);
        p12.add(p16);
        p13.add(p17);
        p13.add(p18);
        p13.add(p19);

        p18.add(jTextField);


    }
}
