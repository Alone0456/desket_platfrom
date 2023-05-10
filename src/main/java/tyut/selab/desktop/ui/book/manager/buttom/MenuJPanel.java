package tyut.selab.desktop.ui.book.manager.buttom;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.ui.book.manager.SystemAdministration;
import tyut.selab.desktop.ui.book.manager.dialog.MyDialogInsert;
import tyut.selab.desktop.ui.book.manager.dialog.MyJDialogBlackList;
import tyut.selab.desktop.ui.book.manager.dialog.MyJDialogDelete;
import tyut.selab.desktop.ui.book.manager.dialog.UpdateJMoudle.MyJDialogUpdate;
import tyut.selab.desktop.ui.book.manager.domain.Data;

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
    BookMessageController bookMessageController = new BookMessageController();
    JPanel menuJPanel = null;
    Vector<Vector> dataV = null;
    public MenuJPanel(Vector<Vector> datas, Vector titlesV, JTable jt, DefaultTableModel defaultTableModel) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       Data data = new Data();
       dataV = datas;
        // 菜单面板
         menuJPanel = new JPanel();
        menuJPanel.setBounds(0, 0, 1010, 150);
        menuJPanel.setVisible(true);
        menuJPanel.setBackground(Color.PINK);
        menuJPanel.setLayout(null);


        // 菜单上的按钮
        // 增加书籍
        ImageIcon icon = new ImageIcon("src/main/java/tyut/selab/desktop/utils/insertBook.png");

        JButton addButton = new JButton("增加书籍",icon);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialogInsert myDialogInsert = new MyDialogInsert(dataV,titlesV,defaultTableModel);
                myDialogInsert.setVisible(true);
            }
        });
        addButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        addButton.setBackground(new Color(0xFFFF4E4E, true));
        addButton.setForeground(Color.white);
        addButton.setBounds(100, 20, 180, 60  );
        addButton.setFocusPainted(false);                         // 按钮字周围的小光圈
        menuJPanel.add(addButton);

        // 修改书籍
        ImageIcon imageIcon1 = new ImageIcon("src/main/java/tyut/selab/desktop/utils/updateBook.png");
        JButton changeButton = new JButton("修改书籍",imageIcon1);
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int updateSelectedRow = jt.getSelectedRow();
                MyJDialogUpdate myJDialog = new MyJDialogUpdate(updateSelectedRow,dataV,titlesV,jt,defaultTableModel);
                myJDialog.setVisible(true);
            }
        });
        changeButton.setFont(new Font("微软雅黑", Font.BOLD, 18));            //根据主界面写的
        changeButton.setBackground(new Color(0xFFFF4E4E, true));
        changeButton.setForeground(Color.white);
        changeButton.setBounds(310, 20, 180,60);
        changeButton.setFocusPainted(false);                              // ？
        menuJPanel.add(changeButton);

        //删除书籍
        ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/utils/delectBook.png");
        JButton deleteButton = new JButton("删除书籍",imageIcon);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jt.getSelectedRow();
                MyJDialogDelete myJDialogDelete = new MyJDialogDelete(selectedRow,dataV,titlesV,jt,defaultTableModel);
                myJDialogDelete.setVisible(true);
            }
        });
        deleteButton.setFont(new Font("微软雅黑", Font.BOLD, 18));              //根据主界面写的
        deleteButton.setBackground(new Color(0xFFFF4E4E, true));
        deleteButton.setForeground(Color.white);
        deleteButton.setBounds(520, 20, 180, 60);
        deleteButton.setFocusPainted(false);
        menuJPanel.add(deleteButton);

        //黑名单
        ImageIcon icon11 = new ImageIcon("src/main/resources/R-C (3)1.png");
        JButton blacklistButton = new JButton("黑名单");
        blacklistButton.setIcon(icon11);
       blacklistButton.setBorderPainted(false);
