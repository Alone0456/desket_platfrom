package tyut.selab.desktop.ui.login;


import tyut.selab.desktop.moudle.login.controller.impl.LoginController;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Home extends JPanel {
    LoginController loginController = new LoginController();



    /**
     * Create the panel.
     */
    Home() {
        setLayout(null);

        ImageIcon logo = new ImageIcon("src\\img\\实验室logo.png"); // 背景图片
        JLabel label = new JLabel(logo); // 把背景图片显示在一个标签里面
        label.setBounds(50, 0, 500,150); // 把标签的大小位置设置为图片刚好填充整个面板
        this.add(label,Integer.valueOf(Integer.MIN_VALUE));

        JLabel Left = new JLabel(""); //文本设计
        Left.setFont(new Font("微软雅黑", Font.BOLD, 1));
        Left.setOpaque(true);
        Left.setBackground(new Color(0xE575B5));
        Left.setBounds(0, 0,3,700);
        this.add(Left);
//        this.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        JLabel a = new JLabel("<html><body><p align=\"right\" style=\"font-family: 华文楷体;\">每天都要有好心情吖~</p></body></html>"); //文本设计
        a.setFont(new Font("微软雅黑", Font.BOLD, 20));
        a.setForeground(new Color(0xFF07EAEA, true)); // 设置前景色
        a.setBounds(70, 160,500,50);
        this.add(a);

        JLabel b = new JLabel("<html><body><p align=\"right\" style=\"font-family: 仿宋_GB2312;\"><b>欢&nbsp迎&nbsp来&nbsp到</b></p></body></html>"); //文本设计
        b.setFont(new Font("微软雅黑", Font.BOLD, 70));
        b.setForeground(new Color(0xFFFF4E4E, true)); // 设置前景色
        b.setBounds(70, 190,500,100);
        this.add(b);


        JLabel c = new JLabel("<html><body><p align=\"right\" style=\"font-family: 仿宋_GB2312;\"><b>图书信息&nbsp管理系统</b></p></body></html>"); //文本设计
        c.setFont(new Font("微软雅黑", Font.BOLD, 30));
        c.setForeground(new Color(0xFFFF4E4E, true)); // 设置前景色
        c.setBounds(70, 260,500,100);
        this.add(c);

        JLabel d = new JLabel("<html><body><p align=\"right\" style=\"font-family: 仿宋_GB2312;\">摸|鱼|摸|鱼<br/>划|水|划|水</p></body></html>"); //文本设计
        d.setFont(new Font("微软雅黑", Font.BOLD, 15));
        d.setForeground(new Color(0xFF198598, true)); // 设置前景色
        d.setBounds(900, 600,100,50);
        this.add(d);

        JLabel e = new JLabel("<html><body><p align=\"right\" style=\"font-family: 华文仿宋;\">RuanJianXueYuan ChuangXin Laboratory</p></body></html>"); //文本设计
        e.setFont(new Font("微软雅黑", Font.BOLD, 15));
        e.setForeground(new Color(0xCD210BE5, true)); // 设置前景色
        e.setBounds(860, 0,140,70);
        this.add(e);

        JButton button1 = new JButton("返回登录");    //登录按钮
        button1.setToolTipText("返回登录");// 悬停显示
        JButton button2 = new JButton("退 出");    //重置按钮
        button2.setToolTipText("退 出");// 悬停显示
//      字体设置
        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button1.setForeground(Color.white); // 设置前景色
        button1.setBackground(new Color(0xFFBE4EFF, true));
        button1.setBorder(BorderFactory.createLineBorder(new Color(0xFFBE4EFF, true),1));
        button1.setDefaultCapable(true);
//        button1.setContentAreaFilled(false); // 设置按钮透明
        button1.setBounds(80, 540, 120, 50); // 设置按钮位置，及按钮大小
//        button1.setUI(new BasicButtonUI()); //恢复基本视觉效果
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));  //鼠标手势的设置
        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button2.setForeground(new Color(0xFFFFFFFF, true)); // 设置前景色
        button2.setDefaultCapable(true);
        button2.setBorder(BorderFactory.createLineBorder(new Color(0xFFBE4EFF, true),1));
        button2.setContentAreaFilled(false); // 设置按钮透明
//        button2.setUI(new BasicButtonUI()); //恢复基本视觉效果
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button2.setBounds(220, 540, 120, 50); // 设置按钮位置，及按钮大小

//        button2.addActionListener(e -> {
//
//
//            loginController.changeLoginState();
//            System.exit(0);
//        });
        button1.addActionListener(( ActionEvent f) -> {
            try {
                loginController.changeLoginState();
                Window window = SwingUtilities.getWindowAncestor(this);
                window.dispose();
                replaceFileStr();
                new LoginDemo();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            // some action
        });
//        button1.addActionListener(new ActionListener() {
//            @Override
//            Window window = SwingUtilities.getWindowAncestor(this);
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    replaceFileStr();
//                    new LoginDemo();
//                    loginController.changeLoginState();
////                    Window window = SwingUtilities.getWindowAncestor(this);
//                    window.dispose();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//
//            }
//        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginController.changeLoginState();
            System.exit(0);
            }
        });

        this.add(button1);
        this.add(button2);
     this.setBackground(null);
     this.setOpaque(false);

    }
    public static void replaceFileStr() throws IOException {

            FileReader fis = new FileReader("src\\main\\java\\tyut\\selab\\desktop\\ui\\login\\Staff.manifest"); // 创建文件输入流
//			BufferedReader br = new BufferedReader(fis);
            char[] data = new char[1024]; // 创建缓冲字符数组
            int rn = 0;
            StringBuilder sb = new StringBuilder(); // 创建字符串构建器
            // fis.read(data)：将字符读入数组。在某个输入可用、发生 I/O
            // 错误或者已到达流的末尾前，此方法一直阻塞。读取的字符数，如果已到达流的末尾，则返回 -1
            while ((rn = fis.read(data)) > 0) { // 读取文件内容到字符串构建器
                String str = String.valueOf(data, 0, rn);// 把数组转换成字符串
//				System.out.println(str);
                sb.append(str);
            }
            fis.close();// 关闭输入流
            // 从构建器中生成字符串，并替换搜索文本
            String str = sb.toString().replace("true","false");
            FileWriter fout = new FileWriter("src\\main\\java\\tyut\\selab\\desktop\\ui\\login\\Staff.manifest");// 创建文件输出流
            fout.write(str.toCharArray());// 把替换完成的字符串写入文件内
            fout.close();// 关闭输出流



}}