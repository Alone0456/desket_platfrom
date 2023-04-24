package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.ui.student.manager.dialog.students.ModeChooseDialog;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class students extends JFrame {

    private JPanel contentPane;
    private JTable table;
    Object[][] obj;
    private boolean isRepaint=false;
    DefaultTableModel content=new DefaultTableModel(	obj

    ,
            new String[] {
                    "学号", "姓名", "账户", "性别","电话","邮箱","职责"
            });

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    students frame = new students();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public students() {
        setTitle("成员信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 765, 783);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //查询按钮
        JButton selectButton = new JButton("查询");
        selectButton.setFont(new Font("宋体", Font.PLAIN, 20));
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSelect();
            }
        });

        //设置布局器
        JScrollPane scrollPane = new JScrollPane();

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(22)
                                                .addComponent(selectButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(21)
                                .addComponent(selectButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
                                .addGap(65))
        );

        //设置表格
        table = new JTable();
        table.setModel(content);
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);
    }

    //进入查询页面
    private void showSelect() {
        ModeChooseDialog Modechoose=new ModeChooseDialog(obj);
        Modechoose.setVisible(true);
        Modechoose.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.isRepaint=Modechoose.isUpdate();
    }

}
