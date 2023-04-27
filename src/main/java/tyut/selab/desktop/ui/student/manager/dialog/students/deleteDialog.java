package tyut.selab.desktop.ui.student.manager.dialog.students;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.dialog.deleteSureDialog;

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField schoolnumber;

    public deleteDialog() {
        setBounds(100, 100, 535, 340);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        //设置标签和文本框
        JLabel deleteText = new JLabel("请输入要注销学生的学号");
        deleteText.setFont(new Font("宋体", Font.PLAIN, 24));

        schoolnumber = new JTextField();
        schoolnumber.setFont(new Font("宋体", Font.PLAIN, 24));
        schoolnumber.setColumns(10);


        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(37)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(schoolnumber, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteText, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(100, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addContainerGap(68, Short.MAX_VALUE)
                                .addComponent(deleteText, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(schoolnumber, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(96))
        );
        contentPanel.setLayout(gl_contentPanel);
        {//设置按钮模块
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("确认");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(judgeNull()) {
                            //再次确认是否要删除
                            if(SureDelete()) {
                                //删除
                                delete();
                            }
                        }
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
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

    class booleanClass{
        private boolean SureDelete;

        public boolean getSureDelete() {
            return SureDelete;
        }

        public void setSureDelete(boolean sureDelete) {
            SureDelete = sureDelete;
        }

    }

    //判断输入是否为空
    private boolean judgeNull() {
        if("".equals(schoolnumber.getText())||"".equals(schoolnumber.getText().trim())) {
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

    //进行删除操作
    private void delete() {
        String schoolNumber=schoolnumber.getText();
        UserController userController=new UserController();
        isSuccess(userController.deleteUser(Integer.valueOf(schoolNumber)));
    }

    //检测注销成功或者失败
    private void isSuccess(int i) {
        if(i==-1){
            JOptionPane.showMessageDialog(null,"注销失败");
        }else{
            JOptionPane.showMessageDialog(null,"注销成功");
        }
    }
}



