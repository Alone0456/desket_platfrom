package tyut.selab.desktop.ui.student.manager;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.dialog.duty.deleteDutyDialog;
import tyut.selab.desktop.ui.student.manager.dialog.duty.insertDutyDialog;
import tyut.selab.desktop.ui.student.user.User;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JScrollPane;

public class dutyAdmin extends JFrame {

    private JPanel contentPane;
    Object obj[][];
    DefaultTableModel content=new DefaultTableModel(new Object[][] {

    },
            new String[] {
                    "姓名","登录时间","登录状态","职责"
            });
    private JTable table;

    public dutyAdmin() {
        setTitle("\u804C\u8D23\u7BA1\u7406");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 502, 517);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //设置三个按钮
        //查询按钮
        JButton selectButton = new JButton("查询");
        selectButton.setFont(new Font("宋体", Font.PLAIN, 24));
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Select();
            }
        });

        //增加按钮
        JButton insertButton = new JButton("添加");
        insertButton.setFont(new Font("宋体", Font.PLAIN, 24));
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert();
            }
        });

        //删除按钮
        JButton deleteButton = new JButton("删除");
        deleteButton.setFont(new Font("宋体", Font.PLAIN, 24));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        //设置布局器
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(selectButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                .addGap(29)
                                                .addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(31)
                                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(insertButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                        .addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
                                .addGap(32))
        );

        table = new JTable();
        table.setModel(content);
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);
    }

    //查询功能实现
    private String[][] Select() {
        UserController userController=new UserController();
        List<Role> list=userController.queryAllRole();
        //返回一个二位数组
        return null;
    }

    //添加功能实现
    private void insert() {
        insertDutyDialog insert=new insertDutyDialog();
        insert.setDefaultCloseOperation(HIDE_ON_CLOSE);
        insert.setVisible(true);
    }

    //进入删除页面
    private void delete() {
        deleteDutyDialog deleteDuty=new deleteDutyDialog();
        deleteDuty.setVisible(true);
        deleteDuty.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }


}
