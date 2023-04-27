package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.moudle.student.domain.User;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class Massage extends JPanel {
    private JLabel Name;
    private JLabel Gender;
    private JLabel studentNumber;
    private JLabel AccountNumber;
    private JLabel Phone;
    private JLabel Email;
    private JLabel Duty;
    private Image image;
    private Image background;
    /**
     * Create the panel.
     */
    public Massage(User user) {
        setBackground(new Color(255, 255, 255));
        setSize(1010,650);

        //初始化信息
        JLabel NameText = new JLabel("姓名:");
        NameText.setFont(new Font("幼圆", Font.BOLD, 30));
        NameText.setIcon(new ImageIcon(Massage.class.getResource("pngs/name.png")));

        Name = new JLabel("New label");
        Name.setFont(new Font("幼圆", Font.BOLD, 30));

        JLabel GenderText = new JLabel("性别:");
        GenderText.setFont(new Font("幼圆", Font.BOLD, 30));
        GenderText.setIcon(new ImageIcon(Massage.class.getResource("pngs/sex.png")));

        Gender = new JLabel("New label");
        Gender.setFont(new Font("幼圆", Font.BOLD, 30));

        JLabel studentNumberText = new JLabel("学号:");
        studentNumberText.setFont(new Font("幼圆", Font.BOLD, 30));
        studentNumberText.setIcon(new ImageIcon(Massage.class.getResource("pngs/studentNumber.png")));

        studentNumber = new JLabel("New label");
        studentNumber.setFont(new Font("幼圆", Font.BOLD, 30));

        JLabel AccountNumberText = new JLabel("账号:");
        AccountNumberText.setFont(new Font("幼圆", Font.BOLD, 30));
        AccountNumberText.setIcon(new ImageIcon(Massage.class.getResource("pngs/AccountNumber.png")));

        AccountNumber = new JLabel("New label");
        AccountNumber.setFont(new Font("幼圆", Font.BOLD, 30));

        JLabel PhoneText = new JLabel("手机号:");
        PhoneText.setFont(new Font("幼圆", Font.BOLD, 30));
        PhoneText.setIcon(new ImageIcon(Massage.class.getResource("pngs/phone.png")));

        Phone = new JLabel("New label");
        Phone.setFont(new Font("幼圆", Font.BOLD, 30));

        JLabel EmailText = new JLabel("邮箱:");
        EmailText.setFont(new Font("幼圆", Font.BOLD, 30));
        EmailText.setIcon(new ImageIcon(Massage.class.getResource("pngs/post.png")));

        Email = new JLabel("New label");
        Email.setFont(new Font("幼圆", Font.BOLD, 30));

        JLabel DutyText = new JLabel("职责:");
        DutyText.setFont(new Font("幼圆", Font.BOLD, 30));
        DutyText.setIcon(new ImageIcon(Massage.class.getResource("pngs/duty.png")));

        Duty = new JLabel("New label");
        Duty.setFont(new Font("幼圆", Font.BOLD, 30));

        //初始化信息
        initData(user);

        //设置照片
        File file=new File("src\\main\\java\\tyut\\selab\\desktop\\ui\\student\\user\\pngs\\user.png");
        try {
            image=ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        background = new ImageIcon(Massage.class.getResource("pngs/background.png")).getImage();

        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(86)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(PhoneText)
                                        .addComponent(EmailText, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                .addComponent(AccountNumberText, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(studentNumberText)
                                                .addComponent(NameText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                                .addGap(35)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(Phone, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                                        .addComponent(AccountNumber, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                                        .addComponent(studentNumber, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                                        .addComponent(Email, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                                                .addGap(50))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(GenderText)
                                        .addComponent(DutyText, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Duty, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                .addGap(151))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(194)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Name)
                                        .addComponent(GenderText, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NameText, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                                .addGap(24)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(studentNumber, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(studentNumberText, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DutyText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Duty, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(26)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(AccountNumber, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                        .addComponent(AccountNumberText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(34)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Phone, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addGap(28)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Email, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EmailText, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addGap(113))
        );
        setLayout(groupLayout);
    }

    //初始化信息
    public void initData(User user) {
        Name.setText(user.getName());
        studentNumber.setText(String.valueOf(user.getStudentNumber()));
        Gender.setText(user.getGender()==0?"男":"女");
        Email.setText(user.getPost());
        Phone.setText(user.getPhone());
        AccountNumber.setText(user.getAccountNumber());
        Duty.setText(user.getRole().getDuty());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0,getWidth(),getHeight(),this);
        g.drawImage(image, 420, 20,120,120,null);
    }
}
