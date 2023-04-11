package tyut.selab.desktop.moudle.book.bookcontroller.impl;

import tyut.selab.desktop.moudle.book.bookcontroller.IBookMessageController;
import tyut.selab.desktop.moudle.book.bookservice.IBookMessageService;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.util.List;

public class BookMessageController implements  IBookMessageController{

    private IBookMessageService bookMessageService;

    @Override
    public List<BookVo> queryBorrowBookLog() {
        return null;
    }

    @Override
    public BookVo queryBorrowBookLog(String bookName, Integer userStudentNumber) {
        return null;
    }

    @Override
    public List<BookVo> queryBorrowBookLog(String bookName) {
        return null;
    }

    @Override
    public List<BookVo> queryBorrowBookLog(Integer studentNumber) {
        return null;
    }

    @Override
    public List<BookVo> queryAllBook() {
        return null;
    }

    @Override
    public List<BookVo> queryBookByBookName(String bookName) {
        return null;
    }

    @Override
    public List<BookVo> queryBookByUserid(Integer userStudentNumber) {
        return null;
    }

    @Override
    public int insertBook(BookVo book) {
        return 0;
    }

    @Override
    public int updateBook(BookVo book) {
        return 0;
    }

    @Override
    public int deleteBook(Integer userStudentNumber, String bookName) {
        return 0;
    }
}
