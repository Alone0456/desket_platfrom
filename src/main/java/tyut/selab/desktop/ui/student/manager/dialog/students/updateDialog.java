package tyut.selab.desktop.ui.student.manager.dialog.students;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField Name;
    private JTextField Email;
    private JTextField StudentNumber;
    private JTextField Phone;
    private JComboBox Gender;
    private JPanel buttonPane;
    private JTextField AccountNumber;
    private JTextField Password;
    private JTextField Duty;
    UserVo olduser=new UserVo();

    public updateDialog(UserVo user) {
        setTitle("修改界面");
        setBounds(100, 100, 558, 625);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocation(EXIT_ON_CLOSE, ABORT);

        //设置固定标签
        JLabel nameText = new JLabel("名字:");
        nameText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel studentNumberText = new JLabel("学号:");
        studentNumberText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel GenderText = new JLabel("性别:");
        GenderText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel emailText = new JLabel("地址:");
        emailText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel accountNumberText = new JLabel("账户:");
        accountNumberText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel PhoneText = new JLabel("手机号:");
        PhoneText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel passwordText = new JLabel("密码:");
        passwordText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel dutyText = new JLabel("职责:");
        dutyText.setFont(new Font("宋体", Font.PLAIN, 30));
        //可以修改的数据
        Name = new JTextField();
        Name.setFont(new Font("宋体", Font.PLAIN, 30));
        Name.setColumns(10);

        Email = new JTextField();
        Email.setFont(new Font("宋体", Font.PLAIN, 30));
        Email.setColumns(10);

        StudentNumber = new JTextField();
        StudentNumber.setFont(new Font("宋体", Font.PLAIN, 30));
        StudentNumber.setColumns(10);

        Phone = new JTextField("");
        Phone.setFont(new Font("宋体", Font.PLAIN, 30));

        Gender = new JComboBox();
        Gender.setFont(new Font("宋体", Font.PLAIN, 30));
        Gender.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));

        AccountNumber = new JTextField();
        AccountNumber.setFont(new Font("宋体", Font.PLAIN, 30));
        AccountNumber.setColumns(10);

        Password = new JTextField();
        Password.setFont(new Font("宋体", Font.PLAIN, 30));
        Password.setColumns(10);

        Duty = new JTextField();
        Duty.setFont(new Font("宋体", Font.PLAIN, 30));
        Duty.setColumns(10);

        //初始化原有信息
        initData(olduser);

        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(36)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(GenderText)
                                                        .addComponent(studentNumberText)
                                                        .addComponent(emailText)
                                                        .addComponent(nameText))
                                                .addGap(18)
                                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                                                .addComponent(Name, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                                                .addComponent(Email, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                                                .addComponent(StudentNumber))))
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                                .addComponent(PhoneText)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(Phone))
                                                        .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
                                                                .addGroup(gl_contentPanel.createSequentialGroup()
                                                                        .addComponent(accountNumberText, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(AccountNumber, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(gl_contentPanel.createSequentialGroup()
                                                                        .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(dutyText)
                                                                                .addComponent(passwordText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGap(18)
                                                                        .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(Duty, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(Password, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)))))))
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(40)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                .addGap(13)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(StudentNumber, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(studentNumberText, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(GenderText, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addComponent(emailText, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED))
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addComponent(Email, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)))
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(accountNumberText, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AccountNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Duty, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dutyText, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        contentPanel.setLayout(gl_contentPanel);


        {  //设置按钮面板
            buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            {
                //确认按钮
                JButton okButton = new JButton("确认");
                okButton.setActionCommand("OK");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        updateData(olduser);
                    }
                });
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                //取消按钮
                JButton cancelButton = new JButton("取消");
                cancelButton.setActionCommand("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(cancelButton);
            }
        }

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(contentPanel, 0, 0, Short.MAX_VALUE))
                                        .addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE))
                                .addGap(0))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(1))
        );
        getContentPane().setLayout(groupLayout);
    }



    //修改数据
    public void updateData(UserVo oldUser) {
        if(judgeNull(Name)||judgeNull(StudentNumber)||judgeNull(Email)||judgeNull(Phone)||judgeNull(AccountNumber)||judgeNull(Password)) {
            //弹出信息框提示
            JOptionPane.showMessageDialog(null, "请将信息填写完整");
        }
        else {
            //取出填入的信息
            String name=Name.getText();
            Integer studentNumber= Integer.valueOf(StudentNumber.getText());
            int gender=Gender.getSelectedIndex();
            String accountNumber=AccountNumber.getText();
            String  email=Email.getText();
            String phone=Phone.getText();
            String duty=Duty.getText();
            //连接数据库进行修改
            UserController controller=new UserController();
            UserVo newUser=new UserVo(studentNumber,name ,accountNumber,gender,phone,email,duty);
            isSuccess(controller.updateUser(oldUser,newUser));
        }
    }

    //判断文本框为否为空，空则返回true
    public boolean judgeNull(JTextField textfield) {
        if("".equals(textfield.getText())||"".equals(textfield.getText().trim()))
            return true;
        return false;
    }

    //初始化未修改前的数据
    public void initData(UserVo user) {
       Name.setText(user.getName());
       StudentNumber.setText(String.valueOf(user.getStudentNumber()));
       Gender.setSelectedIndex(user.getGender());
       Email.setText(user.getPost());
       Phone.setText(user.getPhone());
       //Password.setText(user.getps);
        AccountNumber.setText(user.getAccountNumber());
        Duty.setText(user.getDuty());
    }


    //判断添加是否成功
    private void isSuccess(int i) {
        if(i==-1){
            JOptionPane.showMessageDialog(null,"修改失败");
        }else{
            JOptionPane.showMessageDialog(null,"修改成功");
        }
    }

}
