package tyut.selab.desktop.ui.login;

import tyut.selab.desktop.moudle.login.controller.impl.LoginController;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.Scanner;

public class LoginDemo extends JFrame {
    LoginController loginController = new LoginController();

    public LoginDemo() throws Exception {
        super("登录界面");

        //      获取显示屏的大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        //      设置窗口的位置
        int width = 500;
        int height = 340;
        this.setBounds((sw - width) / 2, (sh - height) / 2, width, height);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\logo.png" ));// 图标
        ImageIcon background = new ImageIcon("src\\img\\back.jpg"); // 背景图片
        JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
        JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel.setOpaque(false); // 窗口透明
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景
//        this.setAlwaysOnTop(true);//窗口显示设置为最上层
//      盒子模块
        Box ubox = Box.createHorizontalBox();
        Box pbox = Box.createHorizontalBox();
        Box dbox = Box.createHorizontalBox();
        Box vbox = Box.createVerticalBox();

//      创建界面工具类
        JLabel uLabel = new JLabel("账   号 :  "); //文本设计
        uLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        uLabel.setForeground(new Color(0xFF4E4E)); // 设置前景色
        JTextField uField = new JTextField(); //输入框
        uField.setFont(new Font("Arial", Font.BOLD, 15));
//        uField.setUI(new BasicTextFieldUI()); //恢复基本视觉效果
        uField.setToolTipText("账号");// 悬停显示
        uField.setColumns(12);

        JLabel pLabel = new JLabel("密   码 :  ");    //文本设计
        pLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        pLabel.setForeground(new Color(0xFF4E4E)); // 设置前景色
        JPasswordField pFd = new JPasswordField();
        pFd.setFont(new Font("Arial", Font.BOLD, 15));
//        pFd.setUI(new BasicPasswordFieldUI()); //恢复基本视觉效果
        pFd.setToolTipText("密码");// 悬停显示
        pFd.setColumns(12);
        // 如果使用其他回显字符，可以设置大小，但是星星不可以。。。
        pFd.setEchoChar('●');// 星星符号

        JCheckBox AutomaticLogin = new JCheckBox("自动登录");
        AutomaticLogin.setFont(new Font("微软雅黑", Font.BOLD, 15));
        AutomaticLogin.setForeground(new Color(0xFF4E4E)); // 设置前景色
        JCheckBox RememberNumber = new JCheckBox("记住密码");
        RememberNumber.setFont(new Font("微软雅黑", Font.BOLD, 15));
        RememberNumber.setForeground(new Color(0xFF4E4E)); // 设置前景色
        AutomaticLogin.addItemListener(new ItemListener() {

            @Override

            public void itemStateChanged(ItemEvent e) {
//当选择发生了改变时,
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    RememberNumber.setSelected(true);
                }
            }
        });
        RememberNumber.addItemListener(new ItemListener() {

            @Override

            public void itemStateChanged(ItemEvent e) {
//当选择发生了改变时,
                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    AutomaticLogin.setSelected(false);
                }
            }
        });
        try {
            String str=loginController.read();
            String[] temp;
            String delimeter = "!";  // 指定分割字符
            temp = str.split(delimeter); // 分割字符
            int b=temp.length;
            if(b>1&&temp[1].equals("true")){
                AutomaticLogin.setSelected(true);
            }else if(b>1&&temp[1].equals("false")){
                AutomaticLogin.setSelected(false);
            }
            if(b>2&&temp[2].equals("true")){
                RememberNumber.setSelected(true);
            }else if(b>2&&temp[2].equals("false")){
                RememberNumber.setSelected(false);
            }

            if(b>3){
                uField.setText(temp[3]);
            }
            if(b>4&&RememberNumber.isSelected()){

                byte[] bt =temp[4] .getBytes();
                for (int i = 0; i < bt.length; i++) {
                        bt[i] = (byte) (bt[i] ^ (i * 18));
                    }
                String newPassword = new String(bt, 0, bt.length);
                pFd.setText(newPassword );// 串
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        init(uField, pFd);
        JButton button1 = new JButton("登录");    //登录按钮
        button1.setToolTipText("登录");// 悬停显示
        JButton button2 = new JButton("注册账号");    //重置按钮
        button2.setToolTipText("注册账号");// 悬停显示
//      字体设置
        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button1.setForeground(Color.white); // 设置前景色
        button1.setBackground(new Color(0xFFFF4E4E, true));
        button1.setDefaultCapable(true);
//        button1.setContentAreaFilled(false); // 设置按钮透明
        button1.setBounds((this.getWidth() - 120 - 180) / 2, 240, 120, 30); // 设置按钮位置，及按钮大小
//        button1.setUI(new BasicButtonUI()); //恢复基本视觉效果
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));  //鼠标手势的设置
        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button2.setForeground(Color.white); // 设置前景色
        button2.setBackground(new Color(0xFFFF4E4E, true));
        button2.setDefaultCapable(true);
