package tyut.selab.desktop.ui.student.user.dialog;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.user.User;

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
    private JTextField codeText;
    private JTextField codeagainText;
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
        JLabel Text1 = new JLabel("请输入修改后的密码");
        Text1.setFont(new Font("宋体", Font.PLAIN, 25));
        JLabel Text2 = new JLabel("请确认密码");
        Text2.setFont(new Font("宋体", Font.PLAIN, 25));

        codeText = new JTextField();
        codeText.setFont(new Font("宋体", Font.PLAIN, 20));
        codeText.setColumns(10);

        codeagainText = new JTextField();
        codeagainText.setFont(new Font("宋体", Font.PLAIN, 20));
        codeagainText.setColumns(10);

        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(28)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(codeagainText, Alignment.LEADING)
                                        .addGroup(Alignment.LEADING, gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(codeText, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                                .addComponent(Text1)
                                                .addComponent(Text2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(247, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(31)
                                .addComponent(Text1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(codeText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(58)
                                .addComponent(Text2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(codeagainText, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(351, Short.MAX_VALUE))
        );
        contentPanel.setLayout(gl_contentPanel);

        {
            //按钮面板设置
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

            //设置布局器
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                //ok按钮初始化
                JButton okButton = new JButton("\u786E\u8BA4");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //检测输入是否为空
                        if(judgeNull()) {
                            //判断输入是否相同
                            if(judgeSame()) {
                                updatedata();
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

    //判断输入是否为空
    private boolean judgeNull() {
        if("".equals(codeText.getText())||"".equals(codeagainText.getText())||"".equals(codeText.getText().trim())||"".equals(codeagainText.getText().trim())) {
            JOptionPane.showMessageDialog(null, "输入不能为空");
            return false;
        }
        return true;
    }
    //判断输入两次内容是否相同
    private boolean judgeSame() {
        if(codeText.getText().equals(codeagainText.getText()))
            return true;
        else {
            JOptionPane.showMessageDialog(null,"两次输入内容不同");
            return false;
        }
    }
    private void updatedata() {
        //获取输入的密码
        String code=codeText.getText();
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
