package tyut.selab.desktop.moudle.tools.client.dao.impl;

import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.tools.client.dao.IUpFileDao;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.utils.MysqlConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpFileDao implements IUpFileDao {

    @Override
    public List<FileUp> queryAllFileUpInfo()  {
        // 获取连接
        Connection con = null;
        try {
            con = MysqlConnect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 定义sql
        String sql = "select * from user_file_up";
        //获取执行对象
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //执行
        ResultSet rs = null;
        try {
            rs = psmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //得到数据
        FileUp uf =null;
        List<FileUp> list = new ArrayList<>();
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }  // 数据类型与什么对应呢

//            int userStudentNumber = 0;//不用展示
            User temp = new User();
            int studentNumber = 0;
            String upFilePath = null;
            Timestamp upTime = null; // 数据类型可能不匹配
            String upIp = null;
            String week = null;
            long upId=0;
//            String accountNumber = null;
//            String password = null;
//            String name = null;
//            long studentNumber = 0;
//            String gender = null;
//            String phone = null;
//            String post = null;
//            Timestamp registerTime = null;
//            int loginStatus = 0;
//            String duty = null;
            try {
                upId = rs.getLong("up_id");
                studentNumber = rs.getInt("user_student_number");
                upFilePath = rs.getString("up_file_path");
                upTime = rs.getTimestamp("up_time");
                upIp = rs.getString("up_ip");
                week = rs.getString("up_week");

//                int userId = rs.getInt("user_id");
//                accountNumber = rs.getString("account_number");
//                password = rs.getString("password");
//                name = rs.getString("name");
//                studentNumber = rs.getLong("student_number");
//                gender = rs.getString("gender");
//                phone = rs.getString("phone");
//                post = rs.getString("post");
//                registerTime = rs.getTimestamp("register_time");
//                loginStatus = rs.getInt("login_status");
//                int roleId = rs.getInt("role_id");
//                duty = rs.getString("duty");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //封装成对象
            uf = new FileUp();
            //uf.setUpId(Integer.valueOf((int) upId));  // 主键不用设置
//            uf.getUser().setStudentNumber(Integer.valueOf((int) userStudentNumber));
            temp.setStudentNumber(studentNumber);
            uf.setUpId((int) upId);
            uf.setUser(temp);
            uf.setUpFilePath(upFilePath);
            uf.setUpTime(upTime);
            uf.setUpIp(upIp);
            uf.setWeek(week);
//            uf.getUser().setAccountNumber(accountNumber);
//            uf.getUser().setPassword(password);
//            uf.getUser().setName(name);
//            uf.getUser().setStudentNumber((int) studentNumber);
//            uf.getUser().getGender(gender);
//            uf.getUser().setPhone(phone);
//            uf.getUser().setPost(post);
//            uf.getUser().setRegisterTime(registerTime);
//            uf.getUser().setLoginStatus(loginStatus);
            // uf.getUser().setRole(roleId);  // 主键不用设置
//            uf.getUser().getRole().setDuty(duty);

            //写在集合里

            list.add(uf);

        }
        //释放资源
        try {
            rs.close();
            psmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;


    }

    @Override
    public List<FileUp> queryFileUpByUser(User user)  {    //根据学号查询
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = MysqlConnect.getConnection();
            String sql = "select * from user_file_up";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int number = user.getStudentNumber().intValue();  // 与原参相比少了一个 r
//        int useStudentNumber = 1;
        FileUp uf =null;
        List<FileUp> list = new ArrayList<>();

        while(true){
            try {
                if (!rs.next())
                    break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            int userStudentNumber = 0; // 判断语句
            try {
                userStudentNumber = rs.getInt("user_student_number");  //是用户类型的User
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            User temp = new User();
            if(number == userStudentNumber){
                String upFilePath = null;
                Timestamp upTime = null; // 数据类型可能不匹配
                String upIp = null;
                String week = null;
                long upId=0;
//                String accountNumber = null;
//                String password = null;
//                String name = null;
//                long studentNumber = 0;
//                String gender = null;
//                String phone = null;
//                String post = null;
//                Timestamp registerTime = null;
//                int loginStatus = 0;
//                String duty = null;
                try {
                    upFilePath = rs.getString("up_file_path");
                    upTime = rs.getTimestamp("up_time");
                    upIp = rs.getString("up_ip");
                    week = rs.getString("up_week");
                    upId = rs.getLong("up_id");

                    // int userId = rs.getInt("user_id");
//                    accountNumber = rs.getString("account_number");
//                    password = rs.getString("password");
//                    name = rs.getString("name");
//                    studentNumber = rs.getLong("student_number");
//                    gender = rs.getString("gender");
//                    phone = rs.getString("phone");
//                    post = rs.getString("post");
//                    registerTime = rs.getTimestamp("register_time");
//                    loginStatus = rs.getInt("login_status");
//                    int roleId = rs.getInt("role_id");
//                    duty = rs.getString("duty");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }



                //封装成对象
                uf = new FileUp();
                //uf.setUpId(Integer.valueOf((int) upId));  // 主键不用设置
        //        uf.getUser().setStudentNumber(Integer.valueOf((int) userStudentNumber));
                temp.setStudentNumber(number);
                uf.setUpFilePath(upFilePath);
                uf.setUpTime(upTime);
                uf.setUpIp(upIp);
                uf.setWeek(week);
                uf.setUpId((int) upId);
                uf.setUser(temp);
//                uf.getUser().setAccountNumber(accountNumber);
//                uf.getUser().setPassword(password);
//                uf.getUser().setName(name);
//                uf.getUser().setStudentNumber((int) studentNumber);
//                uf.getUser().getGender(gender);
//                uf.getUser().setPhone(phone);
//                uf.getUser().setPost(post);
//                uf.getUser().setRegisterTime(registerTime);
//                uf.getUser().setLoginStatus(loginStatus);
//                // uf.getUser().setRole(roleId);  // 主键不用设置
//                uf.getUser().getRole().setDuty(duty);

                //写在集合里

                list.add(uf);
            }
        }
        //释放资源
        try {
            rs.close();
            psmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }
    @Override
    public int insertFileUp(FileUp fileUp) {

        //获取数据
        Integer studentNumber =fileUp.getUser().getStudentNumber();
        String filePath = fileUp.getUpFilePath();
        Date time = fileUp.getUpTime();
        String ip = fileUp.getUpIp();
        String week = fileUp.getWeek();

        //获取连接
        Connection con =null;
        try {
            con = MysqlConnect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //定义sql语句
        String sql = "insert into user_file_up " +
                "(user_student_number, up_file_path, up_time, up_ip,up_week)" +
                " VALUE (?,?,?,?,?)";

        //获取执行对象
        PreparedStatement psmt = null;
        try {
             psmt = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //获取参数
        try{
            psmt.setInt(1,studentNumber);
            psmt.setString(2,filePath);
            psmt.setDate(3, (java.sql.Date) time);//可能会报错
            psmt.setString(4,ip);
            psmt.setString(5,week);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        //执行sql
        int i = 0;
        try {
             i = psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //释放资源
        try {
            psmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return i;
    }
}
