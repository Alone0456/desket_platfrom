package tyut.selab.desktop.ui.tools.utils;

import tyut.selab.desktop.ui.tools.myexception.MyException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:WeekNumber
 * Package:tools.utils
 * Description:
 * 计算当前日期为开学后第几周
 *
 * @Author:14亿少女的梦-苏信玮
 * @Create:2023/04/19 - 16:16
 * @Version:v1.0
 */
@SuppressWarnings("all")
public class WeekNumber extends Date {
    public static Date date=new WeekNumber();
    public static int getWeek() {
        //开始日期
        String startDate = "2023-02-13";
        //当前日期
        Date currentTempDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(currentTempDate);
        //设置星期的第一天为周一
        int firstDayOfWeek = 2;

        int weekNumber = getWeekNumber(startDate, currentDate, firstDayOfWeek);
        return weekNumber;
    }

    public static int getWeekNumber(String startDate, String currentDate, int firstDayOfWeek) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int weekNumber = 0;

        try {
            Date start = dateFormat.parse(startDate);
            Date current = dateFormat.parse(currentDate);
            long diff = current.getTime() - start.getTime();
            long days = diff / (24 * 60 * 60 * 1000);
            if (days >= 0) {
                //计算所属的周数
                weekNumber = (int) (days / 7);
            }
            //周数加1
            weekNumber = weekNumber + 1;
            //计算开始日期的星期
            int firstWeekDay = getDayOfWeek(startDate, firstDayOfWeek);
            //计算当前日期属于第几周
            weekNumber = (int) (weekNumber + ((firstWeekDay + days % 7 - 1) / 7));
        } catch (Exception e) {
            try {
                throw new MyException("Error parsing");
            } catch (MyException ex) {
                ex.printStackTrace();
            }
        }

        return weekNumber;
    }

    public static int getDayOfWeek(String dateStr, int firstDayOfWeek) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int dayOfWeek = 0;

        try {
            Date date = dateFormat.parse(dateStr);
            dayOfWeek = date.getDay();
            //如果星期的第一天为周一，则将星期天改为7
            if (firstDayOfWeek == 2) {
                if (dayOfWeek == 0) {
                    dayOfWeek = 7;
                }
                //如果星期的第一天为周日，则将星期一改为7，其余不变
            } else if (firstDayOfWeek == 1) {
                if (dayOfWeek == 1) {
                    dayOfWeek = 8;
                }
            }
        } catch (Exception e) {
            try {
                throw new MyException("Error parsing");
            } catch (MyException ex) {
                ex.printStackTrace();
            }
        }

        return dayOfWeek;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(this);
    }
}
