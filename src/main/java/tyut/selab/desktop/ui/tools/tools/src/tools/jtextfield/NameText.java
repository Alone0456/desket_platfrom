package tyut.selab.desktop.ui.tools.tools.src.tools.jtextfield;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:NameText
 * Package:tools.jtextfield
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 16:42
 * @Version:v1.0
 */
public class NameText {
    public static String name;

    public static JTextField getNameText() {
        JTextField jTextField = new JTextField("请输入用户姓名");
        jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                name = jTextField.getText();
            }
        });
        return jTextField;
    }
}
