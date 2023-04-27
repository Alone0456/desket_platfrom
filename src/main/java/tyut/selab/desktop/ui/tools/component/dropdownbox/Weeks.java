package tyut.selab.desktop.ui.tools.component.dropdownbox;

import tyut.selab.desktop.ui.tools.utils.WeekNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:Weeks
 * Package:tools.dropdownbox
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:24
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class Weeks {
    public static String week;

    public static JComboBox getWeek() {
        JComboBox<String> jComboBox = new JComboBox<>();
<<<<<<< HEAD
        jComboBox.setFont(new Font("华文行楷",Font.PLAIN,18));
=======
        jComboBox.setFont(new Font("微软黑体",Font.PLAIN,18));
>>>>>>> baizerong
        // 设置边框颜色
        jComboBox.setBorder(BorderFactory.createLineBorder(Color.blue));
        jComboBox.setForeground(Color.gray);
        jComboBox.addItem("请选择周数");
            for (int j = 0; j <= 21 - WeekNumber.getWeek(); j++) {
                int number = WeekNumber.getWeek() + j;
                String weekNumber = String.valueOf(number);
                jComboBox.addItem("第" + weekNumber + "周");
            }
        jComboBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jComboBox.setForeground(Color.black);
            }
        });
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                week = (String) jComboBox.getSelectedItem();

            }
        });
        return jComboBox;
    }

}
