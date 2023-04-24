package tyut.selab.desktop.ui.tools.component.jtextfield;

import tyut.selab.desktop.ui.tools.set.textfieldset.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName:FileNameText
 * Package:tools.jtextfield
 * Description:
 * 下载界面获取学号
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 16:42
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class FileNameText {
    public static String FileName;

    public static JTextField getFileNameText() {
        JTextField jTextField = new MyTextField("请输入文件名");
        jTextField.setFont(new Font("华文行楷",Font.PLAIN,18));
        jTextField.setBorder(BorderFactory.createLineBorder(Color.blue));
        jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                FileName = jTextField.getText();
            }

        });
        return jTextField;
    }
}
