package tyut.selab.desktop.moudle.book.bookservice;


import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IBookBorrowService {
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
    List<BookVo> exceedReturnTimeList() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
