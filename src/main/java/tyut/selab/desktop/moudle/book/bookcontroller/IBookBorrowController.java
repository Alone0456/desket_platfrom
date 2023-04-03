package tyut.selab.desktop.moudle.book.bookcontroller;

import tyut.selab.desktop.moudle.book.domain.Book;

public interface IBookBorrowController {
    /**
     * 借书
     * @param book
     * @return 成功返回1,失败返回-1
     */
    int borrowBook(Book book);

    /**
     * 还书
     * @param book
     * @return 成功返回1,失败返回-1
     */
    int returnBook(Book book);
}
