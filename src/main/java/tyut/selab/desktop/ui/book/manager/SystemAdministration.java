package tyut.selab.desktop.ui.book.manager;
import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookBorrowController;
import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.book.manager.dialog.MyDialogInsert;
import tyut.selab.desktop.ui.book.manager.dialog.MyJDialogBlackList;
import tyut.selab.desktop.ui.book.manager.dialog.MyJDialogDelete;
import tyut.selab.desktop.ui.book.manager.dialog.MyJDialogUpdate;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class SystemAdministration extends JPanel {

    // 书籍价格升序
    public static final int BOOK_PRICE_ASC = 0;
    // 按书籍价格降序
    public static final int BOOK_PRICE_DESC = 1;
    // 查找已借出书籍
    public static final int BOOK_LENDED = 2;
    // 查找未借出书籍
    public static final int BOOK_LENDABLE = 3;
    BookMessageController bookMessageController = new BookMessageController();

    BookBorrowController bookBorrowController = new BookBorrowController();

    // 用于展示的书籍数据和表头  (用 Vector 代替数组)
    private Vector<String> titlesV = null;
    private Vector<Vector> dataV = null;

    UserController userController = new UserController();
   private  DefaultTableModel defaultTableModel = null;
   private JTable jt = null;

    public SystemAdministration() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        titlesV = getTitleVector();
        dataV = getDataVector(bookMessageController.queryAllBook());

        this.setLayout(null);

        // 建两个panel 一个固定菜单按钮不进行刷新 一个面板用于展示刷新
        // 用于刷新变更的面板 放jtable
        JPanel viewJPanel = new JPanel();
        viewJPanel.setBounds(0, 0, 1010, 600);
        viewJPanel.setBackground(Color.cyan);


        //jtable的创建
         defaultTableModel = new DefaultTableModel(dataV,titlesV){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jt = new JTable(defaultTableModel);
        jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumn column = null;
        //设置列宽
        int colunms = jt.getColumnCount();
        int[] columnList = {350, 300, 400, 300, 310, 350, 400, 400};
        for (int i = 0; i < titlesV.size(); i++) {
            column = jt.getColumnModel().getColumn(i);
            /*将每一列的默认宽度设置为100*/
            column.setPreferredWidth(columnList[i]);
        }


        JScrollPane js = new JScrollPane(jt) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(750, 450);
            }
        };
        js.setBounds(0,0,1010,600);
        viewJPanel.setLayout(null);
        viewJPanel.add(js);
        viewJPanel.setVisible(true);
        add(viewJPanel);

        // 菜单面板
        JPanel menuJPanel = new JPanel();
        menuJPanel.setBounds(0, 0, 1010, 100);
        menuJPanel.setVisible(true);
        menuJPanel.setBackground(Color.PINK);
        menuJPanel.setLayout(null);
        add(menuJPanel);

        // 菜单上的按钮
        // 增加书籍
        JButton addButton = new JButton("增加书籍");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MyDialogInsert myDialogInsert = new MyDialogInsert(dataV,titlesV,defaultTableModel,jt);
                myDialogInsert.setVisible(true);
            }
        });
        addButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        addButton.setBackground(new Color(0xFFFF4E4E, true));
        addButton.setForeground(Color.white);
        addButton.setBounds(160, 10, 150, 40);
        addButton.setFocusPainted(false);                         // 按钮字周围的小光圈
        menuJPanel.add(addButton);

        // 修改书籍

        JButton changeButton = new JButton("修改书籍");
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int updateSelectedRow = jt.getSelectedRow();
                MyJDialogUpdate myJDialog = new MyJDialogUpdate(updateSelectedRow,dataV,titlesV,jt,defaultTableModel);
                myJDialog.setVisible(true);
            }
        });
        changeButton.setFont(new Font("微软雅黑", Font.BOLD, 15));            //根据主界面写的
        changeButton.setBackground(new Color(0xFFFF4E4E, true));
        changeButton.setForeground(Color.white);
        changeButton.setBounds(340, 10, 150, 40);
        changeButton.setFocusPainted(false);                              // ？
        menuJPanel.add(changeButton);

        //删除书籍
        JButton deleteButton = new JButton("删除书籍");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jt.getSelectedRow();
                MyJDialogDelete myJDialogDelete = new MyJDialogDelete(selectedRow,dataV,titlesV,jt,defaultTableModel);
                myJDialogDelete.setVisible(true);
            }
        });
        deleteButton.setFont(new Font("微软雅黑", Font.BOLD, 15));              //根据主界面写的
        deleteButton.setBackground(new Color(0xFFFF4E4E, true));
        deleteButton.setForeground(Color.white);
        deleteButton.setBounds(520, 10, 150, 40);
        deleteButton.setFocusPainted(false);
        menuJPanel.add(deleteButton);

        //黑名单
        JButton blacklistButton = new JButton("黑名单");
        blacklistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> titleBlackList = getTitleBlackList();

                Vector<Vector> valuesBlackList = null;
                try {
                    valuesBlackList = queryBlackList();
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
        blacklistButton.setFont(new Font("微软雅黑", Font.BOLD, 15));          //根据主界面写的
        blacklistButton.setBackground(new Color(0xFFFF4E4E, true));
        blacklistButton.setForeground(Color.white);
        blacklistButton.setBounds(700, 10, 150, 40);
        blacklistButton.setFocusPainted(false);
        menuJPanel.add(blacklistButton);

        //下拉选择
        JComboBox<String> jComboBox = new JComboBox<String>();
        jComboBox.addItem("-按价格升序排列-");
        jComboBox.addItem("-按价格降序排列-");
        jComboBox.addItem("-查看未借出书籍-");
        jComboBox.addItem("-查看未归还书籍-");
        jComboBox.addItem("-查看全部书籍-");
        jComboBox.setBounds(20,60,120,30);
        jComboBox.setBackground(Color.PINK);
        jComboBox.setForeground(Color.black);
        jComboBox.setFont( new Font("微软雅黑", Font.BOLD, 10));
        List<BookVo> bookVos = bookMessageController.queryAllBook();
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chooseItem = (String) jComboBox.getSelectedItem();
                List<BookVo> bookVos1 = null;
                switch(chooseItem){
                    case "-按价格升序排列-":
                        bookVos1 = sortBookVos(bookVos, BOOK_PRICE_ASC);
                        break;
                    case "-按价格降序排列-":
                        bookVos1 = sortBookVos(bookVos,BOOK_PRICE_DESC);
                        break;
                    case "-查看未借出书籍-":
                        bookVos1 = sortBookVos(bookVos,BOOK_LENDABLE);
                        break;
                    case "-查看未归还书籍-":
                        bookVos1=sortBookVos(bookVos,BOOK_LENDED);
                        break;
                    case "-查看全部书籍-":
                        bookVos1 = bookVos;
                        break;
                    default:
                        break;
                }
                dataV = getDataVector(bookVos1);
                defaultTableModel.setDataVector(dataV, titlesV);
            }
        });
        menuJPanel.add(jComboBox);
        //文字标签1
        JLabel jlName = new JLabel("书籍名称:",JLabel.CENTER);
        jlName.setFont( new Font("微软雅黑", Font.BOLD, 13) );
        jlName.setBounds(160,60,60,30);
        jlName.setForeground(Color.WHITE);
        menuJPanel.add(jlName);

        //文本框1
        JTextField jtName = new JTextField();
        jtName.setBounds(230,60,250,30);
        menuJPanel.add(jtName);

        //文字标签2
        JLabel jlStudentId = new JLabel("学生学号:",JLabel.CENTER);
        jlStudentId.setFont( new Font("微软雅黑", Font.BOLD, 13) );
        jlStudentId.setForeground(Color.WHITE);
        jlStudentId.setBounds(500,60,60,30);
        menuJPanel.add(jlStudentId);

        //文本框2
        JTextField jtStudentId = new JTextField();
        jtStudentId.setBounds(570,60,250,30);
        menuJPanel.add(jtStudentId);

        // 查询书籍
        // 之后要插入图片
        JButton searchButton = new JButton();
        searchButton.setBounds(855,60,30, 30);
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "C:\\Users\\26580\\Desktop\\desket_platfrom-main\\ui_text\\R-C.png");
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
                if (textName != "") {
                    if (textStudentId != "") {
                        BookVo bookVo = null;
                        try {
                            bookVo = bookMessageController.queryBorrowBookLog(textName, Integer.valueOf(textStudentId));
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
                        List<BookVo> bookVos = new ArrayList<>();
                        bookVos.add(bookVo);
                        dataV = getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    } else {
                        List<BookVo> bookVos = null;
                        try {
                            bookVos = bookMessageController.queryBorrowBookLog(textName);
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
                        dataV = getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    }
                } else {
                    if (textStudentId != "") {
                        List<BookVo> bookVos = null;
                        try {
                            bookVos = bookMessageController.queryBorrowBookLog(textStudentId);
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
                        dataV = getDataVector(bookVos);
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
                        dataV = getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    }
                }
            }
        });
        }




    /**
     * 封装书籍数据信息
     * @return
     */
    private Vector<Vector> getDataVector(List<BookVo> bookVos)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:mm");
        Vector<Vector> dataV = new Vector<>();
        for (int i = 0; i < bookVos.size(); i++) {
            Vector vector = new Vector();
            vector.add(bookVos.get(i).getBookName());
            vector.add(bookVos.get(i).getBookUserVo().getName());
            vector.add(bookVos.get(i).getBookUserVo().getStudentNumber());
            vector.add(bookVos.get(i).getBookPrice());
            int bookStatus = bookVos.get(i).getBookStatus();
            if(bookStatus == Book.LENDABLE){
                vector.add("未借出");
            }else{
                 vector.add("已借出");
            }
            if(bookVos.get(i).getBookStatus() == Book.LENDED) {
                vector.add(bookVos.get(i).getBorrowBookUserVo().getName());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
            }else{
                vector.add("");
                vector.add("");
                vector.add("");
            }
            dataV.add(vector);
        }
        return dataV;
    }

    /**
     * 封装书籍表头信息
     * @return
     */
    private Vector<String> getTitleVector() {
        Vector<String> titlesV = new Vector<>();
        titlesV.add("书籍名称");
        titlesV.add("书籍拥有者");
        titlesV.add("拥有者学号");
        titlesV.add("书籍价格");
        titlesV.add("书籍状态");
        titlesV.add("借阅人");
        titlesV.add("借出时间");
        titlesV.add("归还时间");
        return titlesV;
    }

    /**
     * 黑名单信息表头封装
     */
    public Vector<String> getTitleBlackList(){
        Vector<String> titleBlackList = new Vector<>();
        titleBlackList.add("学生姓名");
        titleBlackList.add("学生学号");
        titleBlackList.add("借阅书籍");
        titleBlackList.add("借阅时间");
        titleBlackList.add("承诺还书时间");
        titleBlackList.add("逾期天数");

        return titleBlackList;
    }

    /**
     * 查询黑名单列表
     * return Vector<Vector>
     */
    public Vector<Vector> queryBlackList() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageController.queryBorrowBookLog();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Vector<Vector> blackList = new Vector<>();
        for (int i = 0; i < bookVos.size(); i++) {
            if(new Date().after(bookVos.get(i).getReturnBookTime())){
                Vector vector = new Vector();
                vector.add(bookVos.get(i).getBookUserVo().getName());
                vector.add(bookVos.get(i).getBookUserVo().getStudentNumber());
                vector.add(bookVos.get(i).getBookName());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
                vector.add((System.currentTimeMillis() - bookVos.get(i).getReturnBookTime().getTime())/(1000*60*60*24));
                blackList.add(vector);
            }
        }

        return blackList;
    }
    /**
     * 按某种方式对List<BookVo>排序
     */
    public List<BookVo> sortBookVos(List<BookVo> bookVos,int types) {

        if (types == BOOK_PRICE_ASC) {
            bookVos.sort(new Comparator<BookVo>() {
                @Override
                public int compare(BookVo o1, BookVo o2) {
                    return (int) (o1.getBookPrice() - o2.getBookPrice());
                }
            });
            return bookVos;
        }
        if (types == BOOK_PRICE_DESC) {
            bookVos.sort(new Comparator<BookVo>() {
                @Override
                public int compare(BookVo o1, BookVo o2) {
                    return (int) (o2.getBookPrice() - o1.getBookPrice());
                }
            });
            return bookVos;
        }
        if (types == BOOK_LENDED) {
            List<BookVo> bookVos1 = new ArrayList<>();
            for (int i = 0; i < bookVos.size(); i++) {
                if(bookVos.get(i).getBookStatus() == Book.LENDED){
                    bookVos1.add(bookVos.get(i));
                }
            }
            return bookVos1;
        }
        if (types == BOOK_LENDABLE) {
            List<BookVo> bookVos1 = new ArrayList<>();
            for (int i = 0; i < bookVos.size(); i++) {
                if(bookVos.get(i).getBookStatus() == Book.LENDABLE){
                    bookVos1.add(bookVos.get(i));
                }
            }
            return bookVos1;
        }
        return null;
    }


}
