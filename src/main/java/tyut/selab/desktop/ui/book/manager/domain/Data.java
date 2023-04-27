package tyut.selab.desktop.ui.book.manager.domain;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookBorrowController;
import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Data {
BookMessageController bookMessageController = new BookMessageController();
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
}
