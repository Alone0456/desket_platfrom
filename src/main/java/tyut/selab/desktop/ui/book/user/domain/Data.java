package tyut.selab.desktop.ui.book.user.domain;

import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.ui.book.user.SystemOrdinaryUsers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Data {
UserVo userVo = null;
BookMessageController bookMessageController = new BookMessageController();

 public Data(UserVo userVo) {

   this.userVo = userVo;

 }
    /**
     * 按某种方式对List<BookVo>排序
     */
    public Vector<Vector> sortBookVos(Vector<Vector> dataV, int types) {

        if (types == SystemOrdinaryUsers.BOOK_PRICE_ASC) {
            dataV.sort(new Comparator<Vector>() {
                @Override
                public int compare(Vector o1, Vector o2) {
                    double d2 = Double.parseDouble(o2.get(3).toString());
                    double d1 = Double.parseDouble(o1.get(3).toString());
                    if(d1>d2){
                        return 1;
                    }
                    return -1;
                }
            });}
        if (types == SystemOrdinaryUsers.BOOK_PRICE_DESC) {
            dataV.sort(new Comparator<Vector>() {
                @Override
                public int compare(Vector o1, Vector o2) {
                    double d2 = Double.parseDouble(o2.get(3).toString());
                    double d1 = Double.parseDouble(o1.get(3).toString());
                    if(d1>d2){
                        return -1;
                    }
                    return 1;
                }
            });
        }
        if (types == SystemOrdinaryUsers.BOOK_LENDABLE) {
            for (int i = 0; i < dataV.size(); i++) {
                if(dataV.get(i).get(4).toString().equals("已借出")){
                    dataV.removeElementAt(i);
                    i-=1;
                }
            }
        }
        return dataV;
    }

    // 查看借阅书籍表头
    public Vector<String> getTitleBorrowBook(){
        Vector<String> vector = new Vector<>();
        vector.add("书籍名称");
        vector.add("书籍拥有者");
        vector.add("书籍价格");
        vector.add("借阅时间");
        vector.add("承诺归还时间");
        return  vector;
    }

    //  封装查看借阅书籍信息
    public Vector<Vector> getDataBorrowBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Vector<Vector> dataV = new Vector<>();
        List<BookVo> bookVos = bookMessageController.queryAllBook();
        for (int i = 0; i < bookVos.size(); i++) {
            if(bookVos.get(i).getBorrowBookUserVo().getStudentNumber().equals(userVo.getStudentNumber())) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:mm");
                Vector vector = new Vector();
                vector.add(bookVos.get(i).getBookName());
                vector.add(bookVos.get(i).getBookUserVo().getName());
                vector.add(bookVos.get(i).getBookPrice());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
                dataV.add(vector);
            }
        }
        return dataV;
    }

    // 封装用户书籍表头
    public Vector getTitleMyBook(){
        Vector vector = new Vector();
        vector.add("书籍名称");
        vector.add("书籍价格");
        vector.add("书籍状态");
        vector.add("书籍借阅人");
        vector.add("书籍借阅时间");
        vector.add("书籍归还时间");
        return vector;
    }

    // 封装用户书籍信息
    public Vector<Vector> getDataMyBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageController.queryBookByUserid(userVo.getStudentNumber());
        Vector<Vector> valuesV = new Vector<>();
        for (int i = 0; i < bookVos.size(); i++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:mm");
            Vector vector = new Vector();
            vector.add(bookVos.get(i).getBookName());
            vector.add(bookVos.get(i).getBookPrice());
            vector.add(bookVos.get(i).getBookStatus()== Book.LENDABLE ?"未借出":"已借出");
            if(bookVos.get(i).getBookStatus() == Book.LENDED) {
                vector.add(bookVos.get(i).getBorrowBookUserVo().getName());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
            }else{
                vector.add("");
                vector.add("");
                vector.add("");
            }
            valuesV.add(vector);
        }
        return valuesV;
    }

    // 封装用户借阅的书籍表头信息
    public Vector<String> getTitlesReturnBook(){
        Vector<String> vector = new Vector<>();
        vector.add("书籍名称");
        vector.add("书籍拥有者");
        vector.add("拥有者学号");
        vector.add("书籍价格");
        vector.add("借阅时间");
        vector.add("归还时间");
        return vector;
    }

    // 封装用户借阅的书籍
    public Vector<Vector> getDataReturnBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageController.quereyBorrowBookByBorrowerId(userVo.getStudentNumber());
        Vector<Vector> dataV = new Vector<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:mm");
        for (int i = 0; i < bookVos.size(); i++) {
            Vector vector = new Vector();
            vector.add(bookVos.get(i).getBookName());
            vector.add(bookVos.get(i).getBookUserVo().getName());
            vector.add(bookVos.get(i).getBookUserVo().getStudentNumber());
            vector.add(bookVos.get(i).getBookPrice());
            vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
            vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
            dataV.add(vector);

        }
        return dataV;
    }

    /**
     * 封装书籍表头信息
     *
     * @return
     */
    public Vector<String> getTitleVector() {
        Vector<String> titlesV = new Vector<>();
        titlesV.add("书籍名称");
        titlesV.add("书籍拥有者");
        titlesV.add("拥有者学号");
        titlesV.add("书籍价格");
        titlesV.add("书籍状态");
        titlesV.add("借阅人");
        titlesV.add("借出时间");
        titlesV.add("归还时间");
        return titlesV;
    }
    /**
     * 封装书籍数据信息
     *
     * @return
     */
    public Vector<Vector> getDataVector(List<BookVo> bookVos) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Vector<Vector> dataV = new Vector<>();
        for (int i = 0; i < bookVos.size(); i++) {
            Vector vector = new Vector();
            vector.add(bookVos.get(i).getBookName());
            vector.add(bookVos.get(i).getBookUserVo().getName());
            vector.add(bookVos.get(i).getBookUserVo().getStudentNumber());
            vector.add(bookVos.get(i).getBookPrice());
            int bookStatus = bookVos.get(i).getBookStatus();
            if (bookStatus == Book.LENDABLE) {
                vector.add("未借出");
                vector.add("");
                vector.add("");
                vector.add("");
            } else {
                vector.add("已借出");
                vector.add(bookVos.get(i).getBorrowBookUserVo().getName());
                vector.add(simpleDateFormat1.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
            }
            dataV.add(vector);
        }
        return dataV;
    }
}

