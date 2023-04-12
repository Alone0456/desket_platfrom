package tyut.selab.desktop.moudle.book.bookcontroller.impl;

import tyut.selab.desktop.moudle.book.bookcontroller.IBookMessageController;
import tyut.selab.desktop.moudle.book.bookservice.IBookMessageService;
import tyut.selab.desktop.moudle.book.bookservice.impl.BookMessageService;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.sql.SQLException;
import java.util.List;

public class BookMessageController implements  IBookMessageController{

    private IBookMessageService bookMessageService = new BookMessageService();

    @Override
    public List<BookVo> queryBorrowBookLog() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageService.queryBorrowBookLog();
        return bookVos;
    }

    @Override
    public BookVo queryBorrowBookLog(String bookName, Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        BookVo bookVo = bookMessageService.queryBorrowBookLog(bookName, userStudentNumber);
        return bookVo;
    }

    @Override
    public List<BookVo> queryBorrowBookLog(String bookName) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageService.queryBorrowBookLog(bookName);
        return bookVos;
    }

    @Override
    public List<BookVo> queryBorrowBookLog(Integer studentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageService.queryBorrowBookLog(studentNumber);
        return bookVos;
    }

    @Override
    public List<BookVo> queryAllBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageService.queryAllBook();
        return bookVos;
    }

    @Override
    public List<BookVo> queryBookByBookName(String bookName) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageService.queryBookByBookName(bookName);
        return bookVos;
    }

    @Override
    public List<BookVo> queryBookByUserid(Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageService.queryBookByUserid(userStudentNumber);
        return bookVos;
    }

    @Override
    public int insertBook(BookVo book) throws SQLException {
        int flag = bookMessageService.insertBook(book);
        return flag;
    }

    @Override
    public int updateBook(BookVo book) throws SQLException {
        int flag = bookMessageService.updateBook(book);
        return flag;
    }

    @Override
    public int deleteBook(Integer userStudentNumber, String bookName) throws SQLException {
        int flag = bookMessageService.deleteBook(userStudentNumber, bookName);
        return flag;
    }
}
