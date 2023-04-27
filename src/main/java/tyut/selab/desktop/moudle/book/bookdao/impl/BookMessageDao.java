package tyut.selab.desktop.moudle.book.bookdao.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;
import tyut.selab.desktop.utils.book_GetConnection;

import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMessageDao implements IBookMessageDao{
    book_GetConnection connection = new book_GetConnection();
    @Override
    public List<BookBorrow> queryBorrowBookLog() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql  = "SELECT user_student_number as userStudentNumber,book_id as bookId,borrow_user_student_number as borrowUserStudentNumber,borrow_book_time as borrowBookTime,return_book_time as returnBookTime FROM user_book_borrow;";
        List<BookBorrow> bookBorrows = connection.executeQuery(BookBorrow.class, sql);
        return bookBorrows;
    }

    @Override
    public List<BookBorrow> queryBorrowBookByBorrowerId(Integer borrowerId) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT user_student_number as userStudentNumber,book_id as bookId,borrow_user_student_number as borrowUserStudentNumber,borrow_book_time as borrowBookTime,return_book_time as returnBookTime FROM user_book_borrow WHERE borrow_user_student_number = ?;";
        List<BookBorrow> bookBorrows = connection.executeQuery(BookBorrow.class, sql, borrowerId);
        return bookBorrows;
    }

    @Override
   public List<BookBorrow> queryBorrowBookLog(Integer studentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
               String sql = "SELECT user_student_number as userStudentNumber,book_id as bookId,borrow_user_student_number as borrowUserStudentNumber,borrow_book_time as borrowBookTime,return_book_time as returnBookTime FROM user_book_borrow WHERE user_student_number = ?;";
               List<BookBorrow> bookBorrows = connection.executeQuery(BookBorrow.class, sql, studentNumber);
             return bookBorrows;
   }

    @Override
    public List<BookBorrow> queryBorrowBookLog(String bookName) throws SQLException, ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        List<Book> books = queryBookByBookName(bookName);
        List<BookBorrow> bookBorrows = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            String sql = "SELECT user_student_number as userStudentNumber,book_id as bookId,borrow_user_student_number as borrowUserStudentNumber,borrow_book_time as borrowBookTime,return_book_time as returnBookTime FROM user_book_borrow WHERE book_id = ?;";
            List<BookBorrow> bookBorrow = connection.executeQuery(BookBorrow.class, sql, books.get(i).getBookId());
            bookBorrows.add(bookBorrow.get(0));
        }
        return bookBorrows;
    }

    @Override
    public List<Book> queryAllBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT book_id as bookId,book_name as bookName,user_student_number as userStudentNumber,book_status as bookStatus,book_price as bookPrice FROM user_book;";
        List<Book> books = connection.executeQuery(Book.class, sql);
        return books;
    }


    @Override
    public List<Book> queryBookByBookName(String bookName) throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String sql = "SELECT book_id as bookId,book_name as bookName,user_student_number as userStudentNumber,book_status as bookStatus,book_price as bookPrice FROM user_book WHERE 1=1";
        List<String> list = new ArrayList<>();
        if(bookName !=""){
            sql+="and bookName like ?";
            list.add("%"+bookName+"%");
        }
        Object[] lists = list.toArray();
        List<Book> books = connection.executeQuery(Book.class,sql,lists);
        return books;
    }


    @Override
    public List<Book> queryBookByUserid(Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT book_id as bookId,book_name as bookName,user_student_number as userStudentNumber,book_status as bookStatus,book_price as bookPrice FROM user_book WHERE user_student_number = ?;";
        List<Book> books = connection.executeQuery(Book.class, sql, userStudentNumber);
        return books;
    }
    @Override
    public Book queryAsBook(Integer userStudentNumber, String bookName) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT book_id as bookId,book_name as bookName,user_student_number as userStudentNumber,book_status as bookStatus,book_price as bookPrice FROM user_book WHERE user_student_number = ? AND book_name = ?;";
        List<Book> books = connection.executeQuery(Book.class,sql,userStudentNumber, bookName);
        return books.get(0);

    }
    @Override
    public int updateBookStatus(int status, Book book) throws SQLException {
        String sql = "UPDATE user_book SET book_status = ? WHERE book_name = ? AND user_student_number = ?;";
        int flag = connection.executeUpdate(sql, status, book.getBookName(), book.getUserStudentNumber());
        if(flag>0){
            return 1;
        }
        return -1;
    }
    @Override
    public int insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO user_book (book_name,user_student_number,book_status,book_price) values (?,?,?,?);";
        int flag = connection.executeUpdate(sql, book.getBookName(), book.getUserStudentNumber(), book.getBookStatus(), book.getBookPrice());
        if(flag>0){
            return 1;
        }
        return -1;
    }

    @Override
    public int updateBook(Book newBook, Book oldBook) throws SQLException {
        String sql = "UPDATE user_book SET book_price = ?,book_status = ? WHERE book_id = ?;";
        int flag = connection.executeUpdate(sql, newBook.getBookPrice(), newBook.getBookStatus(), newBook.getBookId());
        return flag;
    }

    @Override
        public int deleteBook(Integer userStudentNumber, String bookName) throws SQLException {
            String sql ="DELETE FROM user_book WHERE book_name = ? AND user_student_number = ?;";
            int flag = connection.executeUpdate(sql, bookName, userStudentNumber);
            if(flag>0){
                return 1;
            }
            return -1;
        }
}
