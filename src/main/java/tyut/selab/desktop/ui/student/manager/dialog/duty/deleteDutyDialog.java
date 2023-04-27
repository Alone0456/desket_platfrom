package tyut.selab.desktop.ui.student.manager.dialog.duty;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.dialog.deleteSureDialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteDutyDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField Name;

    public deleteDutyDialog() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        //设置出现在屏幕中央
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        //设置标签与文本框
        JLabel printText = new JLabel("请输入该学生的姓名");
        printText.setFont(new Font("宋体", Font.PLAIN, 25));

        Name = new JTextField();
        Name.setColumns(10);

        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(31)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(printText, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Name, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(43)
                                .addComponent(printText, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(76, Short.MAX_VALUE))
        );
        contentPanel.setLayout(gl_contentPanel);

        { //按钮模块
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                //确认按钮
                JButton okButton = new JButton("确认");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(judgeNull()) {
                            if(SureDelete()) {
                                delete();
                            }
                        }
                        dispose();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                //取消按钮
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

    //判断输入是否为空
    private boolean judgeNull() {
        if("".equals(Name.getText())||"".equals(Name.getText().trim())) {
            JOptionPane.showMessageDialog(null, "输入不能为空");
            return false;
        }
        return true;
    }
    //再次确认是否注销
    private boolean SureDelete() {
        deleteSureDialog SureDelete=new deleteSureDialog();
        SureDelete.setVisible(true);
        SureDelete.setDefaultCloseOperation(HIDE_ON_CLOSE);
        return SureDelete.getSureDelete();
    }
    //执行删除操作
    private void delete() {
        UserController userController=new UserController();
        Role role=new Role();
        isSuccess(userController.deleteRole(role));
    }

    //判断是否删除成功
    private void isSuccess(int i) {
        if(i==-1){
            JOptionPane.showMessageDialog(null,"注销失败");
        }else{
            JOptionPane.showMessageDialog(null,"注销成功");
        }
    }
}