//        blacklistButton.setOpaque(false);
        blacklistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> titleBlackList = data.getTitleBlackList();

                Vector<Vector> valuesBlackList = null;
                try {
                    valuesBlackList =  data.queryBlackList();
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
                MyJDialogBlackList myJDialogBlackList = new MyJDialogBlackList(titleBlackList, valuesBlackList);
                myJDialogBlackList.setVisible(true);
            }
        });
        blacklistButton.setFont(new Font("微软雅黑", Font.BOLD, 18));          //根据主界面写的
        blacklistButton.setBackground(new Color(0xFFFF4E4E, true));
        blacklistButton.setForeground(Color.white);
        blacklistButton.setBounds(730, 20, 180, 60);
        blacklistButton.setFocusPainted(false);
        menuJPanel.add(blacklistButton);

        //下拉选择
        JComboBox<String> jComboBox = new JComboBox<String>();
        jComboBox.addItem("-查看全部书籍-");
        jComboBox.addItem("-按价格升序排列-");
        jComboBox.addItem("-按价格降序排列-");
        jComboBox.addItem("-查看未借出书籍-");
        jComboBox.addItem("-查看未归还书籍-");
        jComboBox.setSelectedItem("-查看全部书籍-");
        jComboBox.setBounds(50,100,170,40);
        jComboBox.setBackground(Color.PINK);
        jComboBox.setForeground(Color.black);
        jComboBox.setFont( new Font("微软雅黑", Font.BOLD, 18));
        List<BookVo> bookVos = bookMessageController.queryAllBook();
        dataV =  data.getDataVector(bookVos);
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String chooseItem = (String) jComboBox.getSelectedItem();
                switch(chooseItem){
                    case "-按价格升序排列-":
                        dataV =  data.sortBookVos(dataV, SystemAdministration.BOOK_PRICE_ASC);
                        break;
                    case "-按价格降序排列-":
                        dataV =  data.sortBookVos(dataV,SystemAdministration.BOOK_PRICE_DESC);
                        break;
                    case "-查看未借出书籍-":
                        dataV =  data.getDataVector(bookVos);
                        dataV =  data.sortBookVos(dataV,SystemAdministration.BOOK_LENDABLE);
                        break;
                    case "-查看未归还书籍-":
                        dataV = data.getDataVector(bookVos);
                        dataV =data.sortBookVos(dataV,SystemAdministration.BOOK_LENDED);
                        break;
                    case "-查看全部书籍-":
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
                        break;
                    default:
                        break;
                }

                defaultTableModel.setDataVector(dataV, titlesV);
            }
        });
        menuJPanel.add(jComboBox);
        //文字标签1
        JLabel jlName = new JLabel("书籍名称:",JLabel.CENTER);
        jlName.setFont( new Font("微软雅黑", Font.BOLD, 18) );
        jlName.setBounds(250,100,80,40);
        jlName.setForeground(Color.WHITE);
        menuJPanel.add(jlName);

        //文本框1
        JTextField jtName = new JTextField();
        jtName.setBounds(350,100,200,40);
        jtName.setFont(new Font("微软雅黑", Font.PLAIN, 18) );
        jtName.setHorizontalAlignment(JTextField.CENTER);
        menuJPanel.add(jtName);

        //文字标签2
        JLabel jlStudentId = new JLabel("学生学号:",JLabel.CENTER);
        jlStudentId.setFont( new Font("微软雅黑", Font.BOLD, 18) );
        jlStudentId.setForeground(Color.WHITE);
        jlStudentId.setBounds(580,100,80,40);
        menuJPanel.add(jlStudentId);

        //文本框2
        JTextField jtStudentId = new JTextField();
        jtStudentId.setBounds(680,100,200,40);
        jtStudentId.setFont(new Font("微软雅黑", Font.PLAIN, 18) );
        jtStudentId.setHorizontalAlignment(JTextField.CENTER);
        menuJPanel.add(jtStudentId);

        // 查询书籍
        // 之后要插入图片
        JButton searchButton = new JButton();
        searchButton.setBounds(920,100,40, 40);
        ImageIcon icon1 = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/R-C (1).png");
        searchButton.setIcon(icon1);
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
                            bookVo = bookMessageController.queryBookLog(Integer.valueOf(textStudentId),textName);
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
                        if(bookVo != null){
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
                            System.out.println(textStudentId);
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
                        dataV =  data.getDataVector(bookVos);
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

