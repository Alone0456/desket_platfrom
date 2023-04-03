package tyut.selab.desktop.moudle.book.bookcontroller.impl;

import tyut.selab.desktop.moudle.book.bookcontroller.IBookMessageController;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.util.List;

public class BookMessageController implements IBookMessageController {
    @Override
    public List<BookVo> queryAllBook() {
        return null;
    }

    @Override
    public List<BookVo> queryBookByBookName(String bookName) {
        return null;
    }

    @Override
    public List<BookVo> queryBookByUserid(int userId) {
        return null;
    }

    @Override
    public int insertBook(Book book) {
        return 0;
    }

    @Override
    public BookVo updateBook(Book book) {
        return null;
    }

    @Override
    public int deleteBook(int userId, String bookName) {
        return 0;
    }
}
