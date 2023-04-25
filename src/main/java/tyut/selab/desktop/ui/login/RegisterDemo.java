package tyut.selab.desktop.ui.login;
import tyut.selab.desktop.moudle.login.controller.impl.LoginController;
import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;

public class RegisterDemo extends JFrame {
    LoginController loginController =new LoginController();
    UserRegisterVo userRegisterVo = new UserRegisterVo();
    public RegisterDemo() {
        //      获取显示屏的大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = screenSize.width;
        int sh = screenSize.height;
        //      设置窗口的位置
        int width = 500;
        int height = 600;
        this.setBounds((sw - width) / 2, (sh - height) / 2, width, height);
        this.setTitle("注册界面");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\logo.png"));// 图标
        ImageIcon background = new ImageIcon("src\\img\\back1.jpg"); // 背景图片
        JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
        label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
        JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel.setOpaque(false); // 窗口透明
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景

//      盒子模块
        Box accountbox = Box.createHorizontalBox();//账号
        Box namebox = Box.createHorizontalBox();//姓名
        Box genderbox = Box.createHorizontalBox();//性别
        Box student_numberbox = Box.createHorizontalBox();//学号
        Box phonebox = Box.createHorizontalBox();//电话
        Box postbox = Box.createHorizontalBox();//邮箱
        Box pbox = Box.createHorizontalBox();//密码
        Box repbox = Box.createHorizontalBox();//确认密码
        Box vbox = Box.createVerticalBox();

        //      创建界面工具类
        JLabel accountLabel = new JLabel("账     号 :"); //文本设计
        accountLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        accountLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        JTextField accountField = new JTextField(); //输入框
        accountField.setFont(new Font("黑体", Font.BOLD, 15));
        accountField.setToolTipText("账号");
        accountField.setColumns(15);

        //      创建界面工具类
        JLabel nameLabel = new JLabel("姓     名 :"); //文本设计
        nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        nameLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        JTextField nameField = new JTextField(); //输入框
        nameField.setFont(new Font("黑体", Font.BOLD, 15));
        nameField.setToolTipText("姓名");
        nameField.setColumns(15);

        JLabel genderLabel = new JLabel("性    别  :"); //文本设计
        genderLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        genderLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        JComboBox<String>  gender = new JComboBox<String>();//创建一个下拉列表框c1
        gender.addItem("男");
        gender.addItem("女");
        gender.addItem("？？？");
        gender.setFont(new Font("黑体", Font.BOLD, 15));
        gender.setToolTipText("姓名");
//        gender.setColumns(15);

        //      创建界面工具类
        JLabel student_numberLabel = new JLabel("学     号 :"); //文本设计
        student_numberLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        student_numberLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        JTextField student_numberField = new JTextField(); //输入框
        student_numberField.setFont(new Font("黑体", Font.BOLD, 15));
        student_numberField.setToolTipText("学号");
        student_numberField.setColumns(15);

        //      创建界面工具类
        JLabel phoneLabel = new JLabel("电     话 :"); //文本设计
        phoneLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        phoneLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        JTextField phoneField = new JTextField(); //输入框
        phoneField.setFont(new Font("黑体", Font.BOLD, 15));
        phoneField.setToolTipText("电话");
        phoneField.setColumns(15);


//      创建界面工具类
        JLabel postLabel = new JLabel("邮     箱 :"); //文本设计
        postLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        postLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        JTextField postField = new JTextField(); //输入框
        postField.setFont(new Font("Arial", Font.BOLD, 15));
        postField.setToolTipText("邮箱");
//        uField.setUI(new BasicTextFieldUI()); //恢复基本视觉效果
        postField.setColumns(15);

        JLabel pLabel = new JLabel("密     码 :");    //文本设计
        pLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        pLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        JPasswordField pFd = new JPasswordField();
        pFd.setFont(new Font("Arial", Font.BOLD, 15));
//        pFd.setUI(new BasicPasswordFieldUI()); //恢复基本视觉效果
        pFd.setToolTipText("密码");// 悬停显示
        pFd.setColumns(15);
        // 如果使用其他回显字符，可以设置大小，但是星星不可以。。。
        pFd.setEchoChar('●');// 星星符号


        JLabel RepLabel = new JLabel("确认密码:");    //文本设计
        RepLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        RepLabel.setForeground(new Color(0xE575B5)); // 设置前景色
        JPasswordField RepFd = new JPasswordField();
        RepFd.setFont(new Font("Arial", Font.BOLD, 15));
//        RepFd.setUI(new BasicPasswordFieldUI()); //恢复基本视觉效果
        RepFd.setToolTipText("确认密码");// 悬停显示
        RepFd.setColumns(15);
        // 如果使用其他回显字符，可以设置大小，但是星星不可以。。。
        RepFd.setEchoChar('●');// 星星符号

        JButton button1 = new JButton("注册");    //登录按钮
        button1.setToolTipText("注册");// 悬停显示
        JButton button2 = new JButton("返回登录");    //重置按钮
        button2.setToolTipText("返回登录");// 悬停显示
//      字体设置
        button1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button1.setForeground(Color.white); // 设置前景色
        button1.setBackground(new Color(0xE575B5));
        button1.setDefaultCapable(true);
//        button1.setContentAreaFilled(false); // 设置按钮透明
        button1.setBounds((this.getWidth() - 120 - 180) / 2, this.getHeight() - 110, 120, 30); // 设置按钮位置，及按钮大小
//        button1.setUI(new BasicButtonUI()); //恢复基本视觉效果
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));  //鼠标手势的设置

        button2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button2.setForeground(Color.white); // 设置前景色
        button2.setBackground(new Color(0xE575B5));
        button2.setDefaultCapable(true);
