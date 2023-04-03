package tyut.selab.desktop.moudle.book.bookservice;


import tyut.selab.desktop.moudle.book.domain.Book;

public interface IBookBorrowService {
    /**
     * 借书
     * @param book
     * @return 借书的信息
     */
    int borrowBook(Book book);

    /**
     * 还书
     * @param book
     * @return
     */
    int returnBook(Book book);
}
