package tyut.selab.desktop.moudle.book.domain.vo;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.Date;

/**
 * 向ui展示的数据
 */
public class BookVo {
    private UserVo bookUserVo; //该图书拥有者的用户信息
    private String BookName; //书名
    private int bookStatus; //书的状态
    private Double bookPrice; //书的价格
    private UserVo borrowBookUserVo; //该图书借阅者的用户信息
    private Date borrowBookTime; //借书时间
    private Date returnBookTime; //还书时间
}
