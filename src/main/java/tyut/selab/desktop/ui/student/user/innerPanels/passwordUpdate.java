package tyut.selab.desktop.ui.student.user.innerPanels;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.studentUtils;

import javax.swing.*;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class passwordUpdate extends JPanel {
    private JTextField oldPassword;
    private JTextField newPassword;
    private JTextField againPassword;
    public passwordUpdate(User user) {
        setBackground(new Color(255, 255, 255));
        setSize(1010,610);

        //设置标签和文本框
        JLabel oldPasswordText = new JLabel("请输入旧密码:");
        oldPasswordText.setFont(new Font("幼圆", Font.BOLD, 30));

        oldPassword = new JTextField();
        oldPassword.setFont(new Font("幼圆", Font.BOLD, 30));
        oldPassword.setColumns(10);

        JLabel newPasswordText = new JLabel("请输入新密码:");
        newPasswordText.setFont(new Font("幼圆", Font.BOLD, 30));

        newPassword = new JTextField();
        newPassword.setFont(new Font("幼圆", Font.BOLD, 30));
        newPassword.setColumns(10);

        JLabel againText = new JLabel("再次输入新密码:");
        againText.setFont(new Font("幼圆", Font.BOLD, 30));

        againPassword = new JTextField();
        againPassword.setFont(new Font("幼圆", Font.BOLD, 30));
        againPassword.setColumns(10);

        //确认按钮
        JButton SureButton = new JButton("确认");
        SureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(studentUtils.isNotNull(oldPassword)&&studentUtils.isNotNull(newPassword)&&studentUtils.isNotNull(againPassword)){
                    if(judgeRight(user)){
                        if(judgeSame()){
                            update(user);
                        }
                    }
                }
            }
        });
        SureButton.setFont(new Font("幼圆", Font.BOLD, 25));

        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(115)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(newPasswordText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(oldPasswordText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(85)
                                                .addComponent(againText)))
                                .addGap(40)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(oldPassword, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newPassword, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(againPassword, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(237, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                .addContainerGap(703, Short.MAX_VALUE)
                                .addComponent(SureButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addGap(200))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(148)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(oldPassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(oldPasswordText, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGap(60)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(newPasswordText, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newPassword, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(58)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(againText, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(againPassword, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGap(79)
                                .addComponent(SureButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(87, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
    }

    //进行修改操作
    private void update(User user){
        if(studentUtils.isNotNull(oldPassword)&&studentUtils.isNotNull(newPassword)&&studentUtils.isNotNull(againPassword)){
            //获取输入的密码
            String code=newPassword.getText();
            UserRegisterVo userVo=new UserRegisterVo(user.getStudentNumber(),user.getPassword(),user.getName(),user.getAccountNumber(),user.getGender(),user.getPhone(),user.getPost(),user.getRole().getDuty());
            //进行密码修改
            UserController userController=new UserController();
            if(studentUtils.isSuccess(userController.updateUserPassword(code,userVo))){
                JOptionPane.showMessageDialog(null,"修改成功");
            }else{
                JOptionPane.showMessageDialog(null,"修改失败");
            }
        }
    }

    //判断旧密码是否正确
    private boolean judgeRight(User user){
        String oldpassword=oldPassword.getText();
        if(oldpassword.equals(user.getPassword())){
            return true;
        }else {
            JOptionPane.showMessageDialog(null,"旧密码错误");
            return false;
        }
    }

    //判断输入两次内容是否相同
    private boolean judgeSame() {
        if(newPassword.getText().equals(againPassword.getText()))
            return true;
        else {
            JOptionPane.showMessageDialog(null,"两次输入内容不同");
            return false;
        }
    }
}