//        button2.setContentAreaFilled(false); // 设置按钮透明
//        button2.setUI(new BasicButtonUI()); //恢复基本视觉效果
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标手势的设置
        button2.setBounds((this.getWidth() - 120 + 180) / 2, this.getHeight() - 110, 120, 30); // 设置按钮位置，及按钮大小

        /*
         分区模块布局
        */
//        小盒子，设计用户名模块
        accountbox.add(accountLabel);
        accountbox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为10，作为相邻文本的空隙
        accountbox.add(accountField);

        namebox.add(nameLabel);
        namebox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为10，作为相邻文本的空隙
        namebox.add(nameField);

        genderbox.add(genderLabel);
        genderbox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为10，作为相邻文本的空隙
        genderbox.add(gender);

        student_numberbox.add(student_numberLabel);
        student_numberbox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为10，作为相邻文本的空隙
        student_numberbox.add(student_numberField);

        phonebox.add(phoneLabel);
        phonebox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为10，作为相邻文本的空隙
        phonebox.add(phoneField);

        postbox.add(postLabel);
        postbox.add(Box.createHorizontalStrut(5));//插入中间盒子宽度为10，作为相邻文本的空隙
        postbox.add(postField);
//        小盒子，设计密码模块
        pbox.add(pLabel);
        pbox.add(Box.createHorizontalStrut(5));
        pbox.add(pFd);

        repbox.add(RepLabel);
        repbox.add(Box.createHorizontalStrut(5));
        repbox.add(RepFd);

//      大盒子
        vbox.add(Box.createVerticalStrut(40));//插入中间盒子高度为20，作为上下文本的空隙
        vbox.add(accountbox);
        vbox.add(Box.createVerticalStrut(25));//插入中间盒子高度为20，作为上下文本的空隙
        vbox.add(genderbox);
        vbox.add(Box.createVerticalStrut(25));
        vbox.add(namebox);
        vbox.add(Box.createVerticalStrut(25));
        vbox.add(student_numberbox);
        vbox.add(Box.createVerticalStrut(25));
        vbox.add(phonebox);
        vbox.add(Box.createVerticalStrut(25));
        vbox.add(postbox);
        vbox.add(Box.createVerticalStrut(25));
        vbox.add(pbox);
        vbox.add(Box.createVerticalStrut(25));
        vbox.add(repbox);

        //转换
        JPanel panel = new JPanel();
        panel.setUI(new BasicPanelUI());  //恢复基本视觉效果
        panel.setOpaque(false); // 面板透明
        panel.add(vbox, BorderLayout.CENTER);//将大盒子添加到jLabel盒子里
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        button1.addActionListener(e -> {
            String pField = new String(pFd.getPassword());//转换
            String repField = new String(RepFd.getPassword());//转换
//            try {

                    if (!pField.equals(repField)) {
                        JOptionPane.showMessageDialog(null, "两次密码不一致", "提示", JOptionPane.WARNING_MESSAGE);
                    } else {
                       String str = init(accountField,pFd,nameField,gender,student_numberField,phoneField,postField);
                       if(str.equals("注册成功")){
                           this.dispose();
//                           Thread.sleep(0);
                           try {//123333333123123123123123123123
                               new LoginDemo();
                           } catch (Exception ex) {
                               throw new RuntimeException(ex);
                           }
                       } else JOptionPane.showMessageDialog(null, init(accountField,pFd,nameField,gender,student_numberField,phoneField,postField), "警告", JOptionPane.WARNING_MESSAGE);
                    }


//            } catch (Exception exception) {
//                JOptionPane.showMessageDialog(null, "请输入正确学号", "警告", JOptionPane.WARNING_MESSAGE);
//            }
        });
        button2.addActionListener(e -> {
            try {
                this.dispose();
                Thread.sleep(0);
                new LoginDemo();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "异常", "警告", JOptionPane.WARNING_MESSAGE);
            }
        });
        this.add(button1);
        this.add(button2);
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
    }
    public String init(JTextField accountField, JPasswordField pFd, JTextField nameField, JComboBox<String> gender, JTextField student_numberField, JTextField phoneField, JTextField postField) {

         userRegisterVo.setStudentNumber(Integer.valueOf(student_numberField.getText()));//学号
        char[] p1 = pFd.getPassword();
        userRegisterVo.setPassword(new String(p1));//密码
        userRegisterVo.setAccountNumber(accountField.getText());//账号
        userRegisterVo.setName(nameField.getText());//姓名
        userRegisterVo.setPhone(phoneField.getText());//电话
        String str = String.valueOf(gender);
        if(str.equals("男")){
            userRegisterVo.setGender(0);//性别
        }else{
            userRegisterVo.setGender(1);//性别
        }
        userRegisterVo.setPost(postField.getText());//邮箱
        return loginController.register(userRegisterVo);//注册
   }

}
