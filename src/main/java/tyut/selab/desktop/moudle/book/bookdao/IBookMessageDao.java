package tyut.selab.desktop.moudle.book.bookdao;


import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;

import java.sql.SQLException;
import java.util.List;

public interface IBookMessageDao {
    /**
     * 查询指定书籍
     * @param userStudentNumber
     * @param bookName
     * @return
     */
    Book queryAsBook(Integer userStudentNumber,String bookName) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 查询借书记录
     * @return
     */
    List<BookBorrow> queryBorrowBookLog() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 根据书名来查询借书记录
     * @param bookName
     * @return
     */
    List<BookBorrow> queryBorrowBookLog(String bookName) throws SQLException, ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    /**
     * 根据书的拥有者学号来查询借书记录
     * @param studentNumber
     * @return
     */
    List<BookBorrow> queryBorrowBookLog(Integer studentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 查询全部图书
     * @return 图书列表
     */
    List<Book> queryAllBook() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    /**
     * 通过图书名字查询图书
     * @param bookName 书名
     * @return 图书列表
     */
    List<Book> queryBookByBookName(String bookName) throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    /**
     * 通过用户id查询该用户的图书
     * @param userStudentNumber 用户学号
     * @return 图书列表
     */
    List<Book> queryBookByUserid(Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 增加图书
     * @param book 书
     * @return 成功返回1，失败返回-1
     */
    int insertBook(Book book) throws SQLException;

    /**
     * 修改图书信息
     * @param newBook
     * @param oldBook
     * @return
     */
    int updateBook(Book newBook,Book oldBook) throws SQLException;

    /**
     * 通过书名，修改图书状态
     * @param status
     * @param book
     * @return 成功返回1，失败返回-1
     */
    int updateBookStatus(int status,Book book) throws SQLException;

    /**
     * 删除图书
     * @param userStudentNumber 用户学号
     * @param bookName 书名
     * @return 成功返回1，失败返回-1
     */
    int deleteBook(Integer userStudentNumber,String bookName) throws SQLException;

}
