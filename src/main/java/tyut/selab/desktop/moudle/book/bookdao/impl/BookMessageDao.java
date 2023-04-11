package tyut.selab.desktop.moudle.book.bookdao.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;

import java.util.List;

public class BookMessageDao implements IBookMessageDao{
    @Override
    public Book queryAsBook(Integer userStudentNumber, String bookName) {
        return null;
    }

    @Override
    public List<BookBorrow> queryBorrowBookLog() {
        return null;
    }

    @Override
    public List<BookBorrow> queryBorrowBookLog(String bookName) {
        return null;
    }

    @Override
    public List<BookBorrow> queryBorrowBookLog(Integer studentNumber) {
        return null;
    }

    @Override
    public List<Book> queryAllBook() {
        return null;
    }

    @Override
    public List<Book> queryBookByBookName(String bookName) {
        return null;
    }

    @Override
    public List<Book> queryBookByUserid(Integer userStudentNumber) {
        return null;
    }

    @Override
    public int insertBook(Book book) {
        return 0;
    }

    @Override
    public int updateBook(Book newBook, Book oldBook) {
        return 0;
    }

    @Override
    public int updateBookStatus(int status, Book book) {
        return 0;
    }

    @Override
    public int deleteBook(Integer userStudentNumber, String bookName) {
        return 0;
    }
}
