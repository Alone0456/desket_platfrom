package tyut.selab.desktop.moudle.book.bookservice.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.bookdao.impl.BookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.impl.BookMessageDao;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.SQLException;

public class BookBorrowService implements IBookBorrowService {

    private IBookBorrowDao bookBorrowDao = new BookBorrowDao();

    private IBookMessageDao bookMessageDao = new BookMessageDao();
    private IBookBorrowService bookBorrowService = new BookBorrowService();
    private IUserDao userDao;

    @Override
    public BookVo borrowBook(BookVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Book newBook = new Book();
        newBook.setUserStudentNumber(book.getBookUserVo().getStudentNumber());
        newBook.setBookName(book.getBookName());
        newBook.setBookPrice(book.getBookPrice());
        newBook.setBookStatus(book.getBookStatus());
        int flag = bookMessageDao.updateBookStatus(Book.LENDED, newBook);
        String bookName = book.getBookName();
        Integer studentNumber = book.getBookUserVo().getStudentNumber();
        Book queryBook = bookMessageDao.queryAsBook(studentNumber, bookName);
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
        for (int i = 0; i < bookBorrows.size(); i++) {
            if(bookBorrows.get(i).getBookId() == queryBook.getBookId()){
                User user = userDao.queryUserByStudentNumber(bookBorrows.get(i).getBorrowUserStudentNumber());
                UserVo userVo = userChangeUserVo(user);
                book.setBorrowBookUserVo(userVo);
                book.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
                book.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
                break;
            }
            }
        return book;
        }
    private UserVo userChangeUserVo(User user) {
        UserVo userVo = new UserVo();
        userVo.setName(user.getName());
        userVo.setGender(user.getGender());
        Integer roleId = user.getRoleId();
        String role = userDao.queryIdRole(roleId);
        userVo.setDuty(role);
        userVo.setStudentNumber(user.getStudentNumber());
        userVo.setPhone(user.getPhone());
        userVo.setPost(user.getPost());
        userVo.setAccountNumber(user.getAccountNumber());
        return userVo;
    }

    @Override
    public BookVo returnBook(BookVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Book newBook = bookMessageDao.queryAsBook(book.getBookUserVo().getStudentNumber(), book.getBookName());
        BookBorrow bookBorrow = new BookBorrow();
        bookBorrow.setBookId(newBook.getBookId());
        int flag = bookBorrowDao.deleteBorrowBook(bookBorrow);
        int flag1 = bookMessageDao.updateBookStatus(Book.LENDABLE, newBook);

         return book;
    }
        @Override
    public int updateBookReturnTime(Date returnTime, BookVo bookVo) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            String bookName = bookVo.getBookName();
            Integer studentNumber = bookVo.getBookUserVo().getStudentNumber();
            Book book = bookMessageDao.queryAsBook(studentNumber, bookName);
            List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
            for (int i = 0; i < bookBorrows.size(); i++) {
                if(bookBorrows.get(i).getBookId() == book.getBookId()){
                    bookBorrows.get(i).setReturnBookTime(returnTime);
                }
            }
            return 1;
    }

    @Override
    public List<BookVo> exceedReturnTimeList() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
        List<BookVo> bookVos = new ArrayList<>();
        for (int i = 0; i < bookBorrows.size(); i++) {
            if(bookBorrows.get(i).getReturnBookTime().after(new Date())){
                BookVo bookVo = new BookVo();
                bookVo.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
                bookVo.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
                Integer userStudentNumber = bookBorrows.get(i).getUserStudentNumber();
                Integer borrowUserStudentNumber = bookBorrows.get(i).getBorrowUserStudentNumber();
                User userUser = userDao.queryUserByStudentNumber(userStudentNumber);
                User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
                UserVo userUserVo = userChangeUserVo(userUser);
                UserVo userBorrowVo = userChangeUserVo(userBorrow);
                bookVo.setBookUserVo(userUserVo);
                bookVo.setBorrowBookUserVo(userBorrowVo);
                List<Book> books = bookMessageDao.queryBookByUserid(userStudentNumber);
                for (int j = 0; j < books.size(); j++) {
                   if(books.get(i).getBookId() == bookBorrows.get(i).getBookId()){
                       bookVo.setBookName(books.get(i).getBookName());
                       bookVo.setBookPrice(books.get(i).getBookPrice());
                       bookVo.setBookStatus(books.get(i).getBookStatus());
                   }
                }
                bookVos.add(bookVo);
            }
        }
        return bookVos;
    }
}
