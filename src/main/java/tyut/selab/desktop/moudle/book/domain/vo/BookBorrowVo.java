package tyut.selab.desktop.moudle.book.domain.vo;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.Date;

public class BookBorrowVo {
    private UserVo bookUserVo;
    private String BookName;
    private int bookStatus;
    private Double bookPrice;
    private UserVo borrowBookUserVo;
    private Date borrowBookTime;
    private Date returnBookTime;
}
