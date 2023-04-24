package tyut.selab.desktop.ui.student.manager.dialog.students;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
public class updateWhoDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    JTextField studentNumber;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            updateWhoDialog dialog = new updateWhoDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public updateWhoDialog() {
        setBounds(100, 100, 474, 266);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setModal(true);

        //设置出现在屏幕中央
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        //设置标签和文本框
        JLabel updateText = new JLabel("请输入要修改学生的学号");
        updateText.setFont(new Font("宋体", Font.PLAIN, 24));

        studentNumber = new JTextField();
        studentNumber.setFont(new Font("宋体", Font.PLAIN, 24));
        studentNumber.setColumns(10);


        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(24)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(studentNumber, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(updateText, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
                                .addGap(34)
                                .addComponent(updateText, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(studentNumber, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        contentPanel.setLayout(gl_contentPanel);
        {//设置按钮模块
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                //确认按钮设置
                JButton okButton = new JButton("确认");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (judgeNull()) {
                            if(isExist()){
                                update(SelectUser());
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"找不到该用户");
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
    //判断输入是否为空
    private boolean judgeNull() {
        if("".equals(studentNumber.getText())||"".equals(studentNumber.getText().trim())) {
            JOptionPane.showMessageDialog(null, "输入不能为空");
            return false;
        }
        return true;
    }

    //判断该用户是否存在
    private boolean isExist(){
        Integer studentnumber= Integer.valueOf(studentNumber.getText());
        UserController userController=new UserController();
        if(userController.queryUserByStudentNumber(studentnumber).equals(null))
            return false;
            else{
                return true;
        }
    }

    //对该用户进行查找
    private UserVo SelectUser(){
        Integer studentnumber= Integer.valueOf(studentNumber.getText());
        UserController userController=new UserController();
        return userController.queryUserByStudentNumber(studentnumber);
    }

    //进入修改页面
    private void update(UserVo user){
        updateDialog Update=new updateDialog(user);
        Update.setVisible(true);
        Update.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}