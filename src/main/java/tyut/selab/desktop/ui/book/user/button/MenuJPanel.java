package tyut.selab.desktop.ui.book.user.button;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.ui.book.user.SystemOrdinaryUsers;
import tyut.selab.desktop.ui.book.user.dialog.BorrowBookDialog;
import tyut.selab.desktop.ui.book.user.dialog.MyDialogInsert;
import tyut.selab.desktop.ui.book.user.dialog.MyDialogMyBook;
import tyut.selab.desktop.ui.book.user.dialog.MyDialogReturnBook;
import tyut.selab.desktop.ui.book.user.domain.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MenuJPanel {

    JPanel menuJPanel = null;
    Vector<Vector> dataV = null;
    BookMessageController bookMessageController = new BookMessageController();
    public MenuJPanel(Vector<Vector> datas, Vector titlesV, UserVo users, DefaultTableModel defaultTableModel,JTable jt) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Data data = new Data(users);

        // 菜单面板
         menuJPanel = new JPanel();
        dataV = datas;
        menuJPanel.setBounds(0, 0, 1010, 150);
        menuJPanel.setVisible(true);
        menuJPanel.setBackground(Color.PINK);
        menuJPanel.setLayout(null);

        // 菜单上的按钮
        // 增加书籍
        ImageIcon icon11 = new ImageIcon("src/main/java/tyut/selab/desktop/utils/insertBook.png");
        JButton addButton = new JButton("增加书籍",icon11);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialogInsert myDialogInsert = new MyDialogInsert(dataV, titlesV,users, defaultTableModel);
                dataV = myDialogInsert.getDataV();
                myDialogInsert.setVisible(true);
            }
        });
        addButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        addButton.setBackground(new Color(0xFFFF4E4E, true));
        addButton.setForeground(Color.white);
        addButton.setBounds(100, 20, 180, 60);
        addButton.setFocusPainted(false);// ？    按钮字周围的小光圈
        menuJPanel.add(addButton);

        // 查看我的书籍
        ImageIcon icon1 = new ImageIcon("src/main/java/tyut/selab/desktop/utils/myBook.png");
        JButton queryMyBookButton = new JButton("我的书籍",icon1);
        queryMyBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MyDialogMyBook myJDialogMyBook = new MyDialogMyBook(data.getTitleMyBook(), data.getDataMyBook(), users, dataV, titlesV, defaultTableModel);
                    myJDialogMyBook.setVisible(true);
                    dataV = myJDialogMyBook.getDataV();
                    defaultTableModel.setDataVector(dataV, titlesV);
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

            }
        });
        queryMyBookButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        queryMyBookButton.setBackground(new Color(0xFFFF4E4E, true));
        queryMyBookButton.setForeground(Color.white);
        queryMyBookButton.setBounds(310, 20, 180, 60);
        queryMyBookButton.setFocusPainted(false);
        menuJPanel.add(queryMyBookButton);


        //借阅图书
        ImageIcon icon12 = new ImageIcon("src/main/java/tyut/selab/desktop/utils/borrowBook.png");
        JButton borrowBookButton = new JButton("借阅图书",icon12);
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jt.getSelectedRow();
                if (dataV.get(selectedRow).get(4).equals("未借出")) {
                    BorrowBookDialog borrowBookDialog = new BorrowBookDialog(selectedRow, dataV, titlesV, defaultTableModel, users);
                    borrowBookDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "该书籍已借出", "借阅书籍失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        borrowBookButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        borrowBookButton.setBackground(new Color(0xFFFF4E4E, true));
        borrowBookButton.setForeground(Color.white);
        borrowBookButton.setBounds(520, 20, 180, 60);
        borrowBookButton.setFocusPainted(false);
        menuJPanel.add(borrowBookButton);

        //归还图书
        ImageIcon icon21 = new ImageIcon("src/main/java/tyut/selab/desktop/utils/returnBook.png");
        JButton returnBookButton = new JButton("归还图书",icon21);
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> titlesReturnBook = data.getTitlesReturnBook();
                Vector<Vector> dataReturnBook = null;
                try {
                    dataReturnBook = data.getDataReturnBook();
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
                if(dataReturnBook.size() == 0){
                    JOptionPane.showMessageDialog(null, "您还未借阅书籍，无需归还", "归还书籍错误", JOptionPane.WARNING_MESSAGE);
                }else {
                    MyDialogReturnBook myDialogReturnBook = new MyDialogReturnBook(titlesReturnBook, dataReturnBook, dataV, titlesV, defaultTableModel);

                    myDialogReturnBook.setVisible(true);
                }
            }
        });
        returnBookButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        returnBookButton.setBackground(new Color(0xFFFF4E4E, true));
        returnBookButton.setForeground(Color.white);
        returnBookButton.setBounds(730, 20, 180, 60);
        returnBookButton.setFocusPainted(false);
        menuJPanel.add(returnBookButton);

        //下拉选择
        JComboBox<String> jComboBox = new JComboBox<String>();
        jComboBox.addItem("-查看全部书籍-");
        jComboBox.addItem("-按价格升序排列-");
        jComboBox.addItem("-按价格降序排列-");
        jComboBox.addItem("-查看未借出书籍-");
        jComboBox.setSelectedItem("-查看全部书籍-");
        jComboBox.setBounds(50, 100, 170, 40);
        jComboBox.setBackground(Color.pink);
        jComboBox.setForeground(Color.WHITE);
        jComboBox.setFont(new Font("微软雅黑", Font.BOLD, 18));

        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<BookVo> bookVos = null;

                String chooseItem = (String) jComboBox.getSelectedItem();
                switch (chooseItem) {
                    case "-按价格升序排列-":
                        dataV = data.sortBookVos(dataV, SystemOrdinaryUsers.BOOK_PRICE_ASC);
                        break;
                    case "-按价格降序排列-":
                        dataV = data.sortBookVos(dataV, SystemOrdinaryUsers.BOOK_PRICE_DESC);
                        break;
                    case "-查看未借出书籍-":
                        dataV = data.sortBookVos(dataV, SystemOrdinaryUsers.BOOK_LENDABLE);
                        break;
                    case "-查看未归还书籍-":
                        dataV = data.sortBookVos(dataV, SystemOrdinaryUsers.BOOK_LENDED);
                        break;
                    case "-查看全部书籍-":
                        try {
                            bookVos = bookMessageController.queryAllBook();
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
                        dataV = data.getDataVector(bookVos);
                        break;
                    default:
                        break;
                }

                defaultTableModel.setDataVector(dataV, titlesV);
            }
        });
        menuJPanel.add(jComboBox);


        //文字标签1
        JLabel jlName = new JLabel("书籍名称:", JLabel.CENTER);
        jlName.setFont(new Font("微软雅黑", Font.BOLD, 18));
        jlName.setBounds(250, 100, 80, 40);
        jlName.setForeground(Color.WHITE);
        menuJPanel.add(jlName);

        //文本框1
        JTextField jtName = new JTextField();
        jtName.setBounds(350, 100, 200, 40);
        jtName.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        jtName.setHorizontalAlignment(JTextField.CENTER);
        menuJPanel.add(jtName);

        //文字标签2
        JLabel jlStudentId = new JLabel("学生学号:", JLabel.CENTER);
        jlStudentId.setFont(new Font("微软雅黑", Font.BOLD, 18));
        jlStudentId.setForeground(Color.WHITE);
        jlStudentId.setBounds(580, 100, 80, 40);
        menuJPanel.add(jlStudentId);

        //文本框2
        JTextField jtStudentId = new JTextField();
        jtStudentId.setBounds(680, 100, 200, 40);
        jtStudentId.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        jtStudentId.setHorizontalAlignment(JTextField.CENTER);
        menuJPanel.add(jtStudentId);

        // 查询书籍
        // 之后要插入图片
        JButton searchButton = new JButton();
        searchButton.setBounds(920, 100, 40, 40);
        ImageIcon icon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/R-C (1).png");
        searchButton.setIcon(icon);
        searchButton.setOpaque(false);                       //设置控件是否透明，true为不透明，false为透明
        searchButton.setContentAreaFilled(false);               //设置图片填满按钮所在的区域
        searchButton.setBorderPainted(false);                //设置是否绘制边框
        searchButton.setBorder(null);                      //设置边框
        menuJPanel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textName = jtName.getText();
                String textStudentId = jtStudentId.getText();
                if (!textName.equals("")) {
                    if (!textStudentId.equals("")) {
                        BookVo bookVo = null;
                        try {
                            bookVo = bookMessageController.queryBookLog(Integer.valueOf(textStudentId), textName);
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
                        java.util.List<BookVo> bookVos = new ArrayList<>();
                        if (bookVo != null) {
                            bookVos.add(bookVo);
                        }
                        dataV = data.getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    } else {
                        java.util.List<BookVo> bookVos = null;
                        try {
                            bookVos = bookMessageController.queryBookByBookName(textName);
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
                        dataV = data.getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    }
                } else {
                    if (!textStudentId.equals("")) {
                        java.util.List<BookVo> bookVos = null;
                        try {
                            bookVos = bookMessageController.queryBookByUserid(Integer.valueOf(textStudentId));

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
                        dataV = data.getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    } else {
                        List<BookVo> bookVos = null;
                        try {
                            bookVos = bookMessageController.queryAllBook();
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
                        dataV = data.getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    }
                }
            }
        });


    }

    public JPanel getMenuJPanel() {
        return menuJPanel;
    }
}
