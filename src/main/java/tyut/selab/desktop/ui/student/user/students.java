package tyut.selab.desktop.ui.student.user;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.student.manager.studentUtils;

import java.awt.*;
import java.awt.Dialog.ModalityType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
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

public class students extends JPanel {

    private JTable table;
    private  Object obj[][];
    private JButton NameButton;
    private JButton studentNumberButton;
    private Image background;
    private boolean isName=true;

    //对表头内容设置
    private DefaultTableModel content=new DefaultTableModel(obj
            ,
            new String[] {
                    "学号", "姓名", "账户", "性别","电话","邮箱","职责"
            });
    private JTextField textField;

    public students() {
        setBackground(new Color(255, 255, 255));
        setSize(1010,650);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        //设置表格
        table = new JTable();
        table.setModel(content);
        table.getTableHeader().setReorderingAllowed(false);
        table.setOpaque(false);

        //设置布局器
        JScrollPane scrollPane = new JScrollPane();

        textField = new JTextField();
        textField.setColumns(10);

        JLabel Text = new JLabel("按照");
        Text.setFont(new Font("幼圆", Font.BOLD, 20));

        //初始化表信息
        AllSelect();

        //查找按钮
        JButton SelectButton = new JButton("查找");
        SelectButton.setFont(new Font("宋体", Font.PLAIN, 15));
        SelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Select();
            }
        });

        //姓名按钮
        NameButton = new JButton("姓名");
        NameButton.setBackground(Color.gray);
        NameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NameButton.setBackground(Color.gray);
                studentNumberButton.setBackground(new Color(255, 255, 255));
                ClickName();
            }
        });

        //学号按钮
        studentNumberButton = new JButton("学号");
        studentNumberButton.setBackground(new Color(255, 255, 255));
        studentNumberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentNumberButton.setBackground(Color.gray);
                NameButton.setBackground(new Color(255, 255, 255));
                ClickstudentNumber();

            }
        });
        background = new ImageIcon(Massage.class.getResource("pngs/background.png")).getImage();

        //设置布局器
        GroupLayout gl_contentPane = new GroupLayout(this);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 919, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(23)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(10)
                                                                .addComponent(SelectButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(14)
                                                                .addComponent(Text, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(NameButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(10)
                                                                .addComponent(studentNumberButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED, 699, Short.MAX_VALUE)))))
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(studentNumberButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NameButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Text, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addComponent(SelectButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
                                .addGap(68))
        );

        //设置表头
        scrollPane.setViewportView(table);
        this.setLayout(gl_contentPane);

    }

    //初始化表格数据
    private void AllSelect(){
        UserController userController=new UserController();
        obj=userController.queryUser().stream().map(p->new Object[]{p.getStudentNumber(),p.getName(),p.getAccountNumber(),p.getGender()==0?"男":"女",p.getPhone(),p.getPost(),p.getDuty()}).toArray(Object[][]::new);
        content=new DefaultTableModel(obj
                ,
                new String[] {
                        "学号", "姓名", "账户", "性别","电话","邮箱","职责"
                });
        table.setModel(content);
        table.repaint();
    }

    //进行查找
    private void Select() {
        UserController userController=new UserController();
        //没有输入则全部查询
        if ("".equals(textField.getText())) {
            AllSelect();
        } else {
            if (isName) {
                String name = textField.getText();
                UserVo user=userController.queryUserByStudentName(name);
                if(studentUtils.isSelect(user)) {
                    String gender = user.getGender() == 0 ? "男" : "女";
                    obj = new Object[][]{{user.getStudentNumber(), user.getName(), user.getAccountNumber(), gender, user.getPhone(), user.getPost(), user.getDuty()}};
                    content = new DefaultTableModel(obj
                            ,
                            new String[]{
                                    "学号", "姓名", "账户", "性别", "电话", "邮箱", "职责"
                            });
                    table.setModel(content);
                    table.repaint();
                }
            } else {
                if (studentUtils.isNumber(textField)) {
                    Integer studentNumber = Integer.parseInt(textField.getText());
                    UserVo user = userController.queryUserByStudentNumber(studentNumber);
                    if (studentUtils.isSelect(user)) {
                        String gender = user.getGender() == 0 ? "男" : "女";
                        obj = new Object[][]{{user.getStudentNumber(), user.getName(), user.getAccountNumber(), gender, user.getPhone(), user.getPost(), user.getDuty()}};
                        content = new DefaultTableModel(obj
                                ,
                                new String[]{
                                        "学号", "姓名", "账户", "性别", "电话", "邮箱", "职责"
                                });
                        table.setModel(content);
                        table.repaint();
                    }
                }
            }
        }
    }

    //对姓名还是学号的选择
    private boolean ClickName(){
        isName=true;
        return isName;
    }
    private boolean ClickstudentNumber(){
        isName=false;
        return  isName;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0,getWidth(),getHeight(),this);
    }
}
