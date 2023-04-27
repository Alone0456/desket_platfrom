package tyut.selab.desktop.ui.student.manager.innerPanels;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.studentUtils;
import tyut.selab.desktop.ui.student.manager.studentsAdmin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SureDeleteDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    public SureDeleteDialog(UserVo user,studentsAdmin students) {
        setTitle("提醒");
        setVisible(true);
        setDefaultCloseOperation(1);
        setBounds(100, 100, 435, 239);

        //设置出现在屏幕中央
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        //面板设置
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        //文本设置
        JLabel SureText = new JLabel("确定要注销该用户吗？");
        SureText.setFont(new Font("幼圆", Font.BOLD, 25));

        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(67)
                                .addComponent(SureText, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
                                .addContainerGap(52, Short.MAX_VALUE)
                                .addComponent(SureText, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addGap(46))
        );
        contentPanel.setLayout(gl_contentPanel);

        //按钮界面
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {//确认按钮
                JButton okButton = new JButton("确认");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        delete(user);
                        dispose();
                        students.AllSelect();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {//取消按钮
                JButton cancelButton = new JButton("取消");
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
    //判断是否查到该用户
    private boolean isSelect(UserVo user){
        if(user==null){
            JOptionPane.showMessageDialog(null,"找不到该用户");
            return false;
        }else{
            return true;
        }
    }

    //注销选中用户
    private void delete(UserVo user) {
        //先获取选中用户的信息
        UserController userController=new UserController();
        if(studentUtils.isSuccess(userController.deleteUser(user.getStudentNumber()))){
            JOptionPane.showMessageDialog(null,"注销成功");
        }else{
            JOptionPane.showMessageDialog(null,"注销失败");
        }
    }


}
