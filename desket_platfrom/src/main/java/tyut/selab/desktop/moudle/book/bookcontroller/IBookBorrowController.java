package tyut.selab.desktop.moudle.book.bookcontroller;

import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.xml.crypto.Data;
import java.util.List;

public interface IBookBorrowController {
    /**
     * 借书
     * @param book
     * @return 借书的信息
     */
    BookVo borrowBook(BookVo book);

    /**
     * 还书
     * @param book
     * @return
     */
    BookVo returnBook(BookVo book);

    /**
     * 更新书籍还书时间
     * @param returnTime
     * @param bookVo
     * @return
     */
    int updateBookReturnTime(Data returnTime, BookVo bookVo);

    /**
     * 逾期还书黑名单
     * @return
     */
    List<UserVo> exceedReturnTimeList();
}
