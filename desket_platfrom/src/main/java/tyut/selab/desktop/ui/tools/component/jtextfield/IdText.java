package tyut.selab.desktop.ui.tools.component.jtextfield;

import tyut.selab.desktop.ui.tools.set.textfieldset.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:IdText
 * Package:tools.jtextfield
 * Description:
 * 管理员查询组员信息时输入学号
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 16:42
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class IdText {
    public static String id;

    public static JTextField getIdText() {
        JTextField jTextField = new MyTextField("请输入用户学号");
        jTextField.setFont(new Font("华文行楷",Font.PLAIN,15));
        jTextField.setBorder(BorderFactory.createLineBorder(Color.blue));

        jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                id = jTextField.getText();
            }
        });
        return jTextField;
    }
}
