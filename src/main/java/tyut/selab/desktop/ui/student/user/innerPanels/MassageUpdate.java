package tyut.selab.desktop.ui.student.user.innerPanels;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.studentUtils;
import tyut.selab.desktop.ui.student.user.Massage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class MassageUpdate extends JPanel {
    private JTextField Name;
    private JTextField AccountNumber;
    private JTextField StudentNumber;
    private JTextField Phone;
    private JTextField Email;
    private JTextField Duty;
    private JComboBox Gender;

    public MassageUpdate(User user, Massage parentPanel) {
        setBackground(new Color(255, 255, 255));
        setSize(1010,610);

        //设置固定标签和文本框
        JLabel NameText = new JLabel("姓名:");
        NameText.setFont(new Font("幼圆", Font.BOLD, 25));

        JLabel GenderText = new JLabel("性别:");
        GenderText.setFont(new Font("幼圆", Font.BOLD, 25));

        Gender = new JComboBox();
        Gender.setFont(new Font("宋体", Font.PLAIN, 25));
        Gender.setModel(new DefaultComboBoxModel(new String[] {"女", "男"}));

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

        AccountNumber = new JTextField();
        AccountNumber.setFont(new Font("宋体", Font.PLAIN, 25));
        AccountNumber.setColumns(10);


        StudentNumber = new JTextField();
        StudentNumber.setFont(new Font("宋体", Font.PLAIN, 25));
        StudentNumber.setColumns(10);

        Phone = new JTextField();
        Phone.setFont(new Font("宋体", Font.PLAIN, 25));
        Phone.setColumns(10);

        Email = new JTextField();
        Email.setFont(new Font("宋体", Font.PLAIN, 25));
        Email.setColumns(10);

        Duty = new JTextField();
        Duty.setFont(new Font("宋体", Font.PLAIN, 25));
        Duty.setColumns(10);

        //初始化数据
        initData(user);

        //修改按钮
        JButton submitButton = new JButton("修改");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update(user);
                initData(user);
                parentPanel.initData(user);
            }
        });
        submitButton.setFont(new Font("幼圆", Font.BOLD, 25));

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
                                                        .addComponent(Email, 279, 279, 279)
                                                        .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                                .addGap(100))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(Duty, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(396)
                                .addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(488, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(109)
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

    //初始化未修改前的数据
    public void initData(User user) {
        Name.setText(user.getName());
        StudentNumber.setText(String.valueOf(user.getStudentNumber()));
        Gender.setSelectedItem(user.getGender());
        Email.setText(user.getPost());
        Phone.setText(user.getPhone());
        Duty.setText(user.getRole().getDuty());
        AccountNumber.setText(user.getAccountNumber());
    }

    //进行修改操作
    private void update(User user){
        if(studentUtils.isNotNull(Name)&&studentUtils.isNotNull(AccountNumber)&&studentUtils.isNotNull(StudentNumber)&&studentUtils.isNotNull(Phone)&&studentUtils.isNotNull(Email)&&studentUtils.isNotNull(Duty)){
            String name=Name.getText();
            int gender=Gender.getSelectedIndex();
            String email=Email.getText();
            String phone=Phone.getText();
            String accountNumber=AccountNumber.getText();
            //连接数据库进行修改
            UserController userController=new UserController();
            UserVo oldUser=new UserVo(user.getStudentNumber(),user.getName(),user.getAccountNumber(),user.getGender(),user.getPhone(),user.getPost(),user.getRole().getDuty());
            UserVo newUser=new UserVo(user.getStudentNumber(),name,accountNumber,gender,phone,email,user.getRole().getDuty());
            if(studentUtils.isSuccess(userController.updateUser(oldUser,newUser))){
                JOptionPane.showMessageDialog(null,"修改成功");
            }else{
                JOptionPane.showMessageDialog(null,"修改失败");
            }
        }
    }
}
