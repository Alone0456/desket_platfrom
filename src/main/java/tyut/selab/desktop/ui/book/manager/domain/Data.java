package tyut.selab.desktop.ui.book.manager.domain;


import tyut.selab.desktop.moudle.book.bookcontroller.impl.BookMessageController;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.ui.book.manager.SystemAdministration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Data {
    BookMessageController bookMessageController = new BookMessageController();


    /**
     * 封装书籍数据信息
     * @return
     */
    public Vector<Vector> getDataVector(List<BookVo> bookVos)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:mm");
        Vector<Vector> dataV = new Vector<>();
        for (int i = 0; i < bookVos.size(); i++) {
            Vector vector = new Vector();
            vector.add(bookVos.get(i).getBookName());
            vector.add(bookVos.get(i).getBookUserVo().getName());
            vector.add(bookVos.get(i).getBookUserVo().getStudentNumber());
            vector.add(bookVos.get(i).getBookPrice());
            int bookStatus = bookVos.get(i).getBookStatus();
            if(bookStatus == Book.LENDABLE){
                vector.add("未借出");
            }else{
                vector.add("已借出");
            }
            if(bookVos.get(i).getBookStatus() == Book.LENDED) {
                vector.add(bookVos.get(i).getBorrowBookUserVo().getName());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
            }else{
                vector.add("");
                vector.add("");
                vector.add("");
            }
            dataV.add(vector);
        }
        return dataV;
    }

    /**
     * 封装书籍表头信息
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
     * 黑名单信息表头封装
     */
    public Vector<String> getTitleBlackList(){
        Vector<String> titleBlackList = new Vector<>();
        titleBlackList.add("学生姓名");
        titleBlackList.add("学生学号");
        titleBlackList.add("借阅书籍");
        titleBlackList.add("借阅时间");
        titleBlackList.add("承诺还书时间");
        titleBlackList.add("逾期天数");

        return titleBlackList;
    }

    /**
     * 查询黑名单列表
     * return Vector<Vector>
     */
    public Vector<Vector> queryBlackList() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookVo> bookVos = bookMessageController.queryBorrowBookLog();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Vector<Vector> blackList = new Vector<>();
        for (int i = 0; i < bookVos.size(); i++) {
            if(new Date().after(bookVos.get(i).getReturnBookTime())){
                Vector vector = new Vector();
                vector.add(bookVos.get(i).getBookUserVo().getName());
                vector.add(bookVos.get(i).getBookUserVo().getStudentNumber());
                vector.add(bookVos.get(i).getBookName());
                vector.add(simpleDateFormat.format(bookVos.get(i).getBorrowBookTime()));
                vector.add(simpleDateFormat.format(bookVos.get(i).getReturnBookTime()));
                vector.add((System.currentTimeMillis() - bookVos.get(i).getReturnBookTime().getTime())/(1000*60*60*24));
                blackList.add(vector);
            }
        }

        return blackList;
    }
    /**
     * 按某种方式对List<BookVo>排序
     */
    public Vector<Vector> sortBookVos(Vector<Vector> dataV,int types) {

        if (types == SystemAdministration.BOOK_PRICE_ASC) {
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
        if (types == SystemAdministration.BOOK_PRICE_DESC) {
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
        if(types == SystemAdministration.BOOK_LENDED){
            for (int i = 0; i < dataV.size(); i++) {
                if(dataV.get(i).get(4).toString().equals("未借出")){
                    dataV.removeElementAt(i);
                    i-=1;
                }
            }
        }
        if (types == SystemAdministration.BOOK_LENDABLE) {
            for (int i = 0; i < dataV.size(); i++) {
                if(dataV.get(i).get(4).toString().equals("已借出")){
                    dataV.removeElementAt(i);
                    i-=1;
                }
            }
        }
        return dataV;
    }


}
