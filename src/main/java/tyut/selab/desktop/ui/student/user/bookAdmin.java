package tyut.selab.desktop.ui.student.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class bookAdmin extends JFrame {

    private JPanel contentPane;
    private JTextField bookNumber;
    JTextArea bookName = new JTextArea();
    public bookAdmin() {
        setTitle("书籍管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 683, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel bookNumberText = new JLabel("已借阅书籍");
        bookNumberText.setFont(new Font("宋体", Font.PLAIN, 30));

        bookNumber = new JTextField();
        bookNumber.setFont(new Font("宋体", Font.PLAIN, 30));
        bookNumber.setColumns(10);
        bookNumber.setText(getBorrowNumber());
        initBorrowBook();

        JLabel bookNameText = new JLabel("书名");
        bookNameText.setFont(new Font("宋体", Font.PLAIN, 30));

        //设置布局器
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(73)
                                                .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(25)
                                                .addComponent(bookNumberText)))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(bookNumber, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bookName, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(62)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(bookNumberText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bookNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(47)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bookName, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(83, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }


    //查询已经借阅的书籍数量
    private String getBorrowNumber() {
        return "4";
    }

    //查询已经借阅的书籍名字
    public void initBorrowBook() {
        bookName.setText("《十万个为什么》，《好奇宝宝》");
    }
}
