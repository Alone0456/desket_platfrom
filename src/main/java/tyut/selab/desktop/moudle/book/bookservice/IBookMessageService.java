package tyut.selab.desktop.moudle.book.bookservice;

import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.util.List;

public interface IBookMessageService {
    /**
     * 查询借书记录
     * @return
     */
    List<BookBorrowVo> queryBorrowBookLog();

    /**
     * 根据书名/书的拥有者学号来查询借书记录
     * @param bookBorrow
     * @return
     */
    List<BookBorrowVo> queryBorrowBookLog(BookBorrowVo bookBorrow);

    /**
     * 查询全部图书
     * @return 图书列表
     */
    List<BookVo> queryAllBook();

    /**
     * 通过图书名字查询图书
     * @param bookName 书名
     * @return 图书列表
     */
    List<BookVo> queryBookByBookName(String bookName);

    /**
     * 通过用户id查询该用户的图书
     * @param userStudentNumber 用户学号
     * @return 图书列表
     */
    List<BookVo> queryBookByUserid(Integer userStudentNumber);

    /**
     * 增加图书
     * @param book 书
     * @return 成功返回1，失败返回-1
     */
    int insertBook(BookVo book);

    /**
     * 修改图书信息
     * @param book 更新
     * @return
     */
    int updateBook(BookVo book);

    /**
     * 删除图书
     * @param userStudentNumber 用户学号
     * @param bookName 书名
     * @return 成功返回1，失败返回-1
     */
    int deleteBook(Integer userStudentNumber,String bookName);
}
