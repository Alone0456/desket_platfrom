package tyut.selab.desktop.ui.tools.set.panelset.panelutils;

import tyut.selab.desktop.ui.tools.component.buttons.ChooseFile;
import tyut.selab.desktop.ui.tools.component.dropdownbox.Weeks;
import tyut.selab.desktop.ui.tools.component.jtextfield.FileNameText;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:DownPanelSet
 * Package:tyut.selab.desktop.ui.tools.set.panelset.panelutils
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/24 - 12:59
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class DownPanelSet extends JPanel {
    private static final long serialVersionUID = -6352788025440244338L;
    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
    private Image backgroundImage = (Image) new ImageIcon(getClass().getResource("/tyut/selab/desktop/ui/tools/imgs/background.jpg")).getImage();

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public DownPanelSet(String name1, String name2) {
        JLabel label1 = new JLabel(name1);
        label1.setForeground(Color.yellow);
        label1.setFont(new Font("微软黑体", Font.ITALIC, 30));

        label1.setHorizontalAlignment(SwingConstants.CENTER);

        JComboBox weeks = Weeks.getWeek();

        JTextField jTextField = FileNameText.getFileNameText();


        JButton chooseFile = new ChooseFile("选择存放位置", name2);

        this.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(1, 3));
        JPanel p2 = new JPanel(new GridLayout(3, 1));
        JPanel p3 = new JPanel(new GridLayout(1, 2));
        JPanel p4 = new JPanel(new BorderLayout());
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel(new BorderLayout());
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
        JPanel p20 = new JPanel();
        JPanel p21 = new JPanel(new BorderLayout());
        JPanel p22 = new JPanel();

        p1.setPreferredSize(new Dimension(500, 70));
        p3.setPreferredSize(new Dimension(500, 110));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
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
        p20.setOpaque(false);
        p21.setOpaque(false);
        p22.setOpaque(false);

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.add(p3, BorderLayout.SOUTH);
        p1.add(p4);
        p1.add(p5);
        p1.add(p6);
        p2.add(p10);
        p2.add(p11);
        p2.add(p12);
        p3.add(p7);
        p3.add(p8);
        p4.add(label1);
        p8.add(p9, BorderLayout.NORTH);
        p9.add(chooseFile);
        p11.add(p13);
        p11.add(p14);
        p12.add(p15);
        p12.add(p16);
        p13.add(p17);
        p13.add(p18);
        p13.add(p19);
        p15.add(p20);
        p15.add(p21);
        p15.add(p22);
        p18.add(weeks);
        p21.add(jTextField);
    }
}

