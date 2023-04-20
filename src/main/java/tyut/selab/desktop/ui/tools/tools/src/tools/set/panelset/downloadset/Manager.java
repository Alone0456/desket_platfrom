package tyut.selab.desktop.ui.tools.tools.src.tools.set.panelset.downloadset;

import tools.buttons.ChooseFile;
import tools.dropdownbox.Weeks;
import tools.jtextfield.NameText;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:Managers
 * Package:tools.set.panelset.download
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:12
 * @Version:v1.0
 */
public class Manager extends JPanel {
    public Manager() {
        JLabel label1 = new JLabel("管理员下载页面");
        label1.setFont(new Font("华文行楷", Font.BOLD, 18));
        // 自动换行
        String str = "<html>" + "</html>";
        JLabel label2 = new JLabel(str);
        label2.setFont(new Font("华文行楷", Font.BOLD, 14));

        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        JComboBox weeks =Weeks.getWeek();

        JTextField jTextField=NameText.getNameText();


        JButton chooseFile = new ChooseFile("选择存放位置", "存放周报");

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

        p1.setBackground(Color.pink);
        p2.setBackground(Color.pink);
        p3.setBackground(Color.pink);
        p4.setBackground(Color.pink);
        p5.setBackground(Color.pink);
        p6.setBackground(Color.pink);
        p7.setBackground(Color.pink);
        p8.setBackground(Color.pink);
        p9.setBackground(Color.pink);
        p10.setBackground(Color.pink);
        p11.setBackground(Color.pink);
        p12.setBackground(Color.pink);
        p13.setBackground(Color.pink);
        p14.setBackground(Color.pink);
        p15.setBackground(Color.pink);
        p16.setBackground(Color.pink);
        p17.setBackground(Color.pink);
        p19.setBackground(Color.pink);
        p20.setBackground(Color.pink);
        p22.setBackground(Color.pink);

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
        p6.add(label2);
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
