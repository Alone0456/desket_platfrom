package tyut.selab.desktop.moudle.book.bookdao.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;
import tyut.selab.desktop.utils.book_GetConnection;

import java.sql.SQLException;

public class BookBorrowDao implements IBookBorrowDao {
    book_GetConnection connection = new book_GetConnection();
    @Override
    public int updateBookReturnBookTime(BookBorrow newBook, BookBorrow oldBook) throws SQLException {
        String sql = "UPDATE user_book_borrow SET return_book_time = ? WHERE book_id = ?;";
        int flag = connection.executeUpdate(sql, newBook.getReturnBookTime(),oldBook.getBookId());
        if(flag>0){
            return 1;
        }
        return -1;

    }

    @Override
    public int insertBorrowBookMessage(BookBorrow bookBorrow) throws SQLException {
        String sql = "insert into user_book_borrow (user_student_number,book_id,borrow_user_student_number,borrow_book_time,return_book_time) values (?,?,?,?)";
        int flag = connection.executeUpdate(sql, bookBorrow.getUserStudentNumber(), bookBorrow.getBookId(), bookBorrow.getBorrowUserStudentNumber(), bookBorrow.getBorrowBookTime(), bookBorrow.getReturnBookTime());
        if(flag>0){
            return 1;
        }
        return -1;
    }

    @Override
    public int deleteBorrowBook(BookBorrow bookBorrow) throws SQLException {
        String sql = "DELETE FROM user_book_borrow WHERE book_id = ?;";
        int flag = connection.executeUpdate(sql, bookBorrow.getBookId());
        if(flag>0){
            return 1;
        }
        return -1;
    }
}
