package tyut.selab.desktop.ui.tools.component.dropdownbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:Managers
 * Package:tools.dropdownbox
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/16 - 17:24
 * @Version:v1.0
 */
public class Managers {
    public static String managerName;

    public static JComboBox getManagers() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("华文行楷",Font.PLAIN,18));
        jComboBox.setBorder(BorderFactory.createLineBorder(Color.blue));
        jComboBox.setForeground(Color.gray);
        jComboBox.addItem("请选择组长");
        //TODO: 2023/04/19 从数据库中提取管理员数据
        jComboBox.addItem("奚城琛1");
        jComboBox.addItem("奚城琛2");
        jComboBox.addItem("奚城琛3");
        jComboBox.addItem("奚城琛4");
        jComboBox.addItem("奚城琛5");
        jComboBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jComboBox.setForeground(Color.black);
            }
        });
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerName = (String) jComboBox.getSelectedItem();
            }
        });
        return jComboBox;
    }
}