//        button2.setContentAreaFilled(false); // 设置按钮透明
//        button2.setUI(new BasicButtonUI()); //恢复基本视觉效果
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button2.setBounds((this.getWidth() - 120 + 180) / 2, 240, 120, 30); // 设置按钮位置，及按钮大小

        /*
         分区模块布局
        */
//        小盒子，设计用户名模块
        ubox.add(uLabel);
        ubox.add(Box.createHorizontalStrut(10));//插入中间盒子宽度为10，作为相邻文本的空隙
        ubox.add(uField);
//        小盒子，设计密码模块
        pbox.add(pLabel);
        pbox.add(Box.createHorizontalStrut(10));
        pbox.add(pFd);
        //自动登录 记住密码
        dbox.add(AutomaticLogin);
        dbox.add(Box.createHorizontalStrut(40));
        dbox.add(RememberNumber);

//      大盒子
        vbox.add(Box.createVerticalStrut(50));//插入中间盒子高度为20，作为上下文本的空隙
        vbox.add(ubox);
        vbox.add(Box.createVerticalStrut(40));
        vbox.add(pbox);
        vbox.add(Box.createVerticalStrut(30));
        vbox.add(dbox);

//       设置记住密码
        //转换
        JPanel panel = new JPanel();
        panel.setUI(new BasicPanelUI());  //恢复基本视觉效果
        panel.setOpaque(false); // 面板透明
        panel.add(vbox, BorderLayout.CENTER);//将大盒子添加到jLabel盒子里
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//      点击按钮的监听事件
        button1.addActionListener(e -> {
            try {
                String str = init(uField, pFd);
                if(str.equals("登录成功")){
                    Thread.sleep(0);
                    loginController.save(AutomaticLogin.isSelected() ,RememberNumber.isSelected(),uField, pFd);
                    this.dispose();
                    str = uField.getText();
                    new MainInterface(str);

                } else {
                    pFd.setText("");
                    loginController.save(Boolean.parseBoolean("float"),Boolean.parseBoolean("float"),uField, pFd);
                    JOptionPane.showMessageDialog(null, str, "警告", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
            }
        });
        button2.addActionListener(e -> {
            try {
                this.dispose();
                Thread.sleep(0);
                new RegisterDemo();
            } catch (InterruptedException interruptedException) {
                JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
            }
        });

        this.add(button1);
        this.add(button2);
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
        if(RememberNumber.isSelected()&&AutomaticLogin.isSelected()){
            try {
                String str = init(uField, pFd);
                if(str.equals("登录成功")){
                    Thread.sleep(0);
                    loginController.save(AutomaticLogin.isSelected() ,RememberNumber.isSelected(),uField, pFd);
                    str =  uField.getText();
                    this.dispose();
                    new MainInterface(str);
                } else JOptionPane.showMessageDialog(null, str, "警告", JOptionPane.WARNING_MESSAGE);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public String init(JTextField uField, JPasswordField pFd) throws Exception {
        char[] p1 = pFd.getPassword();
        String str = loginController.login(uField.getText(), new String(p1));
        return str;
    }

}

