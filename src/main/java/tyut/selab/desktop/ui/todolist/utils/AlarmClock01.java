package tyut.selab.desktop.ui.todolist.utils;

import java.sql.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class AlarmClock01 {
    private Timer timer;

    public AlarmClock01() {
        timer = new Timer();
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                checkDeadlines();
            }
        }, 0, 1000); //每秒钟检查一次截止日期是否到期
    }

    public void stop() {
        timer.cancel();
    }

    private void checkDeadlines() {
        try {
            //连接到数据库
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/desket_platfrom", "root", "159753");

            //查询所有未过期的截止日期
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_tasks_list WHERE task_end_time > NOW()");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //获取截止日期和提醒消息
                Date deadline = rs.getDate("task_end_time");
                String message = rs.getString("task_content");

                //如果当前时间超过截止日期，则弹出提醒框
                if (new Date().after(deadline)) {
                    JOptionPane.showMessageDialog(null, message+"时间到！！！");
                }
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
