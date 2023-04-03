package tyut.selab.desktop.moudle.book.bookdao.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;

import java.util.List;

public class BookBorrowDao implements IBookBorrowDao {
    @Override
    public List<Book> queryAllBorrowBook(int status) {
        return null;
    }

    @Override
    public List<Book> queryBorrowBookByUserId(int userId) {
        return null;
    }

    @Override
    public int updateBookStatus(Book book, String bookName) {
        return 0;
    }

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
