package tyut.selab.desktop.ui.book.manager.dialog.UpdateJMoudle;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.book.manager.dialog.UpdateJMoudle.LendJLable;
import tyut.selab.desktop.ui.book.manager.dialog.UpdateJMoudle.LendableJLable;

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


                ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
                setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

                setTitle("修改书籍信息");
                setModal(true);
                setSize(800, 500);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);     // 关闭后销毁对话框
                setLocationRelativeTo(null);


                // 进行判断显示哪个面板
                if (dataV.get(updateSelectColmn).get(4).equals("已借出")){
                    LendJLable lendJLable = new LendJLable(dataV,updateSelectColmn);
                    add(lendJLable.getjPanel());
                    JButton jb = lendJLable.getJb();
                    JTextField jlPriceConter = lendJLable.getJlLendablePriceConter();
                    JTextField jlReturnTimeConter = lendJLable.getJlReturnTimeConter();
                    JLabel  jlBorrowerStudentIdConter = lendJLable.getJlBorrowerStudentIdConter();
                    jb.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (jlPriceConter.getText().trim().equals("") || jlReturnTimeConter.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "书籍信息不能为空", "警告框", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int confirmDialog = JOptionPane.showConfirmDialog(null, "请确定是否修改此书籍", "确认修改", JOptionPane.YES_NO_OPTION);
                                if (confirmDialog == JOptionPane.YES_OPTION) {
                                    int selectedRow = jt.getSelectedRow();
                                    String bookName = dataV.get(selectedRow).get(0).toString();
                                    Object studentId = dataV.get(selectedRow).get(2);
                                    dataV.get(selectedRow).set(3, jlPriceConter.getText().trim());
                                    dataV.get(selectedRow).set(7, jlReturnTimeConter.getText().trim());
                                    BookVo bookVo = null;
                                    try {
                                        bookVo = bookMessageController.queryBorrowBookLog(bookName, Integer.valueOf(studentId.toString()));
                                        UserVo userVo = userController.queryUserByStudentNumber((Integer) studentId);
                                        bookVo.setBookUserVo(userVo);
                                        bookVo.setBookPrice(Double.valueOf(jlPriceConter.getText()));
                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        Date returnDate = null;
                                        returnDate = simpleDateFormat.parse(jlReturnTimeConter.getText());
                                        bookVo.setReturnBookTime(returnDate);
                                        defaultTableModel.setDataVector(dataV, titlesV);
                                        bookMessageController.updateBook(bookVo);
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
                                    } catch (ParseException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    setVisible(false);
                                } else {
                                    setVisible(false);
                                }
                            }

                        }

                    });

                }else {
                    LendableJLable lendableJLable = new LendableJLable(dataV,updateSelectColmn);
                    add(lendableJLable.getjPanel());
                    JButton jbLendable = lendableJLable.getJb();
                    JTextField jlLendablePriceConter = lendableJLable.getJlLendablePriceConter();
                    jbLendable.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            if (jlLendablePriceConter.getText().trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "书籍信息不能为空", "警告框", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int confirmDialog = JOptionPane.showConfirmDialog(null, "请确定是否修改此书籍", "确认修改", JOptionPane.YES_NO_OPTION);
                                if (confirmDialog == JOptionPane.YES_OPTION) {
                                    int selectedRow = jt.getSelectedRow();
                                    String bookName = dataV.get(selectedRow).get(0).toString();
                                    Object studentId = dataV.get(selectedRow).get(2);
                                    dataV.get(selectedRow).set(3, jlLendablePriceConter.getText().trim());
                                    BookVo bookVo = null;
                                    try {
                                        bookVo = bookMessageController.queryBookLog(Integer.valueOf(studentId.toString()), bookName);
                                        bookVo.setBookPrice(Double.valueOf(jlLendablePriceConter.getText().trim()));
                                        bookMessageController.updateBook(bookVo);
                                        defaultTableModel.setDataVector(dataV, titlesV);
                                        setVisible(false);
                                    } catch (NoSuchFieldException e) {
                                        throw new RuntimeException(e);
                                    } catch (ClassNotFoundException e) {
                                        throw new RuntimeException(e);
                                    } catch (InstantiationException e) {
                                        throw new RuntimeException(e);
                                    } catch (IllegalAccessException e) {
                                        throw new RuntimeException(e);
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                } else {
                                    setVisible(false);
                                }
                            }

                        }

                    });
                }






            }


}