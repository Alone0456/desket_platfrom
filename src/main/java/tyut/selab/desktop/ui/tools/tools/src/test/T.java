package tyut.selab.desktop.ui.tools.tools.src.test;//package test;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.plaf.basic.BasicPanelUI;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//@SuppressWarnings("all")
//public class MainInterface extends JFrame  {
//    JPanel contentPane;
//    CardLayout cardLayout = new CardLayout();
//
//    public MainInterface() {
//        //      获取显示屏的大小
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int sw = screenSize.width;
//        int sh = screenSize.height;
//        //      设置窗口的位置
//        int width = 1300;
//        int height =800;
//        this.setBounds((sw - width) / 2, (sh - height) / 2, width, height);
//        this.setTitle("主界面");
//        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\logo.jpg"));// 图标
//        ImageIcon background = new ImageIcon("src\\back2.jpg"); // 背景图片
//        JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
//        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
//        JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
//        imagePanel.setOpaque(false); // 窗口透明
//        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景
//
//        JButton button1 = new JButton("系统管理");    //登录按钮
//        button1.setToolTipText("系统管理");// 悬停显示
//        JButton button2 = new JButton("周报管理");    //重置按钮
//        button2.setToolTipText("周报管理");// 悬停显示
//        JButton button3 = new JButton("个人信息");    //重置按钮
//        button3.setToolTipText("个人信息");// 悬停显示
//        JButton button4 = new JButton("管理员界面");    //重置按钮
//        button4.setToolTipText("管理员界面");// 悬停显示
//        JButton button5 = new JButton("闹钟设置");    //重置按钮
//        button5.setToolTipText("闹钟设置");// 悬停显示
//        JButton button6 = new JButton("图书管理");    //重置按钮
//        button6.setToolTipText("图书管理");// 悬停显示
//        JButton button7 = new JButton("任务清单");    //重置按钮
//        button7.setToolTipText("任务清单");// 悬停显示
//
////      字体设置
//        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
//        button1.setForeground(Color.white); // 设置前景色
//        button1.setBackground(new Color(0xFFFF4E4E, true));
//        button1.setDefaultCapable(true);
//
//        button1.setBounds(50, (this.getHeight())/2-350, 150, 40); // 设置按钮位置，及按钮大小
////        button1.setUI(new BasicButtonUI()); //恢复基本视觉效果
//        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));  //鼠标手势的设置
//        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
//        button2.setForeground(Color.white); // 设置前景色
//        button2.setBackground(new Color(0xFFFF4E4E, true));
//        button2.setDefaultCapable(true);
//
//        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
//        button2.setBounds(50, (this.getHeight())/2-250, 150, 40); // 设置按钮位置，及按钮大小
//        button3.setFont(new Font("微软雅黑", Font.BOLD, 18));
//        button3.setForeground(Color.white); // 设置前景色
//        button3.setBackground(new Color(0xFFFF4E4E, true));
//        button3.setDefaultCapable(true);
//
//        button3.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
//        button3.setBounds(50, (this.getHeight())/2-150, 150, 40); // 设置按钮位置，及按钮大小
//        button4.setFont(new Font("微软雅黑", Font.BOLD, 18));
//        button4.setForeground(Color.white); // 设置前景色
//        button4.setBackground(new Color(0xFFFF4E4E, true));
//        button4.setDefaultCapable(true);
//
//        button4.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
//        button4.setBounds(50, (this.getHeight())/2-50, 150, 40); // 设置按钮位置，及按钮大小
//        button5.setFont(new Font("微软雅黑", Font.BOLD, 18));
//        button5.setForeground(Color.white); // 设置前景色
//        button5.setBackground(new Color(0xFFFF4E4E, true));
//        button5.setDefaultCapable(true);
//
//        button5.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
//        button5.setBounds(50, (this.getHeight())/2+50, 150, 40); // 设置按钮位置，及按钮大小
//        button6.setFont(new Font("微软雅黑", Font.BOLD, 18));
//        button6.setForeground(Color.white); // 设置前景色
//        button6.setBackground(new Color(0xFFFF4E4E, true));
//        button6.setDefaultCapable(true);
//
//        button6.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
//        button6.setBounds(50, (this.getHeight())/2+150, 150, 40); // 设置按钮位置，及按钮大小
//        button7.setFont(new Font("微软雅黑", Font.BOLD, 18));
//        button7.setForeground(Color.white); // 设置前景色
//        button7.setBackground(new Color(0xFFFF4E4E, true));
//        button7.setDefaultCapable(true);
//        button7.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
//        button7.setBounds(50, (this.getHeight())/2+250, 150, 40); // 设置按钮位置，及按钮大小
//
//
////        JMenuBar maininterface = new JMenuBar();
////        maininterface.setBounds(0, 0, 250, 800);
////        this.getContentPane().add(maininterface);
//
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(cardLayout);
//        panel.setUI(new BasicPanelUI());  //恢复基本视觉效果
////        panel.setOpaque(false); // 面板透明
//        panel.setBounds(250, 30, 1010, 700);
//        Color bgColor = new Color(22, 210, 243);
//        panel.setBackground(bgColor);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.add(panel);
//
//
//        contentPane.add(button1);
//        contentPane.add(button2);
//        contentPane.add(button3);
//        contentPane.add(button4);
//        contentPane.add(button5);
//        contentPane.add(button6);
//        contentPane.add(button7);
//        label.add(button1);
//        label.add(button2);
//        label.add(button3);
//        label.add(button4);
//        label.add(button5);
//        label.add(button6);
//        label.add(button7);
//        this.add(label);
//        SystemAdministration p1=new SystemAdministration();
//        panel.add(p1,"系统管理");
//        WeeklyReportManagement p2=new WeeklyReportManagement();
//        panel.add(p2,"周报管理");
//
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "系统管理");
//
//            }
//        });
//
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                cardLayout.show(panel, "周报管理");
//            }
//        });
//
//        button3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "个人信息");
//
//            }
//        });
//
//        button4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "管理员信息");
//            }
//        });
//
//        button5.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "闹钟设置");
//
//            }
//        });
//
//        button6.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "图书管理");
//
//            }
//        });
//        button7.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "任务清单");
//
//            }
//        });
//
//
//        this.setVisible(true);
//        this.setResizable(false);
//
//    }
//    public static void main(String[] args) {
//        //界面渲染效果
//        try {
//            UIManager.setLookAndFeel( "javax.swing.plaf.nimbus.NimbusLookAndFeel");
//            new MainInterface();
//        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
//            JOptionPane.showMessageDialog(null, "系统异常", "你个老六", JOptionPane.WARNING_MESSAGE);
//        }
//    }
//}
