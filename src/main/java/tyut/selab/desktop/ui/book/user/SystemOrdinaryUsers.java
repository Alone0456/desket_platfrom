package tyut.selab.desktop.ui.book.user;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookBorrowController;
import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.ui.book.user.button.MenuJPanel;
import tyut.selab.desktop.ui.book.user.dialog.BorrowBookDialog;
import tyut.selab.desktop.ui.book.user.dialog.MyDialogInsert;
import tyut.selab.desktop.ui.book.user.dialog.MyDialogMyBook;
import tyut.selab.desktop.ui.book.user.dialog.MyDialogReturnBook;
import tyut.selab.desktop.ui.book.user.domain.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
        Data data = new Data(userVo);
        titlesV = data.getTitleVector();
        dataV = data.getDataVector(bookMessageController.queryAllBook());

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
        jt.setFont(new Font("楷书", Font.PLAIN, 15));
        jt.setRowHeight(35);
        tableHeader.setFont(new Font("楷书", Font.PLAIN, 20));
        tableHeader.setReorderingAllowed(false);
        TableColumn column = null;
        //设置列宽
        int colunms = jt.getColumnCount();
        int[] columnList = {350, 300, 400, 250, 310, 350, 450, 400};
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
        MenuJPanel menuJPanel = new MenuJPanel(dataV,titlesV,userVo,defaultTableModel,jt);
        add(menuJPanel.getMenuJPanel());
    }


}



