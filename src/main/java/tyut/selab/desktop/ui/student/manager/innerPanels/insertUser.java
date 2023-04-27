package tyut.selab.desktop.ui.student.manager.innerPanels;

import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.studentUtils;
import tyut.selab.desktop.ui.student.user.Massage;

import javax.swing.*;
import java.awt.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class insertUser extends JPanel {
    private JTextField Name;
    private JTextField AccountNumber;
    private JTextField Password;
    private JTextField StudentNumber;
    private JTextField Phone;
    private JTextField Email;
    private JComboBox Duty;
    private JComboBox Gender;

    public insertUser() {
        setBackground(new Color(255, 255, 255));
        setSize(1010,610);
        setOpaque(false);

        //设置固定标签和文本框
        JLabel PrintText = new JLabel("请输入用户信息:");
        PrintText.setFont(new Font("幼圆", Font.BOLD, 35));

        JLabel NameText = new JLabel("姓名:");
        NameText.setFont(new Font("幼圆", Font.BOLD, 25));

        JLabel GenderText = new JLabel("性别:");
        GenderText.setFont(new Font("幼圆", Font.BOLD, 25));

        Gender = new JComboBox();
        Gender.setFont(new Font("宋体", Font.PLAIN, 25));
        Gender.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
        Gender.setOpaque(false);

        JLabel AccountNumberText = new JLabel("账号:");
        AccountNumberText.setFont(new Font("幼圆", Font.BOLD, 25));

        JLabel PasswordText = new JLabel("密码:");
        PasswordText.setFont(new Font("幼圆", Font.BOLD, 25));

        JLabel studentNumberText = new JLabel("学号:");
        studentNumberText.setFont(new Font("幼圆", Font.BOLD, 25));

        JLabel PhoneText = new JLabel("电话号:");
        PhoneText.setFont(new Font("幼圆", Font.BOLD, 25));

        JLabel EmailText = new JLabel("邮箱:");
        EmailText.setFont(new Font("幼圆", Font.BOLD, 25));

        JLabel DutyText = new JLabel("职责:");
        DutyText.setFont(new Font("幼圆", Font.BOLD, 25));

        Name = new JTextField();
        Name.setFont(new Font("宋体", Font.PLAIN, 25));
        Name.setColumns(10);
        Name.setOpaque(false);

        AccountNumber = new JTextField();
        AccountNumber.setFont(new Font("宋体", Font.PLAIN, 25));
        AccountNumber.setColumns(10);
        AccountNumber.setOpaque(false);

        Password = new JTextField();
        Password.setFont(new Font("宋体", Font.PLAIN, 25));
        Password.setColumns(10);
        Password.setOpaque(false);

        StudentNumber = new JTextField();
        StudentNumber.setFont(new Font("宋体", Font.PLAIN, 25));
        StudentNumber.setColumns(10);
        StudentNumber.setOpaque(false);

        Phone = new JTextField();
        Phone.setFont(new Font("宋体", Font.PLAIN, 25));
        Phone.setColumns(10);
        Phone.setOpaque(false);

        Email = new JTextField();
        Email.setFont(new Font("宋体", Font.PLAIN, 25));
        Email.setColumns(10);
        Email.setOpaque(false);

        Duty =  new JComboBox();
        Duty.setModel(new DefaultComboBoxModel(new String[] {"用户"}));
        Duty.setFont(new Font("宋体", Font.PLAIN, 25));
        Duty.setOpaque(false);

        //添加按钮
        JButton submitButton = new JButton("添加");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertData();
            }
        });
        submitButton.setFont(new Font("幼圆", Font.BOLD, 25));

        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(46)
                                                .addComponent(PrintText, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(43)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                .addComponent(NameText, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                                        .addComponent(studentNumberText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(AccountNumberText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(PhoneText)
                                                                        .addComponent(DutyText, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(4)))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(Phone, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                                                        .addComponent(StudentNumber, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                                        .addComponent(Name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                                                                        .addComponent(AccountNumber, 246, 246, 246))
                                                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                                                .addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(EmailText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(GenderText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addComponent(PasswordText))
                                                                .addGap(18)
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(Email, 279, 279, 279)
                                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(Password, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))))
                                                        .addComponent(Duty, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
                                .addGap(100))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(396)
                                .addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(488, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(20)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(PrintText, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addGap(47)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(NameText, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Name, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(GenderText, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                                .addGap(34)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(PasswordText, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Password, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(AccountNumberText, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(AccountNumber, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(28)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(studentNumberText, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(StudentNumber, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                                .addGap(29)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Phone, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(108)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(EmailText, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Email, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
                                .addGap(33)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(Duty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DutyText, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addGap(54)
                                .addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        setLayout(groupLayout);
    }

    //信息存入数据库
    private void insertData() {
        if(studentUtils.isNotNull(Name)&&studentUtils.isNotNull(StudentNumber)&&studentUtils.isNotNull(Email)&&studentUtils.isNotNull(Phone)&&studentUtils.isNotNull(AccountNumber)&&studentUtils.isNotNull(Password)) {
            //获取填入的信息
            String name = Name.getText();
            Integer studentNumber = Integer.valueOf(StudentNumber.getText());
            String accountNumber = AccountNumber.getText();
            String email = Email.getText();
            String phone = Phone.getText();
            String duty = "用户";
            String password = Password.getText();
            int gender = Gender.getSelectedIndex();
            if (studentUtils.isPhone(Phone) && studentUtils.isEmail(Email)) {
                //添加进入数据库
                if (studentUtils.isNumber(StudentNumber)) {
                    UserController userController = new UserController();
                    UserRegisterVo newUser = new UserRegisterVo(studentNumber, password, name, accountNumber, gender, phone, email, duty);
                    if (studentUtils.isSuccess(userController.insertUser(newUser))) {
                        JOptionPane.showMessageDialog(null, "添加成功");
                        clearText();
                    } else {
                        JOptionPane.showMessageDialog(null, "添加失败");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null,"电话号或邮箱格式有误");
            }
        }
    }

    private void clearText(){
        Name.setText("");
        StudentNumber.setText("");
        Gender.setSelectedIndex(0);
        AccountNumber.setText("");
        Email.setText("");
        Phone.setText("");
        Duty.setSelectedIndex(0);
        Password.setText("");
    }
}
