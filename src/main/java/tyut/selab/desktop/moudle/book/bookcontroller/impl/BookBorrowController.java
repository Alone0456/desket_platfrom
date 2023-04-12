package tyut.selab.desktop.moudle.book.bookcontroller.impl;

import tyut.selab.desktop.moudle.book.bookcontroller.IBookBorrowController;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.bookservice.impl.BookBorrowService;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookBorrowController implements IBookBorrowController {

    private IBookBorrowService bookBorrowService = new BookBorrowService();
    @Override
    public BookVo borrowBook(BookVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        BookVo bookVo = bookBorrowService.borrowBook(book);
        return bookVo;
    }
    @Override
    public BookVo returnBook(BookVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        BookVo bookVo = bookBorrowService.returnBook(book);
        return bookVo;

    }

    @Override
    public int updateBookReturnTime(Date returnTime, BookVo bookVo) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        int flag = bookBorrowService.updateBookReturnTime(returnTime, bookVo);
        return flag;
    }

    @Override
    public List<UserVo> exceedReturnTimeList() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookBorrowService.exceedReturnTimeList();
        List<UserVo> userVos = new ArrayList<>();
        for (int i = 0; i < userVos.size(); i++) {
            UserVo borrowBookUserVo = bookVos.get(i).getBorrowBookUserVo();
            userVos.add(borrowBookUserVo);
        }
        return userVos;
    }
}
