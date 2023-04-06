package tyut.selab.desktop.moudle.book.bookdao;

import tyut.selab.desktop.moudle.book.domain.BookBorrow;

public interface IBookBorrowDao {
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
