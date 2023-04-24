package tyut.selab.desktop.ui.student.manager;

import tyut.selab.desktop.ui.student.manager.dialog.students.*;

import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.Dialog.ModalityType.APPLICATION_MODAL;

public class studentsAdmin extends JFrame {

    private JPanel contentPane;
    private JTable table;
    Object obj[][];
    //对表头内容设置
    DefaultTableModel content=new DefaultTableModel(obj
    ,
            new String[] {
                    "学号", "姓名", "账户", "性别","电话","邮箱","职责"
            });
    //是否重置表格内容
    private boolean isRepaint=false;

    public studentsAdmin() {
        setTitle("成员信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 765, 783);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //设置表格
        table = new JTable();
        table.setModel(content);
        table.getTableHeader().setReorderingAllowed(false);

        //设置四个按钮
        //修改按钮
        JButton updatebutton = new JButton("修改");
        updatebutton.setFont(new Font("宋体", Font.PLAIN, 20));
        updatebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showUpdate();
            }
        });

        //注销按钮
        JButton deletebutton = new JButton("注销");
        deletebutton.setFont(new Font("宋体", Font.PLAIN, 20));
        deletebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteMassage();
            }
        });

        //查询按钮
        JButton selectButton = new JButton("查询");
        selectButton.setFont(new Font("宋体", Font.PLAIN, 20));
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSelect();
            }
        });

        //添加按钮
        JButton insertButton = new JButton("添加");
        insertButton.setFont(new Font("宋体", Font.PLAIN, 20));
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showInsert();
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
                                                .addComponent(selectButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(updatebutton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(deletebutton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(21)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(selectButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(updatebutton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deletebutton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
                                .addGap(65))
        );

        //设置表头
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);
    }

    //进入查询页面
    private void showSelect() {
        ModeChooseDialog modechooseDialog=new ModeChooseDialog(obj);
        modechooseDialog.setVisible(true);
        modechooseDialog.setDefaultCloseOperation(HIDE_ON_CLOSE);
        if(modechooseDialog.isUpdate()){
            content=new DefaultTableModel(obj
                    ,
                    new String[] {
                            "学号", "姓名", "账户", "性别","电话","邮箱","职责"
                    });
            table.setModel(content);
        }
    }

    //进入修改页面
    private void showUpdate() {
        updateWhoDialog updatedialog=new updateWhoDialog();
        updatedialog.setVisible(true);
        updatedialog.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    //进入添加页面
    private void showInsert() {
        insertDialog addDialog=new insertDialog();
        addDialog.setVisible(true);
        addDialog.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    //删除信息事件
    public void deleteMassage() {
        deleteDialog delete=new deleteDialog();
        delete.setVisible(true);
        delete.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}
