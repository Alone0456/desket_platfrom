package tyut.selab.desktop.ui.login;

import org.w3c.dom.ls.LSOutput;
import tyut.selab.desktop.moudle.login.controller.impl.LoginController;
import tyut.selab.desktop.moudle.login.service.impl.LoginService;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;
import tyut.selab.desktop.ui.student.manager.AdministratorInformation;
import tyut.selab.desktop.ui.student.user.UserInformation;
import tyut.selab.desktop.ui.tools.component.panels.mainpanels.ManagerMainPanel;
import tyut.selab.desktop.ui.tools.component.panels.mainpanels.UserMainPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainInterface extends JFrame  {

    LoginController loginController = new LoginController();
    JPanel contentPane;
    CardLayout cardLayout = new CardLayout();
    IUserDao userDao = new UserDao();


    public MainInterface(String str) {
        User user=userDao.queryUserByAccountNumber(str);
        String name=user.getName();
        String acccount=user.getAccountNumber();
        Integer studentNumber=user.getStudentNumber() ;
         int gender= user.getGender();
         String phone = user.getPhone();
         String post= user.getPost();
         String duty = user.getRole().getDuty();
        String gen;
        if(gender ==1){
             gen ="男";
        }else{
             gen ="女";
        }
//        <html><body><p align=\"left\">数据版本<br/>v1.0.0</p></body></html>
        String abc ="<html><body><p align=\"left\" style=\"font-family: 华文新魏;\">姓名:"+name+"<br/>账号:"+acccount+"<br/>学号："+studentNumber+"<br/>性别："+gen+"<br/>电话:"+phone+"<br/>邮箱:"+post+"<br/>职责:"+duty+"</p></body></html>";

        //      获取显示屏的大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        //      设置窗口的位置
        int width = 1300;
        int height =800;
        this.setBounds((sw - width) / 2, (sh - height) / 2, width, height);
        this.setTitle("主界面");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\logo.png"));// 图标
        ImageIcon background = new ImageIcon("src\\img\\back2.jpg"); // 背景图片
        JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
        JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel.setOpaque(false); // 窗口透明
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景


        ImageIcon image1=new ImageIcon("src\\img\\xtgl.png");//获取图片
        ImageIcon image2=change(image1,0.15);//这里是缩小两倍，可以按自己的需求放缩
        JButton button1 = new JButton("系统管理", image2);    //登录按钮
        button1.setToolTipText("系统管理");// 悬停显示
        ImageIcon image3=new ImageIcon("src\\img\\zbgl.png");//获取图片
        ImageIcon image4=change(image3,0.15);//这里是缩小两倍，可以按自己的需求放缩
        JButton button2 = new JButton("周报管理",image4);    //重置按钮
        button2.setToolTipText("周报管理");// 悬停显示
        ImageIcon image5=new ImageIcon("src\\img\\grxx.png");//获取图片
        ImageIcon image6=change(image5,0.15);//这里是缩小两倍，可以按自己的需求放缩
        JButton button3 = new JButton("个人信息",image6);    //重置按钮
        button3.setToolTipText("个人信息");// 悬停显示
        ImageIcon image7=new ImageIcon("src\\img\\gly.png");//获取图片
        ImageIcon image8=change(image7,0.15);//这里是缩小两倍，可以按自己的需求放缩
        JButton button4 = new JButton("管理员界面",image8);    //重置按钮
        button4.setToolTipText("管理员界面");// 悬停显示
        ImageIcon image9=new ImageIcon("src\\img\\nzsz.png");//获取图片
        ImageIcon image10=change(image9,0.15);//这里是缩小两倍，可以按自己的需求放缩
        JButton button5 = new JButton("闹钟设置",image10);    //重置按钮
        button5.setToolTipText("闹钟设置");// 悬停显示
        ImageIcon image11=new ImageIcon("src\\img\\tsgl.png");//获取图片
        ImageIcon image12=change(image11,0.15);//这里是缩小两倍，可以按自己的需求放缩
        JButton button6 = new JButton("图书管理",image12);    //重置按钮
        button6.setToolTipText("图书管理");// 悬停显示
        ImageIcon image13=new ImageIcon("src\\img\\rwqd.png");//获取图片
        ImageIcon image14=change(image13,0.15);//这里是缩小两倍，可以按自己的需求放缩
        JButton button7 = new JButton("任务清单",image14);    //重置按钮
        button7.setToolTipText("任务清单");// 悬停显示
//        ImageIcon image15=new ImageIcon("src\\img\\实验室logo.png");//获取图片
//        ImageIcon image16=change(image15,0.51);//这里是缩小两倍，可以按自己的需求放缩
        JButton button = new JButton("图书信息管理系统");    //重置按钮
        button.setToolTipText("图书信息管理系统");// 悬停显

        JButton button123 = new JButton(abc);    //重置按钮
        button123.setToolTipText(abc);// 悬停显

//      字体设置
        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button1.setForeground(Color.white); // 设置前景色
        button1.setBackground(new Color(0xFFFF4E4E, true));
        button1.setDefaultCapable(true);

        button1.setBounds(50, (this.getHeight())/2-300, 150, 40); // 设置按钮位置，及按钮大小
//        button1.setUI(new BasicButtonUI()); //恢复基本视觉效果
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));  //鼠标手势的设置
        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button2.setForeground(Color.white); // 设置前景色
        button2.setBackground(new Color(0xFFFF4E4E, true));
        button2.setDefaultCapable(true);

        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button2.setBounds(50, (this.getHeight())/2-250, 150, 40); // 设置按钮位置，及按钮大小
        button3.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button3.setForeground(Color.white); // 设置前景色
        button3.setBackground(new Color(0xFFFF4E4E, true));
        button3.setDefaultCapable(true);

        button3.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button3.setBounds(50, (this.getHeight())/2-200, 150, 40); // 设置按钮位置，及按钮大小
        button4.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button4.setForeground(Color.white); // 设置前景色
        button4.setBackground(new Color(0xFFFF4E4E, true));
        button4.setDefaultCapable(true);

        button4.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button4.setBounds(50, (this.getHeight())/2-150, 150, 40); // 设置按钮位置，及按钮大小
        button5.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button5.setForeground(Color.white); // 设置前景色
        button5.setBackground(new Color(0xFFFF4E4E, true));
        button5.setDefaultCapable(true);

        button5.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button5.setBounds(50, (this.getHeight())/2-100, 150, 40); // 设置按钮位置，及按钮大小
        button6.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button6.setForeground(Color.white); // 设置前景色
        button6.setBackground(new Color(0xFFFF4E4E, true));
        button6.setDefaultCapable(true);

        button6.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button6.setBounds(50, (this.getHeight())/2-50, 150, 40); // 设置按钮位置，及按钮大小
        button7.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button7.setForeground(Color.white); // 设置前景色
        button7.setBackground(new Color(0xFFFF4E4E, true));
        button7.setDefaultCapable(true);
        button7.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button7.setBounds(50, (this.getHeight())/2, 150, 40); // 设置按钮位置，及按钮大小
        button.setFont(new Font("微软雅黑", Font.BOLD, 30));
        button.setForeground(new Color(0xFFFFD47B, true)); // 设置前景色
        button.setDefaultCapable(true);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button.setBounds(-15, (this.getHeight())/2-380, 280, 70); // 设置按钮位置，及按钮大小

        button123.setFont(new Font("微软雅黑", Font.BOLD, 19));
        button123.setForeground(new Color(0xFFFF0000, true)); // 设置前景色
        button123.setDefaultCapable(true);
        button123.setOpaque(false);
        button123.setContentAreaFilled(false);
