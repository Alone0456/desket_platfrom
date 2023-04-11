package tyut.selab.desktop.moudle.book.bookcontroller;

import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.util.List;

public interface IBookMessageController {
    /**
     * 查询借书记录
     * @return
     * 管理员
     */
    List<BookVo> queryBorrowBookLog();

    /**
     * 查询某本书的借书记录
     * @param bookName
     * @param userStudentNumber
     * @return
     * 管理员
     */
    BookVo queryBorrowBookLog(String bookName,Integer userStudentNumber);

    /**
     * 根据书名来查询借书记录
     * @param bookName
     * @return
     * 管理员
     */
    List<BookVo> queryBorrowBookLog(String bookName);

    /**
     * 根据学号来查询借书记录
     * @param studentNumber
     * @return
     * 管理员
     */
    List<BookVo> queryBorrowBookLog(Integer studentNumber);

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
