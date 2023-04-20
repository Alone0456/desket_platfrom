package tyut.selab.desktop.ui.tools.tools.src.tools.jtextfield;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:IdText
 * Package:tools.jtextfield
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 16:42
 * @Version:v1.0
 */
public class IdText {
    public static String id;

    public static JTextField getIdText() {
        JTextField jTextField = new JTextField("请输入用户学号");
        jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                id = jTextField.getText();
            }
        });
        return jTextField;
    }
}
