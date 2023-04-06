package tyut.selab.desktop.moudle.book.bookcontroller.impl;

import tyut.selab.desktop.moudle.book.bookcontroller.IBookBorrowController;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

public class BookBorrowController implements IBookBorrowController {

    private IBookBorrowService bookBorrowService;

    @Override
    public BookBorrowVo borrowBook(BookVo book) {
        return null;
    }

    @Override
    public BookVo returnBook(BookBorrowVo book) {
        return null;
    }
}
