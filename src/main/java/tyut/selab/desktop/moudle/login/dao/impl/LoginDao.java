package tyut.selab.desktop.moudle.login.dao.impl;

import tyut.selab.desktop.moudle.login.dao.ILoginDao;
import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginDao implements ILoginDao {
    @Override
    public List<LoginLog> queryAllLoginLog() throws Exception {
        //获取collection
        Connection connection = MysqlConnect.getConnection();
        String sql = "select log_id,user_student_number," +
                "login_time,login_ip from user_login_log";
        //获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        LoginLog loginlog = null;
        List<LoginLog> loginLogs = new ArrayList<>();
        while (rs.next()) {
            String log_id = rs.getString("log_id");
            Integer userStudentNumber = rs.getInt("user_student_number");
            Date loginTime = rs.getDate("login_time");
            String loginIp = rs.getString("login_ip");
            //封装Loginlog对象
            loginlog = new LoginLog();
            loginlog.setName(log_id);
            loginlog.setStudentNumber(userStudentNumber);
            loginlog.setLoginTime(loginTime);
            loginlog.setLoginIp(loginIp);
            loginLogs.add(loginlog);


        }

        rs.close();
        pstmt.cancel();
        connection.close();

        return loginLogs;
    }


    public List<LoginLog> queryLoginLogByStudentNumber(String studentNumber) throws Exception {
        //获取collection
        Connection connection = MysqlConnect.getConnection();
        String sql = "select log_id,user_student_number," +
                "login_time,login_ip from user_login_log " +
                "where user_student_number=?";
        //获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, studentNumber);
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        LoginLog loginlog = null;
        List<LoginLog> loginLogs = new ArrayList<>();
        while (rs.next()) {
            String log_id = rs.getString("log_id");
            Integer userStudentNumber = rs.getInt("user_student_number");
            Date loginTime = rs.getDate("login_time");
            String loginIp = rs.getString("login_ip");
            //封装Loginlog对象
            loginlog = new LoginLog();
            loginlog.setName(log_id);
            loginlog.setStudentNumber(userStudentNumber);
            loginlog.setLoginTime(loginTime);
            loginlog.setLoginIp(loginIp);
            loginLogs.add(loginlog);


        }

        rs.close();
        pstmt.close();
        connection.close();

        return loginLogs;


    }


    public List<LoginLog> showLoginLog(Date startTime, Date endingTime) throws Exception {
        //获取collection
        Connection connection = MysqlConnect.getConnection();

        String sql = " select log_id,user_student_number," +
                "login_time,login_ip from user_login_log where " +
                "login_time between ? and   ?";

        //获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setDate(1, new java.sql.Date(startTime.getTime()));
        pstmt.setDate(2, new java.sql.Date(endingTime.getTime()));
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        LoginLog loginlog = null;
        List<LoginLog> loginLogs = new ArrayList<>();
        while (rs.next()) {
            String log_id = rs.getString("log_id");
            Integer userStudentNumber = rs.getInt("user_student_number");
            Date loginTime = rs.getDate("login_time");
            String loginIp = rs.getString("login_ip");
            //封装Loginlog对象
            loginlog = new LoginLog();
            loginlog.setName(log_id);
            loginlog.setStudentNumber(userStudentNumber);
            loginlog.setLoginTime(loginTime);
            loginlog.setLoginIp(loginIp);
            loginLogs.add(loginlog);
        }

        rs.close();
        pstmt.close();
        connection.close();

        return loginLogs;

    }

    @Override
    public int insertLoginLog(LoginLog log) throws Exception {

        //获取collection
        Connection connection = MysqlConnect.getConnection();
        String sql = "insert into user_login_log" +
                " (log_id,user_student_number,login_time,login_ip)values(?,?,?,?)";

        //获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, null);
        pstmt.setInt(2, log.getStudentNumber());
        pstmt.setString(3, log.getLoginTime().toString());
        pstmt.setString(4, log.getLoginIp());

        //执行sql
        int count = pstmt.executeUpdate();

        pstmt.close();
        connection.close();
        return count;
    }


}
