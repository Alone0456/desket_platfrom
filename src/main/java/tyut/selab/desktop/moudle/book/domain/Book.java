package tyut.selab.desktop.moudle.book.domain;

public class Book {
    public static final int LENDABLE = 0;
    public static final int LENDED = 1;
    private int bookId;
    private Integer userStudentNumber;
    private String BookName;
    private int bookStatus;
    private Double bookPrice;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Integer getUserStudentNumber() {
        return userStudentNumber;
    }

    public void setUserStudentNumber(Integer userStudentNumber) {
        this.userStudentNumber = userStudentNumber;
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
}
