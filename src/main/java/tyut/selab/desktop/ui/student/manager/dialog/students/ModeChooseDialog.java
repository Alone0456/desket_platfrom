package tyut.selab.desktop.ui.student.manager.dialog.students;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.dialog.students.FrameAndPanels.SingleSelectFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ModeChooseDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public ModeChooseDialog() {
        //设置边界
        setBounds(100, 100, 472, 312);
        //设置父容器不可操作
        setModal(true);
        //设置出现在屏幕中央
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        //主面板设置
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JLabel chooseText = new JLabel("请选择查询模式");
        chooseText.setFont(new Font("宋体", Font.BOLD, 25));

        //设置俩按钮
        //全体查询按钮
        JButton AllButton = new JButton("全体查询");
        AllButton.setFont(new Font("宋体", Font.BOLD, 26));
        AllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                AllSelect();
            }
        });

        //单体查询按钮
        JButton SingleButton = new JButton("单个查询");
        SingleButton.setFont(new Font("宋体", Font.BOLD, 26));
        SingleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                showSingle();
            }
        });

        //设置布局器
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addGap(36)
                                .addComponent(AllButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addGap(62)
                                .addComponent(SingleButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(58))
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chooseText, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(229, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chooseText, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addGap(32)
                                .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(SingleButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AllButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(111, Short.MAX_VALUE))
        );
        contentPanel.setLayout(gl_contentPanel);

        {   //按钮栏面板
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
        }
    }



    //进入单体查询页面
    private void showSingle() {
        JFrame SingleSelect=new SingleSelectFrame();
        SingleSelect.setVisible(true);
        SingleSelect.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    //进行全体查询
    private void AllSelect() {
        UserController userController = new UserController();
        List<UserVo> list=userController.queryUser();
        //列表转化为二维数组

    }
}
