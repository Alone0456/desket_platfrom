package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Date;

public class UserTest extends JFrame {

    private JPanel contentPane;
    private User user=new User("111","222","ttt",555,1,"32323","dadad",new Date(),1,new Role("daa"));
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserTest frame = new UserTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public UserTest() {
        setTitle("个人信息管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1006, 801);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //主模块
        JDesktopPane MainPane = new JDesktopPane();
        MainPane.setBackground(new Color(255, 255, 255));

        //详细信息模块
        JDesktopPane SpecificMassagePane = new JDesktopPane();
        SpecificMassagePane.setBackground(new Color(255, 255, 255));
        SpecificMassagePane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                SpecificMassagePane.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                SpecificMassagePane.setBackground(new Color(255,255,255));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                showSpecificMassage();
            }

        });

        //设置模块
        JDesktopPane SettingPane = new JDesktopPane();
        SettingPane.setBackground(new Color(255, 255, 255));
        SettingPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                SettingPane.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                SettingPane.setBackground(new Color(255,255,255));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                showSetting();
            }
        });

        //成员信息模块
        JDesktopPane studentMassagePane = new JDesktopPane();
        studentMassagePane.setBackground(new Color(255, 255, 255));
        studentMassagePane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                studentMassagePane.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                studentMassagePane.setBackground(new Color(255, 255, 255));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                showstudents();
            }
        });

        //职责查看模块
        JDesktopPane dutyPane = new JDesktopPane();
        dutyPane.setBackground(new Color(255, 255, 255));
        dutyPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                dutyPane.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                dutyPane.setBackground(new Color(255,255,255));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                showDuty();
            }
        });

        //设置布局
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(dutyPane, GroupLayout.PREFERRED_SIZE, 961, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MainPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                                        .addComponent(SpecificMassagePane, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                                        .addComponent(studentMassagePane, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                                        .addComponent(SettingPane, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(MainPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(SpecificMassagePane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(studentMassagePane, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(dutyPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(SettingPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(195, Short.MAX_VALUE))
        );

        JLabel dutyText = new JLabel("职责查看");
        //  dutyText.setIcon(new ImageIcon(User.class.getResource("/images/task.png")));
        dutyText.setFont(new Font("宋体", Font.PLAIN, 24));
        dutyText.setBounds(25, 20, 116, 59);
        dutyPane.add(dutyText);

        JLabel studentText = new JLabel("成员信息");
        //  studentText.setIcon(new ImageIcon(User.class.getResource("/images/student.png")));
        studentText.setFont(new Font("宋体", Font.PLAIN, 24));
        studentText.setBounds(25, 20, 132, 54);
        studentMassagePane.add(studentText);

        //文本框嵌入
        JLabel SettingText = new JLabel("设置");
        SettingText.setFont(new Font("宋体", Font.PLAIN, 24));
        //   SettingText.setIcon(new ImageIcon(User.class.getResource("/images/set.png")));
        SettingText.setBounds(26, 25, 69, 44);
        SettingPane.add(SettingText);

        JLabel specificMassageText = new JLabel("详细信息");
        //  specificMassageText.setIcon(new ImageIcon(User.class.getResource("/images/massage.png")));
        specificMassageText.setFont(new Font("宋体", Font.PLAIN, 24));
        specificMassageText.setBounds(20, 20, 199, 46);
        SpecificMassagePane.add(specificMassageText);

        //用户名字
        JLabel user = new JLabel("用户");
        user.setFont(new Font("宋体", Font.PLAIN, 44));
        user.setBounds(168, 28, 125, 51);
        user.setText(showName());
        MainPane.add(user);

        //学号展示
        JLabel studentNumbertext = new JLabel("学号:");
        studentNumbertext.setFont(new Font("宋体", Font.PLAIN, 18));
        studentNumbertext.setBounds(200, 89, 45, 34);
        MainPane.add(studentNumbertext);

        JLabel studentNumber = new JLabel("54");
        studentNumber.setFont(new Font("宋体", Font.PLAIN, 18));
        studentNumber.setBounds(216, 84, 176, 45);
        studentNumber.setText(showID());
        MainPane.add(studentNumber);
        contentPane.setLayout(gl_contentPane);
    }
    //查出或者获取用户名
    private String showName() {
        return "用户";
    }
    //查出或者获取学校编号
    private String showschoolnumber() {
        return "456";
    }
    //查出或者获取ID
    private String showID() {
        return "789";
    }

    //进入详细个人信息页面
    private void showSpecificMassage() {
        SpecificMassage frame=new SpecificMassage(user);
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
    //进入设置页面
    private void showSetting() {
        Settings settings=new Settings();
        settings.setDefaultCloseOperation(HIDE_ON_CLOSE);
        settings.setVisible(true);
    }

    //进入职责查看界面
    private void showDuty() {
        duty Duty=new duty();
        Duty.setDefaultCloseOperation(HIDE_ON_CLOSE);
        Duty.setVisible(true);
    }
    //进入成员信息界面
    private void showstudents() {
        students st=new students();
        st.setVisible(true);
        st.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}
