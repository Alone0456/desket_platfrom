package tyut.selab.desktop.ui.student.manager.dialog.students.FrameAndPanels;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class namePanel extends JPanel {
    private JTextField textField;
    private boolean isRepaint=false;
    public namePanel(Object[][] obj) {
        //初始化标签，文本框和按钮
        JLabel nameLabel = new JLabel("请输入姓名");
        nameLabel.setFont(new Font("宋体", Font.PLAIN, 30));

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 30));
        textField.setColumns(10);

        JButton SureButton = new JButton("确认");
        SureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isNull()) {
                    SelectName(obj);
                }
            }
        });
        SureButton.setFont(new Font("宋体", Font.PLAIN, 20));

        //设置布局器
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(40)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLabel))
                                .addContainerGap(109, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(450, Short.MAX_VALUE)
                                .addComponent(SureButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addGap(36))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(68)
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addComponent(SureButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addGap(19))
        );
        setLayout(groupLayout);

    }

    //判断是否填空
    private boolean isNull() {
        String content=textField.getText();
        if("".equals(content)||"".equals(content.trim())) {
            JOptionPane.showMessageDialog(null, "请输入姓名");
            return false;
        }else{
            return true;
        }
    }

    //进行搜索
    private void SelectName(Object[][] obj) {
        String name=textField.getText();
        UserController userController = new UserController();
        UserVo user=userController.queryUserByStudentName(name);
        if(user==null){
            JOptionPane.showMessageDialog(null,"找不到该姓名");
        }else {
            obj = new Object[][]{{user.getStudentNumber(), user.getName(), user.getAccountNumber(), user.getGender(), user.getPhone(), user.getPost(), user.getDuty()}};
            this.isRepaint = true;
        }
    }

    //设置是否更新数据
    public boolean isUpdate(){
       return this.isRepaint;
    }
}
