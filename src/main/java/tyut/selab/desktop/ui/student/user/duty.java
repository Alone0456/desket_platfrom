package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class duty extends JFrame {
    private JPanel contentPane;
    Object obj[][];
    DefaultTableModel content=new DefaultTableModel(new Object[][] {

    },
            new String[] {
                    "姓名","登录时间","登录状态","职责"
            });
    private JTable table;
    public duty() {
        setTitle("职责管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 502, 517);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //设置按钮
        //查询按钮
        JButton selectButton = new JButton("查询");
        selectButton.setFont(new Font("宋体", Font.PLAIN, 24));
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Select();
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
                                        .addComponent(selectButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(18)
                                .addComponent(selectButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                .addGap(27)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
                                .addGap(32))
        );

        //表格设置
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

}
