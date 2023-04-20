package tyut.selab.desktop.ui.student.manager.dialog.students.FrameAndPanels;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IDPanel extends JPanel {
    private JTextField textField;
    public IDPanel() {
        //初始化标签，文本框和按钮
        JLabel schoolLabel = new JLabel("请输入学号");
        schoolLabel.setFont(new Font("宋体", Font.PLAIN, 30));

        textField = new JTextField();
        textField.setFont(new Font("宋体", Font.PLAIN, 30));
        textField.setColumns(10);

        JButton SureButton = new JButton("确认");
        SureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isNull();
                SelectSchoolnumber();
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
                                        .addComponent(schoolLabel))
                                .addContainerGap(108, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(438, Short.MAX_VALUE)
                                .addComponent(SureButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addGap(36))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(68)
                                .addComponent(schoolLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                                .addComponent(SureButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addGap(19))
        );
        setLayout(groupLayout);

    }
    //判断是否填入为空
    private boolean isNull() {
        String content=textField.getText();
        if("".equals(content)||"".equals(content.trim())) {
            JOptionPane.showMessageDialog(null, "请输入学号");
            return false;
        }else {
            return true;
        }
    }
    //进行搜索
    private String[] SelectSchoolnumber() {
        String content=textField.getText();
        int ID=Integer.parseInt(content);
        UserController userController = new UserController();
        UserVo user=userController.queryUserByStudentNumber(ID);
        //返回一维数组
        return null;
    }

}
