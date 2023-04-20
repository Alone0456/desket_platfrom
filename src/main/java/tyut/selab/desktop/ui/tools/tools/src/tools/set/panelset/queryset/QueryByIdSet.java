package tyut.selab.desktop.ui.tools.tools.src.tools.set.panelset.queryset;

import tools.buttons.ChooseFile;
import tools.buttons.query.Ensure;
import tools.dropdownbox.Weeks;
import tools.jtextfield.IdText;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:QueryByIdSet
 * Package:tools.set.panelset.queryset
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 12:34
 * @Version:v1.0
 */
public class QueryByIdSet extends JPanel {
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

        p1.setBackground(Color.pink);
        p2.setBackground(Color.pink);
        p3.setBackground(Color.pink);

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
        p18.setBackground(Color.pink);
        p19.setBackground(Color.pink);


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
