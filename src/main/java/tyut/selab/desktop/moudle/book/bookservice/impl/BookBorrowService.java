package tyut.selab.desktop.moudle.book.bookservice.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

public class BookBorrowService implements IBookBorrowService {

    private IBookBorrowDao bookBorrowDao;

    private IBookMessageDao bookMessageDao;

    private IUserDao userDao;
    @Override
    public BookBorrowVo borrowBook(BookVo book) {
        return null;
    }

    @Override
    public BookVo returnBook(BookBorrowVo book) {
        return null;
    }
}
