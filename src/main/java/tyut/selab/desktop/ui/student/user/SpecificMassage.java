package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class SpecificMassage extends JFrame {
    private JPanel contentPane;
    public SpecificMassage() {
        setTitle("详细信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 724, 813);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //主面板
        JDesktopPane MainPane = new JDesktopPane();
        MainPane.setBackground(new Color(192, 192, 192));

        //设置布局器
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(36)
                                .addComponent(MainPane, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(MainPane, GroupLayout.PREFERRED_SIZE, 737, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        //个人信息面板
        //名字面板
        JDesktopPane NamePane = new JDesktopPane();
        NamePane.setBackground(new Color(153, 154, 162));

        //学号面板
        JDesktopPane IDPane = new JDesktopPane();
        IDPane.setBackground(new Color(153, 154, 162));

        //性别面板
        JDesktopPane sexPane = new JDesktopPane();
        sexPane.setBackground(new Color(153, 154, 162));

        //手机号面板
        JDesktopPane telephoneNumberPane = new JDesktopPane();
        telephoneNumberPane.setBackground(new Color(153, 154, 162));

        //年龄面板
        JDesktopPane agePane = new JDesktopPane();
        agePane.setBackground(new Color(153, 154, 162));

        //邮箱面板
        JDesktopPane emailPane = new JDesktopPane();
        emailPane.setBackground(new Color(153, 154, 162));

        //账号面板
        JDesktopPane accountnumberPane = new JDesktopPane();
        accountnumberPane.setBackground(new Color(153, 154, 162));
        /**
         * 固定文本
         */
        JLabel nameText = new JLabel("名字：");
        nameText.setFont(new Font("宋体", Font.PLAIN, 30));
        nameText.setBounds(25, 24, 159, 49);
        NamePane.add(nameText);

        JLabel IDText = new JLabel("学号：");
        IDText.setFont(new Font("宋体", Font.PLAIN, 30));
        IDText.setBounds(25, 23, 117, 43);
        IDPane.add(IDText);

        JLabel SexText = new JLabel("性别：");
        SexText.setFont(new Font("宋体", Font.PLAIN, 30));
        SexText.setBounds(25, 22, 105, 44);
        sexPane.add(SexText);

        JLabel TelephoneNumberText = new JLabel("手机号：");
        TelephoneNumberText.setFont(new Font("宋体", Font.PLAIN, 30));
        TelephoneNumberText.setBounds(25, 22, 123, 38);
        telephoneNumberPane.add(TelephoneNumberText);

        JLabel ageText = new JLabel("年龄：");
        ageText.setFont(new Font("宋体", Font.PLAIN, 30));
        ageText.setBounds(25, 20, 141, 53);
        agePane.add(ageText);

        JLabel emailText = new JLabel("邮箱：");
        emailText.setFont(new Font("宋体", Font.PLAIN, 30));
        emailText.setBounds(25, 14, 90, 58);
        emailPane.add(emailText);

        JLabel accountnumberText = new JLabel("账号：");
        accountnumberText.setFont(new Font("宋体", Font.PLAIN, 30));
        accountnumberText.setBounds(25, 23, 100, 41);
        accountnumberPane.add(accountnumberText);

        /**
         * 读取到的个人信息标签
         */
        //名字
        JLabel name = new JLabel("New label");
        name.setFont(new Font("宋体", Font.PLAIN, 30));
        name.setBounds(453, 24, 175, 49);
        NamePane.add(name);
        //ID
        JLabel ID = new JLabel("New label");
        ID.setFont(new Font("宋体", Font.PLAIN, 30));
        ID.setBounds(453, 24, 170, 43);
        IDPane.add(ID);
        //性别
        JLabel sex =  new JLabel("New label");
        sex.setFont(new Font("宋体", Font.PLAIN, 30));
        sex.setBounds(453, 10, 171, 56);
        sexPane.add(sex);
        //年龄
        JLabel age = new JLabel("New label");
        age.setFont(new Font("宋体", Font.PLAIN, 30));
        age.setBounds(453, 20, 197, 53);
        agePane.add(age);
        //手机号
        JLabel telephoneNumber = new JLabel("New label");
        telephoneNumber.setFont(new Font("宋体", Font.PLAIN, 30));
        telephoneNumber.setBounds(453, 22, 175, 39);
        telephoneNumberPane.add(telephoneNumber);
        //邮箱
        JLabel email = new JLabel("New label");
        email.setFont(new Font("宋体", Font.PLAIN, 30));
        email.setBounds(453, 19, 156, 58);
        emailPane.add(email);
        //账号
        JLabel accountnumber = new JLabel("New label");
        accountnumber.setFont(new Font("宋体", Font.PLAIN, 30));
        accountnumber.setBounds(453, 23, 189, 52);
        accountnumberPane.add(accountnumber);

        //设置布局器
        GroupLayout gl_MainPane = new GroupLayout(MainPane);
        gl_MainPane.setHorizontalGroup(
                gl_MainPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(NamePane, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE)
                        .addComponent(IDPane, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sexPane, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                        .addComponent(telephoneNumberPane, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailPane, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_MainPane.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(accountnumberPane, Alignment.LEADING)
                                .addComponent(agePane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
        );
        gl_MainPane.setVerticalGroup(
                gl_MainPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_MainPane.createSequentialGroup()
                                .addComponent(NamePane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(IDPane, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(5)
                                .addComponent(sexPane, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(agePane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(accountnumberPane, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(emailPane, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(telephoneNumberPane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addGap(95))
        );
        MainPane.setLayout(gl_MainPane);
        contentPane.setLayout(gl_contentPane);
    }

    //获取个人信息
    private void getMassage(){
        UserVo userVo=new UserVo();
        //初始化信息
    }

}
