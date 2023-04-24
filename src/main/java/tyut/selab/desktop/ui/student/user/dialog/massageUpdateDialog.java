package tyut.selab.desktop.ui.student.user.dialog;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class massageUpdateDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField Name;
    private JTextField Email;
    private JLabel SchoolNumber;
    private JTextField Phone;
    private JComboBox Gender;
    private JPanel buttonPane;
    private JTextField AccountNumber;
    UserVo oldUser=new UserVo();
    public massageUpdateDialog() {
        setTitle("修改界面");
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
        //可以修改的数据
        Name = new JTextField();
        Name.setFont(new Font("宋体", Font.PLAIN, 30));
        Name.setColumns(10);

        Email = new JTextField();
        Email.setFont(new Font("宋体", Font.PLAIN, 30));
        Email.setColumns(10);

        SchoolNumber = new JLabel();
        SchoolNumber.setFont(new Font("宋体", Font.PLAIN, 30));

        Phone = new JTextField("");
        Phone.setFont(new Font("宋体", Font.PLAIN, 30));

        Gender = new JComboBox();
        Gender.setFont(new Font("宋体", Font.PLAIN, 30));
        Gender.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));

        AccountNumber = new JTextField();
        AccountNumber.setFont(new Font("宋体", Font.PLAIN, 30));
        AccountNumber.setColumns(10);

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
                                                                .addComponent(SchoolNumber, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))))
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                                .addComponent(PhoneText)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(Phone))
                                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                                .addComponent(accountNumberText, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(AccountNumber, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(71, Short.MAX_VALUE))
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
                                        .addComponent(SchoolNumber, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
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
                                .addGap(135))
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
                        updateData();
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
    public void updateData() {
        if(judgeText(Name)||judgeText(Email)||judgeText(Phone)||judgeText(AccountNumber)) {
            //弹出信息框提示
            JOptionPane.showMessageDialog(null, "请将信息填写完整");
        }
        else {
            //取出填入的信息
            String name=Name.getText();
            int gender=Gender.getSelectedIndex();
            String email=Email.getText();
            String phone=Phone.getText();
            String accountNumber=AccountNumber.getText();

            //连接数据库进行修改
            UserController userController=new UserController();
            UserVo newUser=new UserVo(name,accountNumber,gender,phone,email);
            isSuccess(userController.updateUser(oldUser,newUser));
        }
    }

    //判断文本框为否为空，空则返回true
    public boolean judgeText(JTextField textfield) {
        if("".equals(textfield.getText())||"".equals(textfield.getText().trim()))
            return true;
        return false;
    }

    //初始化未修改前的数据
    public void initData() {
        //从数据库或者登录界面获取ID,并通过ID查询得到用户数据
        Name.setText(oldUser.getName());
        SchoolNumber.setText(String.valueOf(oldUser.getStudentNumber()));
        Gender.setSelectedItem(oldUser.getGender());
        Email.setText(oldUser.getPost());
        Phone.setText(oldUser.getPhone());
        AccountNumber.setText(oldUser.getAccountNumber());
    }

    private void isSuccess(int i) {
        if(i==-1){
            JOptionPane.showMessageDialog(null,"注销失败");
        }else{
            JOptionPane.showMessageDialog(null,"注销成功");
        }
    }
}
