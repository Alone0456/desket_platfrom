package tyut.selab.desktop.ui.student.manager.dialog.students;

import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class insertDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField Name;
    private JTextField schoolNumber;
    private JTextField Email;
    private JTextField StudentNumber;
    private JTextField Phone;
    private JComboBox Gender;
    private JPanel buttonPane;
    private JTextField AccountNumber;
    private JTextField Password;
    private JTextField Duty;

    public insertDialog() {
        setTitle("添加界面");
        setBounds(100, 100, 558, 625);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocation(EXIT_ON_CLOSE, ABORT);

        //设置出现在屏幕中央
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        //设置固定标签
        JLabel nameText = new JLabel("名字:");
        nameText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel IDText = new JLabel("学号:");
        IDText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel sexText = new JLabel("性别:");
        sexText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel emailText = new JLabel("地址:");
        emailText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel PhoneText = new JLabel("手机号:");
        PhoneText.setFont(new Font("宋体", Font.PLAIN, 30));

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
        Gender.setModel(new DefaultComboBoxModel(new String[] {"女", "男"}));

        JLabel accountNumberText = new JLabel("账户:");
        accountNumberText.setFont(new Font("宋体", Font.PLAIN, 30));

        AccountNumber = new JTextField();
        AccountNumber.setFont(new Font("宋体", Font.PLAIN, 30));
        AccountNumber.setColumns(10);

        JLabel passwordText = new JLabel("密码:");
        passwordText.setFont(new Font("宋体", Font.PLAIN, 30));

        Password = new JTextField();
        Password.setFont(new Font("宋体", Font.PLAIN, 30));
        Password.setColumns(10);

        JLabel dutyText = new JLabel("职责:");
        dutyText.setFont(new Font("宋体", Font.PLAIN, 30));

        Duty = new JTextField();
        Duty.setFont(new Font("宋体", Font.PLAIN, 30));
        Duty.setColumns(10);

        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(36)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(sexText)
                                                        .addComponent(IDText)
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
                                        .addComponent(IDText, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Gender, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sexText, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
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
                        insertData();
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

    //信息存入数据库
    private void insertData() {
        if(judgeText(Name)||judgeText(Email)||judgeText(Phone)||judgeText(StudentNumber)||judgeText(Password)||judgeText(StudentNumber)||judgeText(AccountNumber)||judgeText(Duty)) {
            //弹出信息框提示
            JOptionPane.showMessageDialog(null, "请将信息填写完整");
        }else {
            //获取填入的信息
            String name=Name.getText();
            Integer studentNumber= Integer.valueOf(StudentNumber.getText());
            String accountNumber=AccountNumber.getText();
            String email=Email.getText();
            String phone=Phone.getText();
            String duty=Duty.getText();
            Integer password= Integer.valueOf(Password.getText());
            int gender=Gender.getSelectedIndex();
            //添加进入数据库
            UserController userController=new UserController();
            UserRegisterVo newUser=new UserRegisterVo(studentNumber,password,name,accountNumber,gender,phone,email,duty);
            isSuccess(userController.insertUser(newUser));
        }
    }

    //判断文本框为否为空，空则返回true
    private boolean judgeText(JTextField textfield) {
        if("".equals(textfield.getText())||"".equals(textfield.getText().trim()))
            return true;
        return false;
    }

    //检测添加是否成功
    private void isSuccess(int i) {
        if(i==-1){
            JOptionPane.showMessageDialog(null,"添加失败");
        }else{
            JOptionPane.showMessageDialog(null,"添加成功");
        }
    }
}
