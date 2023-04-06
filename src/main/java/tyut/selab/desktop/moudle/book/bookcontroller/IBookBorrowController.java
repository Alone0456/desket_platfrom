package tyut.selab.desktop.moudle.book.bookcontroller;

import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

public interface IBookBorrowController {
    /**
     * 借书
     * @param book
     * @return 成功返回1,失败返回-1
     */
    BookBorrowVo borrowBook(BookVo book);

    /**
     * 还书
     * @param book
     * @return 成功返回1,失败返回-1
     */
    BookVo returnBook(BookBorrowVo book);
}
