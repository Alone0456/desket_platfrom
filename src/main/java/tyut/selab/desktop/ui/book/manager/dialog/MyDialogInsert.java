package tyut.selab.desktop.ui.book.manager.dialog;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class MyDialogInsert extends JDialog {
    UserController userController = new UserController();
    BookMessageController bookMessageController = new BookMessageController();

            public MyDialogInsert(Vector<Vector> dataV, Vector titlesV, DefaultTableModel defaultTableModel,JTable jt) {
                ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "\\src\\ManagerGui\\ddot.png");
            public MyDialogInsert(Vector<Vector> dataV, Vector titlesV, DefaultTableModel defaultTableModel) {
                ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
                setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

                setTitle("增加书籍");
                setModal(true);
                setSize(800, 500);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setLocationRelativeTo(null);

                JLabel jlName = new JLabel("书籍名称:", JLabel.CENTER);
                jlName.setFont(new Font("微软黑体", Font.BOLD, 20));
                jlName.setBounds(150, 10, 200, 80);
                JTextField jlNameContent = new JTextField();
                jlNameContent.setBounds(360, 30, 200, 40);
                jlNameContent.setFont(new Font("微软黑体", Font.PLAIN, 20));
                jlNameContent.setHorizontalAlignment(JTextField.CENTER);

                JLabel jlOwner = new JLabel("书籍拥有者:", JLabel.CENTER);
                jlOwner.setFont(new Font("微软黑体", Font.BOLD, 20));
                jlOwner.setBounds(150, 100, 200, 80);
                JTextField jlOwnerConter = new JTextField();
                jlOwnerConter.setBounds(360, 120, 200, 40);
                jlOwnerConter.setFont(new Font("微软黑体", Font.PLAIN, 20));
                jlOwnerConter.setHorizontalAlignment(JTextField.CENTER);

                JLabel jlOwnerStudnetId = new JLabel("拥有者学号:", JLabel.CENTER);
                jlOwnerStudnetId.setFont(new Font("微软黑体", Font.BOLD, 20));
                jlOwnerStudnetId.setBounds(150, 190, 200, 80);
                JTextField jlOwnerStudentIdConter = new JTextField();
                jlOwnerStudentIdConter.setBounds(360, 210, 200, 40);
                jlOwnerStudentIdConter.setFont(new Font("微软黑体", Font.PLAIN, 20));
                jlOwnerStudentIdConter.setHorizontalAlignment(JTextField.CENTER);

                JLabel jlPrice = new JLabel("书籍价格:", JLabel.CENTER);
                jlPrice.setFont(new Font("微软黑体", Font.BOLD, 20));
                jlPrice.setBounds(150, 280, 200, 80);
                JTextField jlPriceConter = new JTextField();
                jlPriceConter.setBounds(360, 300, 200, 40);
                jlPriceConter.setFont(new Font("微软黑体", Font.PLAIN, 20));
                jlPriceConter.setHorizontalAlignment(JTextField.CENTER);

                JButton jb = new JButton("确定添加");
                jb.setBounds(150, 380, 500, 60);
                jb.setFont(new Font("微软雅黑", Font.BOLD, 15));
                jb.setBackground(Color.PINK);
                jb.setForeground(Color.WHITE);
                jb.setFocusPainted(false);
                JPanel jp = new JPanel();
                jp.setBounds(0, 0, 800, 500);
                jp.setBackground(Color.WHITE);
                jp.setLayout(null);
                add(jp);
                jp.add(jlName);
                jp.add(jlNameContent);
                jp.add(jlOwner);
                jp.add(jlOwnerConter);
                jp.add(jlOwnerStudnetId);
                jp.add(jlOwnerStudentIdConter);
                jp.add(jlPrice);
                jp.add(jlPriceConter);
                jp.add(jb);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (jlNameContent.getText().trim().equals("") || jlOwnerStudentIdConter.getText().trim().equals("") || jlOwnerConter.getText().trim().equals("") || jlPriceConter.getText().trim().equals("")) {
                            JOptionPane jOptionPane = new JOptionPane();
                            JOptionPane.showMessageDialog(null, "书籍信息不能为空", "警告框", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Vector vector = new Vector();
                            vector.add(jlNameContent.getText().trim());
                            vector.add(jlOwnerConter.getText().trim());
                            vector.add(jlOwnerStudentIdConter.getText().trim());
                            vector.add(jlPrice.getText().trim());
                            vector.add(jlPriceConter.getText().trim());
                            vector.add("未借出");
                            vector.add("");
                            vector.add("");
                            vector.add("");
                            dataV.add(vector);
                            BookVo bookVo = new BookVo();
                            bookVo.setBookName(jlNameContent.getText());
                            bookVo.setBookPrice(Double.valueOf(jlPriceConter.getText()));
                            UserVo userVo = userController.queryUserByStudentNumber(Integer.valueOf(jlOwnerStudentIdConter.getText()));
                            bookVo.setBookUserVo(userVo);
                            bookVo.setBookStatus(Book.LENDABLE);
                            try {
                                System.out.println(bookMessageController + "=======");
                                bookMessageController.insertBook(bookVo);
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                            defaultTableModel.setDataVector(dataV, titlesV);
                            setVisible(false);
                        }
                    }
                });
            }
        }