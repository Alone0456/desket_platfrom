package tyut.selab.desktop.ui.student.manager.dialog.duty;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insertDutyDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField Name;
    private JComboBox Duty ;

    public insertDutyDialog() {
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

        //初始化两个文本框和输入框
        JLabel printText = new JLabel("请输入学生姓名");
        printText.setFont(new Font("宋体", Font.PLAIN, 25));

        Name = new JTextField();
        Name.setColumns(10);

        JLabel chooseText = new JLabel("选择职责");
        chooseText.setFont(new Font("宋体", Font.PLAIN, 25));

        Duty = new JComboBox();
        Duty.setFont(new Font("宋体", Font.PLAIN, 18));
        Duty.setModel(new DefaultComboBoxModel(new String[] {"用户", "管理员"}));

        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(23)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPanel.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(chooseText, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(Duty, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(Name, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(printText, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(105, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(27)
                                .addComponent(printText, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(27)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(Duty)
                                        .addComponent(chooseText, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        contentPanel.setLayout(gl_contentPanel);

        {
            //按钮模块
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                //确认按钮
                JButton okButton = new JButton("确认");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(judgeNull()) {
                            insert();}
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
                cancelButton.setActionCommand("cancle");
                buttonPane.add(cancelButton);
            }
        }
    }

    //进行添加操作
    private void insert() {
        //取出填入的信息
        UserController userController=new UserController();
        Role role=new Role();
        isSuccess(userController.insertRole(role));
        Object duty=Duty.getSelectedItem();
    }

    //判断输入是否为空
    private boolean judgeNull() {
        if("".equals(Name.getText())||"".equals(Name.getText().trim())) {
            JOptionPane.showMessageDialog(null, "输入不能为空");
            return false;
        }
        return true;
    }

    //判断是否添加成功
    private void isSuccess(int i) {
        if(i==-1){
            JOptionPane.showMessageDialog(null,"添加失败");
        }else{
            JOptionPane.showMessageDialog(null,"添加成功");
        }
    }
}
