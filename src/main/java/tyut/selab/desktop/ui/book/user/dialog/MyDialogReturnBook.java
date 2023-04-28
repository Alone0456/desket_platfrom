package tyut.selab.desktop.ui.book.user.dialog;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookBorrowController;
import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class MyDialogReturnBook extends JDialog {

        Vector<String> titleReturnBookList = null;
        Vector<Vector> valuesList = null;
        BookMessageController bookMessageController = new BookMessageController();
        BookBorrowController bookBorrowController = new BookBorrowController();

        public MyDialogReturnBook(Vector<String> titleReturnBookList, Vector<Vector> valuesList,Vector<Vector> dataV,Vector titlesV,DefaultTableModel defaultTableModel) {

            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            JPanel jPanel1 = new JPanel();
            JPanel jPanel2 = new JPanel();

            jPanel1.setBounds(0, 0, 800, 400);
            jPanel1.setLayout(null);
            jPanel1.setVisible(true);
            jPanel2.setBounds(300, 400, 200, 60);
            jPanel2.setLayout(null);
            jPanel2.setVisible(true);

            this.titleReturnBookList = titleReturnBookList;
            this.valuesList = valuesList;
            setTitle("归还书籍");
            setModal(true);
            setSize(800, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);
            DefaultTableModel defaultTableModel1 = new DefaultTableModel(valuesList, titleReturnBookList) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable jTable = new JTable(defaultTableModel1);
            JTableHeader tableHeader = jTable.getTableHeader();
            TableColumn column = null;
            int colunms = jTable.getColumnCount();
            int[] columnList = {300, 300, 400, 250, 420, 420};
            for (int i = 0; i < titleReturnBookList.size(); i++) {
                column = jTable.getColumnModel().getColumn(i);
                /*将每一列的默认宽度设置为100*/
                column.setPreferredWidth(columnList[i]);
            }
            jTable.setFont(new Font("楷书", Font.PLAIN, 15));
            jTable.setRowHeight(35);
            tableHeader.setFont(new Font("楷书", Font.PLAIN, 20));
            tableHeader.setReorderingAllowed(false);
            JScrollPane jScrollPane = new JScrollPane(jTable);
            jScrollPane.setBounds(0, 0, 800, 350);
            jPanel1.add(jScrollPane);
            //归还书籍
            JButton returnBookButon = new JButton("归还书籍");
            returnBookButon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = jTable.getSelectedRow();
                    BookVo bookVo = null;
                    try {
                        bookVo = bookMessageController.queryBorrowBookLog(valuesList.get(selectedRow).get(0).toString(), (Integer) valuesList.get(selectedRow).get(2));
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

                    try {
                        bookBorrowController.returnBook(bookVo);
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
                    valuesList.removeElementAt(selectedRow);
                    dataV.get(selectedRow).set(4, "未借出");
                    dataV.get(selectedRow).set(5, "");
                    dataV.get(selectedRow).set(6, "");
                    dataV.get(selectedRow).set(7, "");
                    JOptionPane.showMessageDialog(null, "归还书籍成功！", "归还书籍", JOptionPane.WARNING_MESSAGE);
                    defaultTableModel1.setDataVector(valuesList, titleReturnBookList);
                    defaultTableModel.setDataVector(dataV, titlesV);
                    setVisible(false);
                }
            });
            returnBookButon.setFont(new Font("微软雅黑", Font.BOLD, 15));
            returnBookButon.setBackground(new Color(0xFFFF4E4E, true));
            returnBookButon.setForeground(Color.white);
            returnBookButon.setSize(200, 50);
            returnBookButon.setFocusPainted(false);
            jPanel2.add(returnBookButon);
            add(jPanel1);
            add(jPanel2);


        }
    }