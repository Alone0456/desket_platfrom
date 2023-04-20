package tyut.selab.desktop.moudle.book.bookdao;


import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;

import java.util.List;

public interface IBookMessageDao {
    /**
     * 查询指定书籍
     * @param userStudentNumber
     * @param bookName
     * @return
     */
    Book queryAsBook(Integer userStudentNumber,String bookName);

    /**
     * 查询借书记录
     * @return
     */
    List<BookBorrow> queryBorrowBookLog();

    /**
     * 根据书名来查询借书记录
     * @param bookName
     * @return
     */
    List<BookBorrow> queryBorrowBookLog(String bookName);

    /**
     * 根据学号来查询借书记录
     * @param studentNumber
     * @return
     */
    List<BookBorrow> queryBorrowBookLog(Integer studentNumber);

    /**
     * 查询全部图书
     * @return 图书列表
     */
    List<Book> queryAllBook();

    /**
     * 通过图书名字查询图书
     * @param bookName 书名
     * @return 图书列表
     */
    List<Book> queryBookByBookName(String bookName);

    /**
     * 通过用户id查询该用户的图书
     * @param userStudentNumber 用户学号
     * @return 图书列表
     */
    List<Book> queryBookByUserid(Integer userStudentNumber);

    /**
     * 增加图书
     * @param book 书
     * @return 成功返回1，失败返回-1
     */
    int insertBook(Book book);

    /**
     * 修改图书信息
     * @param newBook
     * @param oldBook
     * @return
     */
    int updateBook(Book newBook,Book oldBook);

    /**
     * 通过书名，修改图书状态
     * @param status
     * @param book
     * @return 成功返回1，失败返回-1
     */
    int updateBookStatus(int status,Book book);

    /**
     * 删除图书
     * @param userStudentNumber 用户学号
     * @param bookName 书名
     * @return 成功返回1，失败返回-1
     */
    int deleteBook(Integer userStudentNumber,String bookName);
}
