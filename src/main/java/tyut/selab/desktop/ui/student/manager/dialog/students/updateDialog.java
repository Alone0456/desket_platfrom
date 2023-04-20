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
    //填入框
    private JTextField Name;
    private JTextField Phone;
    private JTextField age;
    private JLabel ID;
    private JLabel schoolNumber;
    private JComboBox sex ;

    public updateDialog() {
        setTitle("修改界面");
        setBounds(100, 100, 549, 618);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        //设置固定标签
        JLabel nameText = new JLabel("名字：");
        nameText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel IDText = new JLabel("ID:");
        IDText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel sexText = new JLabel("性别:");
        sexText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel ageText = new JLabel("年龄:");
        ageText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel PhoneText = new JLabel("手机号:");
        PhoneText.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel schoolnumberText_1 = new JLabel("学号:");
        schoolnumberText_1.setFont(new Font("宋体", Font.PLAIN, 30));

        //ID和学号不可修改，是固定的所以用标签
        ID = new JLabel("");
        ID.setFont(new Font("宋体", Font.PLAIN, 30));
        schoolNumber = new JLabel();
        schoolNumber.setFont(new Font("宋体", Font.PLAIN, 30));

        //可以修改的数据
        Name = new JTextField();
        Name.setColumns(10);
        Phone = new JTextField();
        Phone.setColumns(10);
        age = new JTextField();
        age.setColumns(10);

        sex = new JComboBox();
        sex.setFont(new Font("宋体", Font.PLAIN, 30));
        sex.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));

        //对数据进行初始化
        initData();

        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(18)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(ageText)
                                                        .addComponent(nameText)
                                                        .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(IDText)
                                                                .addComponent(sexText)))
                                                .addGap(22))
                                        .addComponent(schoolnumberText_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addComponent(PhoneText)
                                                .addGap(18)))
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(age, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Phone, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                                        .addComponent(schoolNumber, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                                        .addComponent(sex, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addGap(10)
                                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(Name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                                        .addComponent(ID, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(39)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Name, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(13)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(ID, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IDText, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(sexText, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sex, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(ageText, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(age, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(7)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Phone, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(schoolnumberText_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(schoolNumber, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGap(143))
        );
        contentPanel.setLayout(gl_contentPanel);

        {  //设置按钮面板
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                //确认按钮
                JButton okButton = new JButton("确认");
                okButton.setActionCommand("确认");
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
                cancelButton.setActionCommand("取消");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(cancelButton);
            }
        }
    }


    //修改数据
    public void updateData() {
        if(judgeText(Name)||judgeText(age)||judgeText(Phone)) {
            //弹出信息框提示
            JOptionPane.showMessageDialog(null, "请将信息填写完整");
        }
        else {
            //取出填入的信息
            String name=Name.getText();
            String yearOld=age.getText();
            String telephone=Phone.getText();
            Object gender=new String();
            gender=sex.getSelectedItem();

            //连接数据库进行修改
            UserController controller=new UserController();
            UserVo oldUser=new UserVo();
            UserVo newUser=new UserVo();
            isSuccess(controller.updateUser(oldUser,newUser));
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
        Name.setText(getName());
        ID.setText(getName());
        sex.setSelectedItem(ID);
        age.setText(getName());
        Phone.setText(getName());
        schoolNumber.setText(getName());
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
