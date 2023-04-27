package tyut.selab.desktop.moudle.book.bookdao.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;

public class BookBorrowDao implements IBookBorrowDao {
    @Override
    public int updateBookReturnBookTime(BookBorrow newBook, BookBorrow oldBook) {
        return 0;
    }

    @Override
    public int insertBorrowBookMessage(BookBorrow bookBorrow) {
        return 0;
    }

    @Override
    public int deleteBorrowBook(BookBorrow bookBorrow) {
        return 0;
    }
}
