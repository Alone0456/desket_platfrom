package tyut.selab.desktop.ui.student.user.dialog;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class codeUpdateDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField newPassword;
    private JTextField againPassword;
    private JTextField oldPassword;

    public codeUpdateDialog() {
        setTitle("\u5BC6\u7801\u4FEE\u6539");
        setBounds(100, 100, 634, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        //设置出现在屏幕中央
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        //文本框设置
        JLabel newPasswordText = new JLabel("请输入修改后的密码");
        newPasswordText.setFont(new Font("宋体", Font.PLAIN, 25));
        JLabel againPasswordText = new JLabel("请确认密码");
        againPasswordText.setFont(new Font("宋体", Font.PLAIN, 25));
        JLabel oldPasswordText = new JLabel("请输入旧密码");
        oldPasswordText.setFont(new Font("宋体", Font.PLAIN, 25));

        newPassword = new JTextField();
        newPassword.setFont(new Font("宋体", Font.PLAIN, 20));
        newPassword.setColumns(10);

        againPassword = new JTextField();
        againPassword.setFont(new Font("宋体", Font.PLAIN, 20));
        againPassword.setColumns(10);

        oldPassword = new JTextField();
        oldPassword.setFont(new Font("宋体", Font.PLAIN, 20));
        oldPassword.setColumns(10);
        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
                                .addGap(25)
                                .addComponent(againPasswordText, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(433, Short.MAX_VALUE))
                        .addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
                                .addGap(20)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(againPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                        .addComponent(newPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addComponent(oldPasswordText, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE))
                                        .addComponent(newPasswordText)
                                        .addComponent(oldPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                                .addGap(255))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(42)
                                .addComponent(oldPasswordText, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(oldPassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(newPasswordText, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(newPassword, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(againPasswordText, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(againPassword, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))
        );
        contentPanel.setLayout(gl_contentPanel);

        {
            //按钮面板设置
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

            //设置布局器
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                //设置确认按钮
                JButton okButton = new JButton("\u786E\u8BA4");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(judgeNull()) {//检测输入是否为空
                            if (judgeRight()) {//再判断旧密码是否正确
                                if (judgeSame()) { //判断两次输入是否相同
                                    updatedata();
                                }
                            }
                        }
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                //取消按钮初始化
                JButton cancelButton = new JButton("\u53D6\u6D88");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    //判断旧密码是否正确
    private boolean judgeRight(){
        //获取当前账号对象
        User user=new User();
        String oldpassword=oldPassword.getText();
        if(oldpassword.equals(user.getPassword())){
            return true;
        }
        return false;
    }
    //判断输入是否为空
    private boolean judgeNull() {
        if("".equals(newPassword.getText())||"".equals(againPassword.getText())||"".equals(newPassword.getText().trim())||"".equals(againPassword.getText().trim())) {
            JOptionPane.showMessageDialog(null, "输入不能为空");
            return false;
        }
        return true;
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
    private void updatedata() {
        //获取输入的密码
        String code=newPassword.getText();
        UserVo userVo=new UserVo();
        //进行密码修改
        UserController userController=new UserController();
        isSuccess(userController.updateUserPassword(code,userVo));
    }

    private void isSuccess(int i) {
        if(i==-1){
            JOptionPane.showMessageDialog(null,"修改失败");
        }else{
            JOptionPane.showMessageDialog(null,"修改成功");
        }
    }
}
