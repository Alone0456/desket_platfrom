package tyut.selab.desktop.moudle.book.domain;

import tyut.selab.desktop.moudle.student.domain.User;

import java.util.Date;

public class BookBorrow {
    private int bookId;
    private Date borrowBookTime;
    private Date returnBookTime;
    private int userId;
    private int borrowUserId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(int borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    @Override
    public String toString() {
        return "BookBorrow{" +
                "bookId=" + bookId +
                ", borrowBookTime=" + borrowBookTime +
                ", returnBookTime=" + returnBookTime +
                ", userId=" + userId +
                ", borrowUserId=" + borrowUserId +
                '}';
    }
}
