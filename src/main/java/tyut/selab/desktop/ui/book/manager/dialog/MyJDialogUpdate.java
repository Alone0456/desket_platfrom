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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class MyJDialogUpdate extends JDialog {
    BookMessageController bookMessageController = new BookMessageController();
    UserController userController = new UserController();
            public MyJDialogUpdate(int updateSelectColmn, Vector<Vector> dataV, Vector titlesV, JTable jt, DefaultTableModel defaultTableModel) {
                ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "\\src\\ManagerGui\\ddot.png");
                setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                setTitle("修改书籍信息");
                setModal(true);
                setSize(800, 500);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);    // 关闭后销毁对话框
                setLocationRelativeTo(null);

                // 修改已借阅书籍的面板 所需组件
                JLabel jlName = new JLabel("书籍名称:",JLabel.CENTER);
                jlName.setBounds(190,25,100,30);
                jlName.setFont(new Font("微软黑体",Font.BOLD,15));
                JLabel jlNameContent = new JLabel((String) dataV.get(updateSelectColmn).get(0),JLabel.CENTER);
                jlNameContent.setBounds(300,25,300,30);
                jlNameContent.setFont(new Font("微软黑体",Font.PLAIN,15));

                JLabel jlOwner = new JLabel("书籍拥有者:",JLabel.CENTER);
                jlOwner.setBounds(190,65,100,30);
                jlOwner.setFont((new Font("微软黑体",Font.BOLD,15)));
                JLabel jlOwnerConter = new JLabel((String) dataV.get(updateSelectColmn).get(1),JLabel.CENTER);
                jlOwnerConter.setBounds(300,65,300,30);
                jlOwnerConter.setFont(new Font("微软黑体",Font.PLAIN,15));

                JLabel jlOwnerStudentid = new JLabel("拥有者学号:",JLabel.CENTER);
                jlOwnerStudentid.setBounds(190,105,100,30);
                jlOwnerStudentid.setFont(new Font("微软黑体",Font.BOLD,15));
                JLabel jlOwnerStudentIdConter = new JLabel( dataV.get(updateSelectColmn).get(2).toString(),JLabel.CENTER);
                jlOwnerStudentIdConter.setBounds(300,105,300,30);
                jlOwnerStudentIdConter.setFont(new Font("微软黑体",Font.PLAIN,15));

                JLabel jlPrice = new JLabel("书籍价格:",JLabel.CENTER);
                jlPrice.setBounds(190,155,100,30);
                jlPrice.setFont(new Font("微软黑体",Font.BOLD,15));
                JTextField jlPriceConter = new JTextField( dataV.get(updateSelectColmn).get(3).toString());
                jlPriceConter.setHorizontalAlignment(JTextField.CENTER);
                jlPriceConter.setBounds(300,155,300,30);
                jlPriceConter.setFont(new Font("微软黑体",Font.PLAIN,15));

                JLabel jlStatus = new JLabel("书籍状态:",JLabel.CENTER);
                jlStatus.setBounds(190,195,100,30);
                jlStatus.setFont(new Font("微软黑体",Font.BOLD,15));
                JLabel jLabel = new JLabel((String) dataV.get(updateSelectColmn).get(4),JLabel.CENTER);
                jLabel.setBounds(300,195,300,30);
                jLabel.setFont(new Font("微软黑体",Font.PLAIN,15));

                JLabel jlBorrower = new JLabel("借阅人:",JLabel.CENTER);
                jlBorrower.setBounds(190,235,100,30);
                jlBorrower.setFont(new Font("微软黑体",Font.BOLD,15));
                JTextField jlBorrowerConter = new JTextField((String) dataV.get(updateSelectColmn).get(5));
                jlBorrowerConter.setHorizontalAlignment(JTextField.CENTER);
                jlBorrowerConter.setBounds(300,235,300,30);
                jlBorrowerConter.setFont(new Font("微软黑体",Font.PLAIN,15));

                JLabel jlBorrowerStudentId = new JLabel("借阅者学号:",JLabel.CENTER);
                jlBorrowerStudentId.setBounds(190,235,100,30);
                jlBorrowerStudentId.setFont(new Font("微软黑体",Font.BOLD,15));
                JTextField jlBorrowerStudentIdConter = new JTextField((String) dataV.get(updateSelectColmn).get(5));
                jlBorrowerStudentIdConter.setHorizontalAlignment(JTextField.CENTER);
                jlBorrowerStudentIdConter.setBounds(300,235,300,30);
                jlBorrowerStudentIdConter.setFont(new Font("微软黑体",Font.PLAIN,15));

                JLabel jlBorrowTime = new JLabel("借出时间:",JLabel.CENTER);
                jlBorrowTime.setBounds(190,275,100,30);
                jlBorrowTime.setFont(new Font("微软黑体",Font.BOLD,15));
                JLabel jlBorrowTimeConter = new JLabel(dataV.get(updateSelectColmn).get(6).toString(),JLabel.CENTER);
                jlBorrowTimeConter.setBounds(300,275,300,30);
                jlBorrowTimeConter.setFont(new Font("微软黑体",Font.PLAIN,15));

                JLabel jlReturnTime = new JLabel("还书时间:",JLabel.CENTER);
                jlReturnTime.setBounds(190,315,100,30);
                jlReturnTime.setFont(new Font("微软黑体",Font.BOLD,15));
                JTextField jlReturnTimeConter = new JTextField(dataV.get(updateSelectColmn).get(7).toString()+"(请使用yyyy-MM-dd HH:mm:ss 格式)");
                jlReturnTimeConter.setHorizontalAlignment(JTextField.CENTER);
                jlReturnTimeConter.setBounds(300,315,300,30);
                jlReturnTimeConter.setFont(new Font("微软黑体",Font.PLAIN,15));

                JButton jb = new JButton("确认修改");
                jb.setFont(new Font("微软黑体",Font.BOLD,15));
                jb.setBounds(250,380,300,40);
                jb.setBackground(Color.PINK);
                jb.setForeground(Color.WHITE);
                jb.setFocusPainted(false);

                //修改未借出书籍的面板 所需组件

                JLabel jlName1 = new JLabel("书籍名称:",JLabel.CENTER);
                jlName1.setBounds(150,30,200,40);
                jlName1.setFont(new Font("微软黑体",Font.BOLD,20));
                JLabel jlNameContent1 = new JLabel((String) dataV.get(updateSelectColmn).get(0),JLabel.CENTER);
                jlNameContent1.setBounds(260,30,400,40);
                jlNameContent1.setFont(new Font("微软黑体",Font.BOLD,20));

                JLabel jlOwner1 = new JLabel("书籍拥有者:",JLabel.CENTER);
                jlOwner1.setBounds(150,85,200,40);
                jlOwner1.setFont(new Font("微软黑体",Font.BOLD,20));
                JLabel jlOwnerConter1 = new JLabel((String) dataV.get(updateSelectColmn).get(1),JLabel.CENTER);
                jlOwnerConter1.setBounds(260,85,400,40);
                jlOwnerConter1.setFont(new Font("微软黑体",Font.BOLD,20));

                JLabel jlOwnerStudentid1 = new JLabel("拥有者学号:",JLabel.CENTER);
                jlOwnerStudentid1.setBounds(150,140,200,40);
                jlOwnerStudentid1.setFont(new Font("微软黑体",Font.BOLD,20));
                JLabel jlOwnerStudentIdConter1 = new JLabel( dataV.get(updateSelectColmn).get(2).toString(),JLabel.CENTER);
                jlOwnerStudentIdConter1.setBounds(260,140,400,40);
                jlOwnerStudentIdConter1.setFont(new Font("微软黑体",Font.BOLD,20));

                JLabel jlPrice1 = new JLabel("书籍价格:",JLabel.CENTER);
                jlPrice1.setBounds(150,195,200,40);
                jlPrice1.setFont(new Font("微软黑体",Font.BOLD,20));
                JTextField jlPriceConter1 = new JTextField( dataV.get(updateSelectColmn).get(3).toString());
                jlPriceConter1.setHorizontalAlignment(JTextField.CENTER);
                jlPriceConter1.setBounds(360,195,200,40);
                jlPriceConter1.setFont(new Font("微软黑体",Font.BOLD,20));

                JLabel jlStatus1 = new JLabel("书籍状态:",JLabel.CENTER);
                jlStatus1.setBounds(150,250,200,40);
                jlStatus1.setFont(new Font("微软黑体",Font.BOLD,20));
                JLabel jLabel1 = new JLabel((String) dataV.get(updateSelectColmn).get(4),JLabel.CENTER);
                jLabel1.setBounds(260,250,400,40);
                jLabel1.setFont(new Font("微软黑体",Font.PLAIN,20));

                JButton jb1 = new JButton("确认修改");
                jb1.setFont(new Font("微软黑体",Font.BOLD,15));
                jb1.setBounds(250,380,300,40);
                jb1.setBackground(Color.PINK);
                jb1.setForeground(Color.WHITE);
                jb1.setFocusPainted(false);

                // 两个面板的建立

                JPanel jplended = new JPanel();
                jplended.setBounds(0,0,800,500);
                jplended.setBackground(Color.WHITE);
                jplended.setLayout(null);

                JPanel jplendable = new JPanel();
                jplendable.setBounds(0,0,800,500);
                jplendable.setBackground(Color.WHITE);
                jplendable.setLayout(null);

                // 往已借出书籍面板添加组件
                jplended.add(jb);
                jplended.add(jlName);
                jplended.add(jlNameContent);
                jplended.add(jlOwner);
                jplended.add(jlOwnerConter);
                jplended.add(jlOwnerStudentid);
                jplended.add(jlOwnerStudentIdConter);
                jplended.add(jlPrice);
                jplended.add(jlPriceConter);
                jplended.add(jlStatus);
                //    jplended.add(jComboBox);
                jplended.add(jLabel); // add
                jplended.add(jlBorrower);
                jplended.add(jlBorrowerConter);
                jplended.add(jlBorrowTime);
                jplended.add(jlBorrowTimeConter);
                jplended.add(jlReturnTime);
                jplended.add(jlReturnTimeConter);

                // 往未借出书籍面板添加组件
                jplendable.add(jb1);
                jplendable.add(jlName1);
                jplendable.add(jlNameContent1);
                jplendable.add(jlOwner1);
                jplendable.add(jlOwnerConter1);
                jplendable.add(jlOwnerStudentid1);
                jplendable.add(jlOwnerStudentIdConter1);
                jplendable.add(jlPrice1);
                jplendable.add(jlPriceConter1);
                jplendable.add(jlStatus1);
                jplendable.add(jLabel1);

                // 进行判断显示哪个面板

                if (dataV.get(updateSelectColmn).get(4).equals("已借出")){
                    add(jplended);
                }else {
                    add(jplendable);
                }

                jb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if (jlPriceConter1.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "书籍信息不能为空", "警告框", JOptionPane.WARNING_MESSAGE);
                        } else {
                            int confirmDialog = JOptionPane.showConfirmDialog(null, "请确定是否修改此书籍", "确认修改", JOptionPane.YES_NO_OPTION);
                            if (confirmDialog == JOptionPane.YES_OPTION) {
                                int selectedRow = jt.getSelectedRow();
                                String bookName = dataV.get(selectedRow).get(0).toString();
                                Object studentId = dataV.get(selectedRow).get(2);
                                dataV.get(selectedRow).set(3, jlPriceConter1.getText().trim());
                                BookVo bookVo = null;
                                try {
                                    bookVo = bookMessageController.queryBorrowBookLog(bookName, Integer.valueOf(studentId.toString()));
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } catch (NoSuchFieldException ex) {
                                    throw new RuntimeException(ex);
                                } catch (ClassNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                } catch (InstantiationException ex) {
                                    throw new RuntimeException(ex);
                                } catch (IllegalAccessException ex) {
                                    throw new RuntimeException(ex);
                                }
                                UserVo userVo = userController.queryUserByStudentNumber((Integer) studentId);
                                bookVo.setBookUserVo(userVo);
                                bookVo.setBookPrice(Double.valueOf(jlPriceConter1.getText().trim()));
                                defaultTableModel.setDataVector(dataV, titlesV);
                                try {
                                    bookMessageController.updateBook(bookVo);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                                setVisible(false);
                            } else {
                                setVisible(false);
                            }
                        }

                    }

                });

                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (jlOwnerStudentIdConter.getText().trim().equals("") || jlOwnerConter.getText().trim().equals("") || jlPriceConter.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "书籍信息不能为空", "警告框", JOptionPane.WARNING_MESSAGE);
                        } else {
                            if ( jlBorrowerConter.getText().trim().equals("") || jlReturnTimeConter.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "请输入借阅者信息或归还时间", "输入错误", JOptionPane.WARNING_MESSAGE);
                            } else {

                                int confirmDialog = JOptionPane.showConfirmDialog(null, "请确定是否修改此书籍", "确认修改", JOptionPane.YES_NO_OPTION);
                                if (confirmDialog == JOptionPane.YES_OPTION) {
                                    int selectedRow = jt.getSelectedRow();
                                    String bookName = dataV.get(selectedRow).get(0).toString();
                                    Object studentId = dataV.get(selectedRow).get(2);
                                    dataV.get(selectedRow).set(3, jlPriceConter.getText().trim());
                                    // dataV.get(selectedRow).set(4, jComboBox.getSelectedItem().toString().trim());
                                    dataV.get(selectedRow).set(5, jlBorrowTimeConter.getText().trim());
                                    dataV.get(selectedRow).set(7, jlReturnTimeConter.getText().trim());

                                    BookVo bookVo = null;
                                    try {
                                        bookVo = bookMessageController.queryBorrowBookLog(bookName, Integer.valueOf(studentId.toString()));
                                    } catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    } catch (NoSuchFieldException ex) {
                                        throw new RuntimeException(ex);
                                    } catch (ClassNotFoundException ex) {
                                        throw new RuntimeException(ex);
                                    } catch (InstantiationException ex) {
                                        throw new RuntimeException(ex);
                                    } catch (IllegalAccessException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    UserVo userVo = userController.queryUserByStudentNumber((Integer) studentId);
                                    bookVo.setBookUserVo(userVo);
                                    bookVo.setBookPrice(Double.valueOf(jlPriceConter.getText()));
                                    if (bookVo.getBookStatus() == Book.LENDED) {
                                        UserVo userVo1 = userController.queryUserByStudentNumber(Integer.valueOf(jlBorrowerStudentIdConter.getText().trim()));
                                        bookVo.setBorrowBookUserVo(userVo1);
                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        Date returnDate = null;
                                        try {
                                            returnDate = simpleDateFormat.parse(jlReturnTimeConter.getText());
                                        } catch (ParseException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                        bookVo.setReturnBookTime(returnDate);
                                    }
                                    defaultTableModel.setDataVector(dataV, titlesV);
                                    try {
                                        bookMessageController.updateBook(bookVo);
                                    } catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    setVisible(false);
                                } else {
                                    setVisible(false);
                                }
                            }
                        }
                    }

                });
            }


}