//        button123.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button123.setBounds(0, (this.getHeight())/2+50, 250, 300); // 设置按钮位置，及按钮大小




//        JMenuBar maininterface = new JMenuBar();
//        maininterface.setBounds(0, 0, 250, 800);
//        this.getContentPane().add(maininterface);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(cardLayout);
        panel.setUI(new BasicPanelUI());  //恢复基本视觉效果
//        panel.setOpaque(false); // 面板透明
        panel.setBounds(250, 30, 1010, 700);
        panel.setOpaque(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);

        contentPane.add(button);
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(button4);
        contentPane.add(button5);
        contentPane.add(button6);
        contentPane.add(button7);
        label.add(button);
        label.add(button1);
        label.add(button2);
        label.add(button3);
        label.add(button4);
        label.add(button5);
        label.add(button6);
        label.add(button7);
        label.add(button123);
        this.add(label);
        Home p=new Home();
        panel.add(p,"Home");
        SystemAdministration systemButton=new SystemAdministration();
        panel.add(systemButton,"系统管理");

        if(LoginService.getUser().getRole().getDuty().equals("用户")){
            JPanel jPanel=UserMainPanel.getUserPanel();
            panel.add(jPanel,"周报管理");
        }else{
            JPanel managerPanel = ManagerMainPanel.getManagerPanel();
            panel.add(managerPanel,"周报管理");
        }
        if(LoginService.getUser().getRole().getDuty().equals("用户")){
            JPanel userPanel= UserInformation.getUserPanel();
            panel.add(userPanel,"个人信息");
        }else{
            JPanel adminPanel = AdministratorInformation.getAdminPanel();
            panel.add(adminPanel,"个人信息");
        }


        addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
               loginController.changeLoginState();
//
            }

        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "系统管理");

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(panel, "周报管理");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "个人信息");

            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "管理员信息");
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "闹钟设置");

            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "图书管理");

            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "任务清单");

            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "Home");
            }
        });


        this.setVisible(true);
        this.setResizable(false);

    }
    public ImageIcon change(ImageIcon image,double i){//  i 为放缩的倍数

        int width=(int) (image.getIconWidth()*i);
        int height=(int) (image.getIconHeight()*i);
        Image img=image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);//第三个值可以去查api是图片转化的方式
        ImageIcon image2=new ImageIcon(img);

        return image2;

    }

}
