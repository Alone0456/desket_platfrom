package tyut.selab.desktop.moudle.book.bookcontroller;

import tyut.selab.desktop.moudle.book.domain.Book;

public interface IBookBorrowController {
    /**
     * 借书
     * @param book
     * @return
     */
    int borrowBook(Book book);

    /**
     * 还书
     * @param book
     * @return
     */
    int returnBook(Book book);
}
