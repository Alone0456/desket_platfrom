package tyut.selab.desktop.moudle.book.bookservice.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.bookdao.impl.BookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.impl.BookMessageDao;
import tyut.selab.desktop.moudle.book.bookservice.IBookMessageService;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMessageService implements IBookMessageService {
    private IBookMessageDao bookMessageDao = new BookMessageDao();
    private IBookBorrowDao bookBorrowDao = new BookBorrowDao();

    private IUserDao userDao = new UserDao();

    @Override
    public List<BookVo> queryBorrowBookLog() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
        List<BookVo> bookVos = new ArrayList<>();
        for (int i = 0; i < bookBorrows.size(); i++) {
            BookVo bookVo = new BookVo();
            Integer borrowUserStudentNumber = bookBorrows.get(i).getBorrowUserStudentNumber();
            User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
            UserVo userVoBorrow = userChangeUserVo(userBorrow);
            bookVo.setBorrowBookUserVo(userVoBorrow);
            Integer userStudentNumber = bookBorrows.get(i).getUserStudentNumber();
            User userUser = userDao.queryUserByStudentNumber(userStudentNumber);
            UserVo userVoUser = userChangeUserVo(userUser);
            bookVo.setBookUserVo(userVoUser);
            bookVo.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
            bookVo.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
            List<Book> books = bookMessageDao.queryBookByUserid(bookBorrows.get(i).getUserStudentNumber());
            for (int j = 0; j < books.size(); j++) {
             if(books.get(j).getBookId() == bookBorrows.get(i).getBookId()){
                 bookVo.setBookName(books.get(j).getBookName());
                 bookVo.setBookPrice(books.get(j).getBookPrice());
                 bookVo.setBookStatus(books.get(j).getBookStatus());
                 bookVos.add(bookVo);
                 break;
             }
            }
        }
        return bookVos;
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
    public BookVo queryBorrowBookLog(String bookName, Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Book book = bookMessageDao.queryAsBook(userStudentNumber, bookName);
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
        BookVo bookVo = new BookVo();
        for (int i = 0; i < bookBorrows.size(); i++) {
            if (bookBorrows.get(i).getBookId() == book.getBookId()) {
                Integer borrowUserStudentNumber = bookBorrows.get(i).getBorrowUserStudentNumber();
                User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
                UserVo userVoBorrow = userChangeUserVo(userBorrow);
                bookVo.setBorrowBookUserVo(userVoBorrow);
                User userUser = userDao.queryUserByStudentNumber(userStudentNumber);
                UserVo userVoUser = userChangeUserVo(userUser);
                bookVo.setBookUserVo(userVoUser);
                bookVo.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
                bookVo.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
                bookVo.setBookName(book.getBookName());
                bookVo.setBookPrice(book.getBookPrice());
                bookVo.setBookStatus(book.getBookStatus());
            }
        }
        return bookVo;
    }

    @Override
    public List<BookVo> queryBorrowBookLog(String bookName) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = new ArrayList<>();
        BookMessageService bookMessageService = new BookMessageService();
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog(bookName);
        List<Book> books = bookMessageDao.queryBookByBookName(bookName);
        for (int i = 0; i < bookBorrows.size(); i++) {
            for (int j = 0; j < books.size(); j++) {
                if(books.get(j).getBookId() == bookBorrows.get(i).getBookId()) {
                    BookVo bookVo = new BookVo();
                    Integer borrowUserStudentNumber = bookBorrows.get(i).getBorrowUserStudentNumber();
                    User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
                    UserVo userVoBorrow = bookMessageService.userChangeUserVo(userBorrow);
                    bookVo.setBorrowBookUserVo(userVoBorrow);
                    Integer userStudentNumber = bookBorrows.get(i).getUserStudentNumber();
                    User userUser = userDao.queryUserByStudentNumber(userStudentNumber);
                    UserVo userVoUser = userChangeUserVo(userUser);
                    bookVo.setBookUserVo(userVoUser);
                    bookVo.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
                    bookVo.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
                    bookVo.setBookName(books.get(j).getBookName());
                    bookVo.setBookPrice(books.get(j).getBookPrice());
                    bookVo.setBookStatus(books.get(j).getBookStatus());
                    bookVos.add(bookVo);
                    break;
                }
            }
        }
        return bookVos;
    }

    @Override
    public List<BookVo> queryBorrowBookLog(Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = new ArrayList<>();
        BookMessageService bookMessageService = new BookMessageService();
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog(userStudentNumber);
        List<Book> books = bookMessageDao.queryBookByUserid(userStudentNumber);
        for (int i = 0; i < bookBorrows.size(); i++) {
            for (int j = 0; j < books.size(); j++) {
                if(books.get(j).getBookId() == bookBorrows.get(i).getBookId()) {
                    BookVo bookVo = new BookVo();
                    Integer borrowUserStudentNumber = bookBorrows.get(i).getBorrowUserStudentNumber();
                    User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
                    UserVo userVoBorrow = userChangeUserVo(userBorrow);
                    bookVo.setBorrowBookUserVo(userVoBorrow);
                    User userUser = userDao.queryUserByStudentNumber(userStudentNumber);
                    UserVo userVoUser = userChangeUserVo(userUser);
                    bookVo.setBookUserVo(userVoUser);
                    bookVo.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
                    bookVo.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
                    bookVo.setBookName(books.get(j).getBookName());
                    bookVo.setBookPrice(books.get(j).getBookPrice());
                    bookVo.setBookStatus(books.get(j).getBookStatus());
                    bookVos.add(bookVo);
                    break;
                }
                }
            }
        return bookVos;
    }

        @Override
        public List<BookVo> queryAllBook () throws
        NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            List<Book> books = bookMessageDao.queryAllBook();
            List<BookVo> bookVos = new ArrayList<>();
            List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
            books.forEach((book -> {
                if (book.getBookStatus() == Book.LENDABLE) {
                    Integer userStudentNumber = book.getUserStudentNumber();
                    User user = userDao.queryUserByStudentNumber(userStudentNumber);
                    UserVo userVo = userChangeUserVo(user);
                    BookVo bookVo = new BookVo();
                    bookVo.setBookName(book.getBookName());
                    bookVo.setBookUserVo(userVo);
                    bookVo.setBookStatus(book.getBookStatus());
                    bookVo.setBookPrice(book.getBookPrice());
                    bookVos.add(bookVo);
                } else {
                    for (int i = 0; i < bookBorrows.size(); i++) {
                        if (book.getBookId() == bookBorrows.get(i).getBookId()) {
                            Integer userStudentNumber = books.get(i).getUserStudentNumber();
                            User user = userDao.queryUserByStudentNumber(userStudentNumber);
                            UserVo userVo = userChangeUserVo(user);
                            BookVo bookVo = new BookVo();
                            bookVo.setBookUserVo(userVo);
                            bookVo.setBookName(book.getBookName());
                            bookVo.setBookStatus(book.getBookStatus());
                            bookVo.setBookPrice(book.getBookPrice());
                            bookVo.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
                            bookVo.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
                            Integer borrowUserStudentNumber = bookBorrows.get(i).getBorrowUserStudentNumber();
                            User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
                            UserVo userVoBorrow = userChangeUserVo(userBorrow);
                            bookVo.setBorrowBookUserVo(userVoBorrow);
                            bookVos.add(bookVo);
                            break;
                        }
                    }
                }
            }));
            return bookVos;
        }
        @Override
        public List<BookVo> queryBookByBookName (String bookName) throws
        SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            List<Book> books = bookMessageDao.queryBookByBookName(bookName);
            List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
            List<BookVo> bookVos = new ArrayList<>();
            books.forEach(book -> {
//            if(book.getBookStatus() == Book.LENDED){
//                for (int i = 0; i < bookBorrows.size(); i++) {
//                    if (book.getBookId() == bookBorrows.get(i).getBookId()) {
                BookVo bookVo = new BookVo();
                Integer userStudentNumber = book.getUserStudentNumber();
                User user = userDao.queryUserByStudentNumber(userStudentNumber);
                UserVo userVo = userChangeUserVo(user);
                bookVo.setBookUserVo(userVo);
                bookVo.setBookName(book.getBookName());
                bookVo.setBookStatus(book.getBookStatus());
                bookVo.setBookPrice(book.getBookPrice());
//                        bookVo.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
//                        bookVo.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
//                        Integer borrowUserStudentNumber = bookBorrows.get(i).getBorrowUserStudentNumber();
//                        User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
//                        UserVo userVoBorrow = userChangeUserVo(userBorrow);
//                        bookVo.setBorrowBookUserVo(userVoBorrow);
                bookVos.add(bookVo);
//                       break;
//                    }
//                }
//            }
            });
            return bookVos;
        }

        @Override
        public List<BookVo> queryBookByUserid (Integer userStudentNumber) throws
        SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            List<Book> books = bookMessageDao.queryBookByUserid(userStudentNumber);
            List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
            List<BookVo> bookVos = new ArrayList<>();
            books.forEach(book -> {
                BookVo bookVo = new BookVo();
                User user = userDao.queryUserByStudentNumber(userStudentNumber);
                UserVo userVo = userChangeUserVo(user);
                bookVo.setBookUserVo(userVo);
                bookVo.setBookName(book.getBookName());
                bookVo.setBookStatus(book.getBookStatus());
                bookVo.setBookPrice(book.getBookPrice());
            });
            return bookVos;
        }

        @Override
        public int insertBook (BookVo book) throws SQLException {
            Book newBook = new Book();
            newBook.setBookName(book.getBookName());
            newBook.setBookStatus(book.getBookStatus());
            newBook.setBookPrice(book.getBookPrice());
            newBook.setUserStudentNumber(book.getBookUserVo().getStudentNumber());
            int flag = bookMessageDao.insertBook(newBook);
            return flag;
        }

        @Override
        public int updateBook (BookVo book) throws SQLException {
            Book newBook = new Book();
            Book oldBook = new Book();
            oldBook.setBookName(book.getBookName());
            oldBook.setBookPrice(book.getBookPrice());
            oldBook.setBookStatus(book.getBookStatus());
            oldBook.setUserStudentNumber(book.getBookUserVo().getStudentNumber());
            newBook.setBookName(book.getBookName());
            newBook.setBookStatus(book.getBookStatus());
            newBook.setBookPrice(book.getBookPrice());
            newBook.setUserStudentNumber(book.getBookUserVo().getStudentNumber());
            int flag = bookMessageDao.updateBook(newBook,oldBook);
            return flag;
        }

        @Override
        public int deleteBook(Integer userStudentNumber,String bookName) throws SQLException {
            int flag = bookMessageDao.deleteBook(userStudentNumber, bookName);
            return flag;
        }

        private BookVo bookBorrowChangeBookVo (BookBorrow bookBorrow){
            int bookId = bookBorrow.getBookId();
            Integer borrowUserStudentNumber = bookBorrow.getBorrowUserStudentNumber();
            Integer userStudentNumber = bookBorrow.getUserStudentNumber();
            User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
            UserVo userVoBorrow = userChangeUserVo(userBorrow);
            User userUser = userDao.queryUserByStudentNumber(userStudentNumber);
            UserVo userVoUser = userChangeUserVo(userUser);
            BookVo bookVo = new BookVo();
            bookVo.setBookUserVo(userVoUser);
            bookVo.getBorrowBookUserVo();
            bookVo.setBorrowBookTime(bookBorrow.getBorrowBookTime());
            bookVo.setReturnBookTime(bookBorrow.getReturnBookTime());
            return bookVo;
        }

    }
