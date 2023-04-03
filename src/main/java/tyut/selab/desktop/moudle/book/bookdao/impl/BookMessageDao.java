package tyut.selab.desktop.moudle.book.bookdao.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.domain.Book;

import java.util.List;

public class BookMessageDao implements IBookMessageDao {
    @Override
    public List<Book> queryAllBook() {
        return null;
    }

    @Override
    public List<Book> queryBookByBookName(String bookName) {
        return null;
    }

    @Override
    public List<Book> queryBookByUserid(int userId) {
        return null;
    }

    @Override
    public int insertBook(Book book) {
        return 0;
    }

    @Override
    public int updateBook(Book book) {
        return 0;
    }

    @Override
    public int deleteBook(int userId, String bookName) {
        return 0;
    }
}
