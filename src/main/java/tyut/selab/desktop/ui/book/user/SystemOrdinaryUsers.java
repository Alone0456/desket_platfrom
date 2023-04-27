package tyut.selab.desktop.ui.book.user;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookBorrowController;
import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class SystemOrdinaryUsers extends JPanel {

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
    private DefaultTableModel defaultTableModel = null;
    private JTable jt = null;

    private UserVo userVo = null;

    public SystemOrdinaryUsers() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        userVo = new UserVo();
        userVo.setAccountNumber(String.valueOf(2022005544));
        userVo.setPhone("154564564");
        userVo.setStudentNumber(2022005544);
        userVo.setName("李智超");
        titlesV = getTitleVector();
        dataV = getDataVector(bookMessageController.queryAllBook());
        setLayout(null);
        // 建两个panel 一个固定菜单按钮不进行刷新 一个面板用于展示刷新
        // 用于刷新变更的面板 放jtable
        JPanel viewJPanel = new JPanel();
        viewJPanel.setBounds(0, 150, 1010, 550);
        viewJPanel.setBackground(Color.cyan);


        //jtable的创建
        defaultTableModel = new DefaultTableModel(dataV, titlesV) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jt = new JTable(defaultTableModel);
        jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JTableHeader tableHeader = jt.getTableHeader();
        jt.setFont(new Font("楷书",Font.PLAIN,15));
        jt.setRowHeight(35);
        tableHeader.setFont(new Font("楷书",Font.PLAIN,20));
        tableHeader.setReorderingAllowed(false);
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
        js.setBounds(0, 0, 1010, 550);
        viewJPanel.setLayout(null);
        viewJPanel.add(js);
        viewJPanel.setVisible(true);
        add(viewJPanel);


        // 菜单面板
        JPanel menuJPanel = new JPanel();
        menuJPanel.setBounds(0, 0, 1010, 150);
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
                MyDialogInsert myDialogInsert = new MyDialogInsert();
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
        JButton queryMyBookButton = new JButton("我的书籍");
        queryMyBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MyDialogMyBook myJDialogMyBook = new MyDialogMyBook(getTitleMyBook(), getDataMyBook());
                    myJDialogMyBook.setVisible(true);
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
        JButton borrowBookButton = new JButton("借阅图书");
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jt.getSelectedRow();
                if (dataV.get(selectedRow).get(4).equals("未借出")) {
                    BorrowBookDialog borrowBookDialog = new BorrowBookDialog(selectedRow);
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
        JButton returnBookButton = new JButton("归还图书");
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> titlesReturnBook = getTitlesReturnBook();
                Vector<Vector> dataReturnBook = null;
                try {
                    dataReturnBook = getDataReturnBook();
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
                MyDialogReturnBook myDialogReturnBook = new MyDialogReturnBook(titlesReturnBook, dataReturnBook);
                JOptionPane.showMessageDialog(null,"归还书籍成功！","归还书籍",JOptionPane.WARNING_MESSAGE);
                myDialogReturnBook.setVisible(false);
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
        List<BookVo> bookVos = bookMessageController.queryAllBook();
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chooseItem = (String) jComboBox.getSelectedItem();
                List<BookVo> bookVos1 = null;
                switch (chooseItem) {
                    case "-按价格升序排列-":
                        bookVos1 = sortBookVos(bookVos, BOOK_PRICE_ASC);
                        break;
                    case "-按价格降序排列-":
                        bookVos1 = sortBookVos(bookVos, BOOK_PRICE_DESC);
                        break;
                    case "-查看未借出书籍-":
                        bookVos1 =sortBookVos(bookVos,BOOK_LENDABLE);
                        break;
                    case "-查看未归还书籍-":
                        bookVos1 =sortBookVos(bookVos,BOOK_LENDED);
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
                        List<BookVo> bookVos = new ArrayList<>();
                        if(bookVo != null){
                            bookVos.add(bookVo);
                        }
                        dataV = getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    } else {
                        List<BookVo> bookVos = null;
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
                        dataV = getDataVector(bookVos);
                        defaultTableModel.setDataVector(dataV, titlesV);
                    }
                } else {
                    if (!textStudentId.equals("")) {
                        List<BookVo> bookVos = null;
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
     * 归还书籍时弹出页面
     */
    private class MyDialogReturnBook extends JDialog {

        Vector<String> titleReturnBookList = null;
        Vector<Vector> valuesList = null;
        public MyDialogReturnBook(Vector<String> titleReturnBookList, Vector<Vector> valuesList) {

            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            JPanel jPanel1= new JPanel();
            JPanel jPanel2= new JPanel();

            jPanel1.setBounds(0,0,800,400);
            jPanel1.setLayout(null);
            jPanel1.setVisible(true);
            jPanel2.setBounds(300,400,200,60);
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
            JScrollPane jScrollPane = new JScrollPane(jTable);
            jScrollPane.setBounds(0,0,800,350);
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

                    defaultTableModel1.setDataVector(valuesList, titleReturnBookList);
                    defaultTableModel.setDataVector(dataV, titlesV);
                }
            });
            returnBookButon.setFont(new Font("微软雅黑", Font.BOLD, 15));
            returnBookButon.setBackground(new Color(0xFFFF4E4E, true));
            returnBookButon.setForeground(Color.white);
            returnBookButon.setSize(200,50);
            returnBookButon.setFocusPainted(false);
            jPanel2.add(returnBookButon);
            add(jPanel1);
            add(jPanel2);



            }
        }



    /**
     * 查看我的书籍时弹出页面
     */
    private class MyDialogMyBook extends JDialog{

        Vector<String> titleMyBookList = null;
        Vector<Vector> valuesList = null;
        public MyDialogMyBook(Vector<String> titleMyBookList, Vector<Vector> valuesList) {

            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            JPanel jPanel1 = new JPanel();
            JPanel jPanel2 =  new JPanel();

            jPanel1.setBounds(0,0,800,400);
            jPanel1.setLayout(null);
            jPanel1.setVisible(true);
            jPanel2.setBounds(300,400,200,60);
            jPanel2.setLayout(null);
            jPanel2.setVisible(true);

            this.titleMyBookList =titleMyBookList;
            this.valuesList = valuesList;
            setTitle("我的书籍");
            setModal(true);
            setSize(800, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);
            DefaultTableModel defaultTableModel1 = new DefaultTableModel(valuesList,titleMyBookList){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable jTable = new JTable(defaultTableModel1);
            JTableHeader tableHeader = jTable.getTableHeader();
            jTable.setFont(new Font("楷书",Font.PLAIN,15));
            jTable.setRowHeight(35);
            tableHeader.setFont(new Font("楷书",Font.PLAIN,20));
            tableHeader.setReorderingAllowed(false);
            JScrollPane jScrollPane = new JScrollPane(jTable);
            jScrollPane.setBounds(0,0,800,350);
            jPanel1.add(jScrollPane);
            //删除书籍
            JButton deleteButton = new JButton("删除书籍");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirmDialog = JOptionPane.showConfirmDialog(null, "请确定是否删除此书籍", "确认删除", JOptionPane.YES_NO_OPTION);
                    if (confirmDialog == JOptionPane.YES_OPTION) {
                        int selectedRow = jTable.getSelectedRow();
                        System.out.println(selectedRow);
                        try {
                            bookMessageController.deleteBook(userVo.getStudentNumber(), valuesList.get(selectedRow).get(0).toString());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        valuesList.removeElementAt(selectedRow);
                        defaultTableModel1.setDataVector(valuesList, titleMyBookList);
                    }
                }
            });
            deleteButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
            deleteButton.setBackground(new Color(0xFFFF4E4E, true));
            deleteButton.setForeground(Color.white);
            deleteButton.setSize(200,50);
            deleteButton.setFocusPainted(false);
            jPanel2.add(deleteButton);
            add(jPanel1);
            add(jPanel2);
        }
    }


    /**
     * 封装书籍数据信息
     * @return
     */
    private Vector<Vector> getDataVector(List<BookVo> bookVos)  {
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
                vector.add("");
                vector.add("");
                vector.add("");
            }else{
                vector.add("已借出");
                vector.add(bookVos.get(i).getBorrowBookUserVo().getName());
                vector.add(bookVos.get(i).getBorrowBookTime());
                vector.add(bookVos.get(i).getReturnBookTime());
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

    //   删除书籍时弹出的对话框
    //TODO:   样式
    private class MyJDialogDelete extends JDialog {

        public MyJDialogDelete(int updateSelectColmn) {

            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            setTitle("删除书籍");
            setModal(true);
            setSize(800, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            JLabel jlName = new JLabel("书籍名称");
            jlName.setFont(new Font("微软黑体",Font.BOLD,15));
            jlName.setBounds(220,25,100,30);
            JLabel jlNameContent = new JLabel((String) dataV.get(updateSelectColmn).get(0));
            jlNameContent.setFont(new Font("微软黑体",Font.PLAIN,15));
            jlNameContent.setBounds(330,25,300,30);
            JLabel jlPrice = new JLabel("书籍价格");
            jlPrice.setFont(new Font("微软黑体",Font.BOLD,15));
            jlPrice.setBounds(220,155,100,30);
            JLabel jlPriceConter = new JLabel((String) dataV.get(updateSelectColmn).get(3));
            jlPriceConter.setFont(new Font("微软黑体",Font.PLAIN,15));
            jlPriceConter.setBounds(330,155,300,30);
            jlPriceConter.setSize(100, 30);
            JLabel jlStatus = new JLabel("书籍状态");
            jlStatus.setFont(new Font("微软黑体",Font.BOLD,15));
            jlStatus.setBounds(220,195,100,30);
            JLabel jlStatusConter = new JLabel(dataV.get(updateSelectColmn).get(5).toString());
            jlStatusConter.setFont(new Font("微软黑体",Font.PLAIN,15));
            jlStatusConter.setBounds(330,195,300,30);
            JLabel jlBorrower = new JLabel("书籍借阅人");
            jlBorrower.setFont(new Font("微软黑体",Font.BOLD,15));
            jlBorrower.setBounds(220,235,100,30);
            JLabel jlBorrowerConter = new JLabel((String) dataV.get(updateSelectColmn).get(4));
            jlBorrowerConter.setFont(new Font("微软黑体",Font.PLAIN,15));
            jlBorrowerConter.setBounds(330,235,300,30);
            JLabel jlBorrowTime = new JLabel("借阅时间");
            jlBorrowTime.setFont(new Font("微软黑体",Font.BOLD,15));
            jlBorrowTime.setBounds(220,275,100,30);
            JLabel jlBorrowTimeConter = new JLabel(dataV.get(updateSelectColmn).get(6).toString());
            jlBorrowTimeConter.setFont(new Font("微软黑体",Font.PLAIN,15));
            jlBorrowTimeConter.setBounds(330,275,300,30);
            JLabel jlReturnTime = new JLabel("承诺归还时间");
            jlReturnTime.setFont(new Font("微软黑体",Font.BOLD,15));
            jlReturnTime.setBounds(220,315,100,30);
            JLabel jlReturnTimeConter = new JLabel(dataV.get(updateSelectColmn).get(7).toString());
            jlReturnTimeConter.setFont(new Font("微软黑体",Font.PLAIN,15));
            jlReturnTimeConter.setBounds(330,315,300,30);
            JPanel jp = new JPanel();
            jp.setSize(800,500);
            jp.setBackground(Color.WHITE);
            jp.setLayout(null);
            JButton jb = new JButton("确认删除");
            jb.setFont(new Font("微软黑体",Font.BOLD,15));
            jb.setBounds(250,380,300,40);
            jb.setBackground(Color.PINK);
            jb.setForeground(Color.WHITE);
            jb.setFocusPainted(false);
            jp.add(jlName);
            jp.add(jlNameContent);
            jp.add(jlPrice);
            jp.add(jlPriceConter);
            jp.add(jlStatus);
            jp.add(jlStatusConter);
            jp.add(jlBorrower);
            jp.add(jlBorrowerConter);
            jp.add(jlBorrowTime);
            jp.add(jlBorrowTimeConter);
            jp.add(jlReturnTime);
            jp.add(jlReturnTimeConter);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        int confirmDialog = JOptionPane.showConfirmDialog(null, "请确定是否删除此书籍", "确认删除", JOptionPane.YES_NO_OPTION);
                        if (confirmDialog == JOptionPane.YES_OPTION) {
                            int selectedRow = jt.getSelectedRow();
                            dataV.remove(selectedRow);
                            defaultTableModel.setDataVector(dataV, titlesV);
                            try {
                                int flag = bookMessageController.deleteBook(userVo.getStudentNumber(), jlName.getText());
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                            setVisible(false);
                        } else {
                            setVisible(false);
                        }

                    }
            });
            jp.add(jb);
            add(jp);
        }
    }

    //增加书籍的弹出对话框
    private class MyDialogInsert extends JDialog {
        public MyDialogInsert() {

            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            setTitle("增加书籍");
            setModal(true);
            setSize(800, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JLabel jlName = new JLabel("书籍名称:",JLabel.CENTER);
            jlName.setFont(new Font("微软黑体",Font.BOLD,20));
            jlName.setBounds(150,10,200,80);
            JTextField jlNameContent = new JTextField();
            jlNameContent.setBounds(360,30,200,40);
            jlNameContent.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlNameContent.setHorizontalAlignment(JTextField.CENTER);

            JLabel jlOwner = new JLabel("书籍拥有者:",JLabel.CENTER);
            jlOwner.setFont(new Font("微软黑体",Font.BOLD,20));
            jlOwner.setBounds(150,100,200,80);
            JLabel jlOwnerConter = new JLabel(userVo.getName());
            jlOwnerConter.setBounds(260,100,400,80);
            jlOwnerConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlOwnerConter.setHorizontalAlignment(JTextField.CENTER);


            JLabel jlOwnerStudnetId = new JLabel("拥有者学号:",JLabel.CENTER);
            jlOwnerStudnetId.setFont(new Font("微软黑体",Font.BOLD,20));
            jlOwnerStudnetId.setBounds(150,190,200,80);
            JLabel jlOwnerStudentIdConter = new JLabel(userVo.getStudentNumber().toString());
            jlOwnerStudentIdConter.setBounds(260,190,400,80);
            jlOwnerStudentIdConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlOwnerStudentIdConter.setHorizontalAlignment(JTextField.CENTER);

            JLabel jlPrice = new JLabel("书籍价格:",JLabel.CENTER);
            jlPrice.setFont(new Font("微软黑体",Font.BOLD,20));
            jlPrice.setBounds(150,280,200,80);
            JTextField jlPriceConter = new JTextField();
            jlPriceConter.setBounds(360,300,200,40);
            jlPriceConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlPriceConter.setHorizontalAlignment(JTextField.CENTER);

            JButton jb = new JButton("确定添加");
            jb.setBounds(150,380,500,60);
            jb.setFont(new Font("微软雅黑", Font.BOLD, 15));
            jb.setBackground(Color.PINK);
            jb.setForeground(Color.WHITE);
            jb.setFocusPainted(false);
            JPanel jp = new JPanel();
            jp.setBounds(0,0,800,500);
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
                        vector.add(jlPriceConter.getText().trim());
                        dataV.add(vector);
                        BookVo bookVo = new BookVo();
                        bookVo.setBookName(jlNameContent.getText());
                        bookVo.setBookPrice(Double.valueOf(jlPriceConter.getText()));
                        UserVo userVo = userController.queryUserByStudentNumber(Integer.valueOf(jlOwnerStudentIdConter.getText()));
                        bookVo.setBookUserVo(userVo);
                        try {
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

    // 借阅书籍对话框
    private class BorrowBookDialog extends JDialog {

        public BorrowBookDialog(int borrowSelectColmn) {

            ImageIcon imageIcon = new ImageIcon("src/main/java/tyut/selab/desktop/ui/book/ddot.png");
            setIconImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

            setTitle("借阅书籍");
            setModal(true);
            setSize(800, 500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JLabel jlName = new JLabel("书籍名称:",JLabel.CENTER);
            jlName.setFont(new Font("微软黑体",Font.BOLD,20));
            jlName.setBounds(150,30,200,40);
            JLabel jlNameContent = new JLabel((String) dataV.get(borrowSelectColmn).get(0),JLabel.CENTER);
            jlNameContent.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlNameContent.setBounds(260,30,400,40);

            JLabel jlBorrowName = new JLabel("书籍拥有者:",JLabel.CENTER);
            jlBorrowName.setFont(new Font("微软黑体",Font.BOLD,20));
            jlBorrowName.setBounds(150,85,200,40);
            JLabel jlBorrowConter = new JLabel((String) dataV.get(borrowSelectColmn).get(1),JLabel.CENTER);
            jlBorrowConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlBorrowConter.setBounds(260,85,400,40);

            JLabel jlStudentId = new JLabel("拥有者学号:",JLabel.CENTER);
            jlStudentId.setFont(new Font("微软黑体",Font.BOLD,20));
            jlStudentId.setBounds(150,140,200,40);
            JLabel jlStudentIdConter = new JLabel(dataV.get(borrowSelectColmn).get(2).toString(),JLabel.CENTER);
            jlStudentIdConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlStudentIdConter.setBounds(260,140,400,40);

            JLabel jlPrice = new JLabel("书籍价格:",JLabel.CENTER);
            jlPrice.setFont(new Font("微软黑体",Font.BOLD,20));
            jlPrice.setBounds(150,195,200,40);
            JLabel jlPriceConter = new JLabel(dataV.get(borrowSelectColmn).get(3).toString(),JLabel.CENTER);
            jlPriceConter.setFont(new Font("微软黑体",Font.PLAIN,20));
            jlPriceConter.setBounds(260,195,400,40);

            JLabel jlReturnTime = new JLabel("借阅时间",JLabel.CENTER);
            jlReturnTime.setFont(new Font("微软黑体",Font.BOLD,20));
            jlReturnTime.setBounds(150,250,200,40);

            JRadioButton rb1 = new JRadioButton("3天", true);
            // 创建单选按钮，并且默认已选中
            JRadioButton rb2 = new JRadioButton("5天", false);
            // 创建单选按钮，并且默认未选中
            JRadioButton rb3 = new JRadioButton("7天", false);
            rb1.setBounds(360,250,60,40);
            rb2.setBounds(430 ,250,60,40);
            rb3.setBounds(500,250,60,40);
            rb1.setBackground(Color.white);
            rb2.setBackground(Color.white);
            rb3.setBackground(Color.white);
            rb1.setFont(new Font("微软黑体",Font.BOLD,20));
            rb2.setFont(new Font("微软黑体",Font.BOLD,20));
            rb3.setFont(new Font("微软黑体",Font.BOLD,20));

            ButtonGroup group = new ButtonGroup(); // 创建一个按钮小组
            group.add(rb1); // 把单选按钮1加入到按钮小组
            group.add(rb2); // 把单选按钮2加入到按钮小组
            group.add(rb3); // 把单选按钮3加入到按钮小组

            JPanel jp = new JPanel();
            jp.setSize(800,500);
            jp.setBackground(Color.WHITE);
            jp.setLayout(null);
            add(jp);

            JButton jb = new JButton("确认借阅");
            jb.setFont(new Font("微软黑体",Font.BOLD,15));
            jb.setBounds(150,350,500,60);
            jb.setBackground(Color.PINK);
            jb.setForeground(Color.WHITE);
            jb.setFocusPainted(false);

            jp.add(jlName);
            jp.add(jlNameContent);
            jp.add(jlBorrowName);
            jp.add(jlBorrowConter);
            jp.add(jlStudentId);
            jp.add(jlStudentIdConter);
            jp.add(jlPrice);
            jp.add(jlPriceConter);
            jp.add(jlReturnTime);
            jp.add(rb1);
            jp.add(rb2);
            jp.add(rb3);
            jp.add(jb);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BookVo bookVo = null;
                    try {
                        bookVo = bookMessageController.queryBookLog(Integer.valueOf(jlStudentIdConter.getText()),jlNameContent.getText());
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
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String nowFormat = simpleDateFormat.format(date);
                    bookVo.setBorrowBookUserVo(userVo);
                    bookVo.setBorrowBookTime(date);
                    String info = null;
                    for(Component c:jp.getComponents()){
                        if(c instanceof JRadioButton){
                            if(((JRadioButton) c).isSelected()){
                                info = ((JRadioButton)c).getText();
                            }
                        }
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE, info.charAt(0));
                    Date time = calendar.getTime();
                    bookVo.setReturnBookTime(time);
                    try {
                        bookBorrowController.borrowBook(bookVo);
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
                    dataV.get(borrowSelectColmn).set(4,"已借出");
                    dataV.get(borrowSelectColmn).set(5,userVo.getName());
                    dataV.get(borrowSelectColmn).set(6,nowFormat);
//                    dataV.get(borrowSelectColmn).set(7,)
                    defaultTableModel.setDataVector(dataV,titlesV);
                    JOptionPane.showMessageDialog(null, "借阅成功", "借阅信息", JOptionPane.WARNING_MESSAGE);
                    setVisible(false);
                  }
            });
        }
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

    // 查看借阅书籍表头
    public Vector<String> getTitleBorrowBook(){
        Vector<String> vector = new Vector<>();
        vector.add("书籍名称");
        vector.add("书籍拥有者");
        vector.add("书籍价格");
        vector.add("借阅时间");
        vector.add("承诺归还时间");
        return  vector;
    }

    //  封装查看借阅书籍信息
    public Vector<Vector> getDataBorrowBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Vector<Vector> dataV = new Vector<>();
        List<BookVo> bookVos = bookMessageController.queryAllBook();
        for (int i = 0; i < bookVos.size(); i++) {
            if(bookVos.get(i).getBorrowBookUserVo().getStudentNumber().equals(userVo.getStudentNumber())) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:mm");
                Vector vector = new Vector();
                vector.add(bookVos.get(i).getBookName());
                vector.add(bookVos.get(i).getBookUserVo().getName());
                vector.add(bookVos.get(i).getBookPrice());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
                dataV.add(vector);
            }
        }
        return dataV;
    }

    // 封装用户书籍表头
    public Vector getTitleMyBook(){
        Vector vector = new Vector();
        vector.add("书籍名称");
        vector.add("书籍价格");
        vector.add("书籍状态");
        vector.add("书籍借阅人");
        vector.add("书籍借阅时间");
        vector.add("书籍归还时间");
        return vector;
    }

    // 封装用户书籍信息
    public Vector<Vector> getDataMyBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageController.queryBookByUserid(userVo.getStudentNumber());
        Vector<Vector> valuesV = new Vector<>();
        for (int i = 0; i < bookVos.size(); i++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:mm");
            Vector vector = new Vector();
            vector.add(bookVos.get(i).getBookName());
            vector.add(bookVos.get(i).getBookPrice());
            vector.add(bookVos.get(i).getBookStatus()== Book.LENDABLE ?"未借出":"已借出");
            if(bookVos.get(i).getBookStatus() == Book.LENDED) {
                vector.add(bookVos.get(i).getBorrowBookUserVo().getName());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
            }else{
                vector.add("");
                vector.add("");
                vector.add("");
            }
            valuesV.add(vector);
        }
        return valuesV;
    }

    // 封装用户借阅的书籍表头信息
    public Vector<String> getTitlesReturnBook(){
        Vector<String> vector = new Vector<>();
        vector.add("书籍名称");
        vector.add("书籍拥有者");
        vector.add("拥有者学号");
        vector.add("书籍价格");
        vector.add("借阅时间");
        vector.add("归还时间");
        return vector;
    }

    // 封装用户借阅的书籍
    public Vector<Vector> getDataReturnBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageController.quereyBorrowBookByBorrowerId(userVo.getStudentNumber());
        Vector<Vector> dataV = new Vector<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:mm:");
        for (int i = 0; i < bookVos.size(); i++) {
                Vector vector = new Vector();
                vector.add(bookVos.get(i).getBookName());
                vector.add(bookVos.get(i).getBookUserVo().getName());
                vector.add(bookVos.get(i).getBookUserVo().getStudentNumber());
                vector.add(bookVos.get(i).getBookPrice());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
                dataV.add(vector);

        }
        return dataV;
    }

}