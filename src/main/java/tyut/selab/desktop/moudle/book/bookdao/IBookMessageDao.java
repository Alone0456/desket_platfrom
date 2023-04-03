package tyut.selab.desktop.moudle.book.bookdao;


import tyut.selab.desktop.moudle.book.domain.Book;

import java.util.List;

public interface IBookMessageDao {
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
     * @param userId 用户学号
     * @return 图书列表
     */
    List<Book> queryBookByUserid(int userId);

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
    int updateBook(Book book);

    /**
     * 删除图书
     * @param userId 用户学号
     * @param bookName 书名
     * @return 成功返回1，失败返回-1
     */
    int deleteBook(int userId,String bookName);
}
