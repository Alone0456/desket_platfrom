package tyut.selab.desktop.moudle.book.bookcontroller;

import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IBookBorrowController {
    /**
     * 借书
     * @param book
     * @return 借书的信息
     */
    BookVo borrowBook(BookVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 还书
     * @param book
     * @return
     */
    BookVo returnBook(BookVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 更新书籍还书时间
     * @param returnTime
     * @param bookVo
     * @return
     */
    int updateBookReturnTime(Date returnTime, BookVo bookVo) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 逾期还书黑名单
     * @return
     */
    List<UserVo> exceedReturnTimeList() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
