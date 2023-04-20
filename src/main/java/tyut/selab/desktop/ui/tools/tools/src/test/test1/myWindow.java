package tyut.selab.desktop.ui.tools.tools.src.test.test1;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName:myWindow
 * Package:test
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 22:22
 * @Version:v1.0
 */

public class myWindow extends JFrame {
    Focus focus;    //实现了焦点接口的类
    JTextField jTextField;
    JButton jButton;

    myWindow() {
        setTitle("焦点事件");
        setBounds(300, 300, 400, 400);
        setLayout(new FlowLayout());    //设置流体布局
        Container con = this.getContentPane();
        con.setBackground(new Color(0x366728));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
        validate(); //验证操作
    }

    public void init() {
        focus = new Focus();
        focus.setView(this);
        jTextField = new JTextField("0", 10);
        jTextField.addFocusListener(focus);
        add(jTextField);
        jButton = new JButton("ENTER");
        jButton.addFocusListener(focus);
        add(jButton);
    }
}

