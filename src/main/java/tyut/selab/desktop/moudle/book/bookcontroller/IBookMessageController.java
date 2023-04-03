package tyut.selab.desktop.moudle.book.bookcontroller;

import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.util.List;

public interface IBookMessageController {
    /**
     * 查询全部图书
     * @return 图书列表
     */
    List<BookVo> queryAllBook();

    /**
     * 通过图名查询图书
     * @param bookName 书名
     * @return 图书列表
     */
    List<BookVo> queryBookByBookName(String bookName);

    /**
     * 通过用户id查询该用户的图书
     * @param userId 用户学号
     * @return 图书列表
     */
    List<BookVo> queryBookByUserid(int userId);

    /**
     * 增加图书
     * @param book 书
     * @return 成功返回1，失败返回-1
     */
    int insertBook(Book book);

    /**
     * 修改图书信息
     * @param book 更新
     * @return
     */
    BookVo updateBook(Book book);

    /**
     * 删除图书
     * @param userId 用户学号
     * @param bookName 书名
     * @return 成功返回1，失败返回-1
     */
    int deleteBook(int userId,String bookName);
}
