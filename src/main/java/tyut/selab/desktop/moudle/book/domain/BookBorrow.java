package tyut.selab.desktop.moudle.book.domain;

import java.util.Date;

public class BookBorrow {
    private int bookId;
    private Date borrowBookTime;
    private Date returnBookTime;
    private Integer userStudentNumber;
    private Integer borrowUserStudentNumber;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public Integer getUserStudentNumber() {
        return userStudentNumber;
    }

    public void setUserStudentNumber(Integer userStudentNumber) {
        this.userStudentNumber = userStudentNumber;
    }

    public Integer getBorrowUserStudentNumber() {
        return borrowUserStudentNumber;
    }

    public void setBorrowUserStudentNumber(Integer borrowUserStudentNumber) {
        this.borrowUserStudentNumber = borrowUserStudentNumber;
    }
}
