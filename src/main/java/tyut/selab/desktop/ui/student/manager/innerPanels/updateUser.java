package tyut.selab.desktop.ui.student.manager.innerPanels;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.studentUtils;
import tyut.selab.desktop.ui.student.user.Massage;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateUser extends JPanel {
    private JTextField Name;
    private JTextField AccountNumber;
    private JTextField StudentNumber;
    private JTextField Phone;
    private JTextField Email;
    private JComboBox Duty;
    private JButton NameButton;
    private JButton studentNumberButton;
    private JTextField textField;
    private JComboBox Gender;
    private boolean isName=true;
    public updateUser() {
        setBackground(new Color(255, 255, 255));
        setSize(1010,610);
        setOpaque(false);

        //设定固定文本和文本框
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

        Duty = new JComboBox();
        Duty.setModel(new DefaultComboBoxModel(new String[] {"用户"}));
        Duty.setFont(new Font("宋体", Font.PLAIN, 25));
        Duty.setOpaque(false);

        //提交按钮
        JButton submitButton = new JButton("修改");
        submitButton.setFont(new Font("幼圆", Font.BOLD, 25));
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    updateData();
            }
        });

        JLabel ByText = new JLabel("通过");
        ByText.setFont(new Font("幼圆", Font.BOLD, 25));

        //姓名按钮
        NameButton = new JButton("姓名");
        NameButton.setFont(new Font("幼圆", Font.BOLD, 20));
        NameButton.setOpaque(false);
        NameButton.setBackground(Color.gray);
        NameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NameButton.setBackground(Color.gray);
                studentNumberButton.setBackground(new Color(255, 255, 255));
                setIsName(true);
            }
        });
        NameButton.setForeground(new Color(192, 192, 192));

        //学号按钮
        studentNumberButton = new JButton("学号");
        studentNumberButton.setFont(new Font("幼圆", Font.BOLD, 20));
        studentNumberButton.setOpaque(false);
        studentNumberButton.setBackground(new Color(255, 255, 255));
        studentNumberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentNumberButton.setBackground(Color.gray);
                NameButton.setBackground(new Color(255, 255, 255));
                setIsName(false);
            }
        });

        textField = new JTextField();
        textField.setFont(new Font("幼圆", Font.BOLD, 20));
        textField.setColumns(10);

        //查找按钮
        JButton SelectButton = new JButton("查找");
        SelectButton.setFont(new Font("幼圆", Font.BOLD, 20));
        SelectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    initData(Select());
            }
        });
        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
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
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(EmailText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(GenderText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(Email, 279, 326, 450)
                                                        .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                                .addGap(100))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(Duty, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(396)
                                .addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(488, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(99)
                                .addComponent(ByText)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(NameButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(studentNumberButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(SelectButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(327, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(25)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(ByText, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                .addComponent(studentNumberButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(NameButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                .addComponent(SelectButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                                .addGap(50)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(NameText, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(GenderText, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                                .addGap(34)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(AccountNumberText, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AccountNumber, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGap(2)
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

    //修改数据
    public void updateData() {
        if(studentUtils.isNotNull(Name)&&studentUtils.isNotNull(StudentNumber)&&studentUtils.isNotNull(Email)&&studentUtils.isNotNull(Phone)&&studentUtils.isNotNull(AccountNumber)) {
            //取出填入的信息
            String name=Name.getText();
            Integer studentNumber= Integer.valueOf(StudentNumber.getText());
            int gender=Gender.getSelectedIndex();
            String accountNumber=AccountNumber.getText();
            String  email=Email.getText();
            String phone=Phone.getText();
            String duty="用户";
            if(studentUtils.isEmail(Email)&&studentUtils.isPhone(Phone)) {
                //连接数据库进行修改
                UserController usercontroller = new UserController();
                UserVo oldUser = Select();
                UserVo newUser = new UserVo(studentNumber, name, accountNumber, gender, phone, email, duty);
                if (studentUtils.isSuccess(usercontroller.updateUser(oldUser, newUser))) {
                    JOptionPane.showMessageDialog(null, "修改成功");
                    clearText();
                } else {
                    JOptionPane.showMessageDialog(null, "修改失败");
                }
            }else{
                JOptionPane.showMessageDialog(null,"电话号或邮箱输入格式有误");
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
    }
    public void setIsName(boolean name) {
        isName = name;
    }

    //查询用户
    private UserVo Select() {
        UserController userController = new UserController();
        if (isName) {
            String name = textField.getText();
            UserVo user = userController.queryUserByStudentName(name);
            if (studentUtils.isSelect(user)) {
                return user;
            }else{
                return null;
            }
        } else {
                Integer studentNumber = Integer.valueOf(textField.getText());
                UserVo user = userController.queryUserByStudentNumber(studentNumber);
                if (studentUtils.isSelect(user)) { //如果查到用户则返回
                    return user;
                }else{
                    return null;
                }
            }

    }

    //初始化未修改前的数据
    public void initData(UserVo user) {
        if(user!=null) {
            Name.setText(user.getName());
            StudentNumber.setText(String.valueOf(user.getStudentNumber()));
            Gender.setSelectedIndex(user.getGender());
            Email.setText(user.getPost());
            Phone.setText(user.getPhone());
            AccountNumber.setText(user.getAccountNumber());
            Duty.setSelectedIndex(0);
        }
    }
}
