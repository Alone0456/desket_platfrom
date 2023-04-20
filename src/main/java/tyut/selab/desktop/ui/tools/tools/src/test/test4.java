package tyut.selab.desktop.ui.tools.tools.src.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClassName:test4
 * Package:test
 * Description:
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/18 - 19:31
 * @Version:v1.0
 */

public class test4 implements ActionListener {
    JComboBox<String> jBox;
    public test4() {
        jBox=new JComboBox<String>();
        jBox.addItem("超级用户");
        jBox.addItem("管理员");
        jBox.addItem("普通用户");
        jBox.addActionListener(this);
        JFrame jf=new JFrame("测试");
        JPanel jp=new JPanel();
        jp.add(jBox);
        jf.add(jp);
        jf.setBounds(200, 100, 300, 400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[]args){
        new test4();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int i=jBox.getSelectedIndex()+1;
        String s=(String)jBox.getSelectedItem();
        System.out.println("你选中的是第"+i+"项"+",内容是:"+s);
        // 把i插入你数据库中对应的属性字段

    }
}
