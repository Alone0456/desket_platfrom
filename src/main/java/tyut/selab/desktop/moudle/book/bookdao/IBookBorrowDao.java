package tyut.selab.desktop.moudle.book.bookdao;

import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;

import java.util.List;

public interface IBookBorrowDao {
    /**
     * 查询所有被借阅的图书
     * @return 图书列表
     */
    List<Book> queryAllBorrowBook(int status);

    /**
     * 查询该用户被借阅的图书
     * @param userId 用户学号
     * @return 图书列表
     */
    List<Book> queryBorrowBookByUserId(int userId);

    /**
     * 通过书名，修改图书状态
     * @param book
     * @param bookName
     * @return 成功返回1，失败返回-1
     */
    int updateBookStatus(Book book,String bookName);

    /**
     * 修改还书时间
     * @param newBook
     * @param oldBook
     * @return 成功返回1，失败返回-1
     */
    int updateBookReturnBookTime(BookBorrow newBook,BookBorrow oldBook);

    /**
     * 增加借阅信息
     * @param bookBorrow
     * @return 成功返回1，失败返回-1
     */
    int insertBorrowBookMessage(BookBorrow bookBorrow);

    /**
     * 删除借阅信息
     * @param bookBorrow
     * @return 成功返回1，失败返回-1
     */
    int deleteBorrowBook(BookBorrow bookBorrow);
}
