package tyut.selab.desktop.moudle.book.bookservice.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

import javax.xml.crypto.Data;
import java.util.List;

public class BookBorrowService implements IBookBorrowService {

    private IBookBorrowDao bookBorrowDao;

    private IBookMessageDao bookMessageDao;

    private IUserDao userDao;

    @Override
    public BookVo borrowBook(BookVo book) {
        return null;
    }

    @Override
    public BookVo returnBook(BookVo book) {
        return null;
    }

    @Override
    public int updateBookReturnTime(Data returnTime, BookVo bookVo) {
        return 0;
    }

    @Override
    public List<BookVo> exceedReturnTimeList() {
        return null;
    }
}
