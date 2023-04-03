package tyut.selab.desktop.moudle.book.domain.vo;

import java.util.Date;

/**
 * 向ui展示的数据
 */
public class BookVo {
    private int studentNumber;
    private String userName;
    private String BookName;
    private int bookStatus;
    private Double bookPrice;
    private int borrowStudentNumber;
    private String borrowUserName;
    private Date borrowBookTime;
    private Date returnBookTime;

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBorrowStudentNumber() {
        return borrowStudentNumber;
    }

    public void setBorrowStudentNumber(int borrowStudentNumber) {
        this.borrowStudentNumber = borrowStudentNumber;
    }

    public String getBorrowUserName() {
        return borrowUserName;
    }

    public void setBorrowUserName(String borrowUserName) {
        this.borrowUserName = borrowUserName;
    }

    public Date getBorrowBookTime() {
        return borrowBookTime;
    }

    public void setBorrowBookTime(Date borrowBookTime) {
        this.borrowBookTime = borrowBookTime;
    }

    public Date getReturnBookTime() {
        return returnBookTime;
    }

    public void setReturnBookTime(Date returnBookTime) {
        this.returnBookTime = returnBookTime;
    }

    @Override
    public String toString() {
        return "BookVo{" +
                "studentNumber=" + studentNumber +
                ", userName='" + userName + '\'' +
                ", BookName='" + BookName + '\'' +
                ", bookStatus=" + bookStatus +
                ", bookPrice=" + bookPrice +
                ", borrowStudentNumber=" + borrowStudentNumber +
                ", borrowUserName='" + borrowUserName + '\'' +
                ", borrowBookTime=" + borrowBookTime +
                ", returnBookTime=" + returnBookTime +
                '}';
    }

}
