package tyut.selab.desktop.moudle.tools.client.dao.impl;

import tyut.selab.desktop.moudle.student.domain.Role;
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
        List<FileUp> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            con = MysqlConnect.getConnection();
            String sql = "select * " +
                "from user_file_up as a,`user` as b,user_role as c " +
                "where b.student_number = a.user_student_number and c.role_id = b.role_id";

            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()){
                FileUp fileUp = new FileUp();
                User user = new User();
                user.setAccountNumber(rs.getString("account_number"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setStudentNumber(rs.getInt("student_number"));
                user.setGender(rs.getInt("gender"));
                user.setPhone(rs.getString("phone"));
                user.setPost(rs.getString("post"));
                user.setRegisterTime(rs.getTimestamp("register_time"));
                user.setLoginStatus(rs.getInt("login_status"));
                Role role = new Role();
                user.setRole(role);
                role.setDuty(rs.getString("duty"));

                fileUp.setUpId(rs.getInt("up_id"));
                fileUp.setUser(user);
                fileUp.setUpFilePath(rs.getString("up_file_path"));
                fileUp.setUpTime(rs.getTimestamp("up_time"));
                fileUp.setUpIp(rs.getString("up_ip"));

                list.add(fileUp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放资源
        MysqlConnect.close(psmt,rs,con);

        return list;
    }

    @Override
    public List<FileUp> queryFileUpByUser(User user)  {  //根据学号查询
        List<FileUp> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            con = MysqlConnect.getConnection();
            String sql = "select * from user_file_up a,`user` b,user_role c" +
                    " where b.student_number = a.user_student_number " +
                    "and c.role_id = b.role_id and b.student_number=? ";
            StringBuffer stringBuffer = new StringBuffer(sql);
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,user.getStudentNumber());
            rs = psmt.executeQuery();

            while (rs.next()) {
                FileUp fileUp = new FileUp();
                User temp = new User();
                temp.setAccountNumber(rs.getString("account_number"));
                temp.setPassword(rs.getString("password"));
                temp.setName(rs.getString("name"));
                temp.setStudentNumber(rs.getInt("student_number"));
                temp.setGender(rs.getInt("gender"));
                temp.setPhone(rs.getString("phone"));
                temp.setPost(rs.getString("post"));
                temp.setRegisterTime(rs.getTimestamp("register_time"));
                temp.setLoginStatus(rs.getInt("login_status"));
                Role role = new Role();
                temp.setRole(role);
                role.setDuty(rs.getString("duty"));

                fileUp.setUpId(rs.getInt("up_id"));
                fileUp.setUser(temp);
                fileUp.setUpFilePath(rs.getString("up_file_path"));
                fileUp.setUpTime(rs.getTimestamp("up_time"));
                fileUp.setUpIp(rs.getString("up_ip"));

                list.add(fileUp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
        @Override
    public int insertFileUp(FileUp fileUp) {
        Connection con =null;
        PreparedStatement psmt = null;

        try {
            con = MysqlConnect.getConnection();

            String sql = "insert into user_file_up " +
                    "(user_student_number, up_file_path, up_time, up_ip)" +
                    "VALUE (?,?,?,?)";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,fileUp.getUser().getStudentNumber());
            psmt.setString(2,fileUp.getUpFilePath());
            psmt.setTimestamp(3, (Timestamp) fileUp.getUpTime());
            psmt.setString(4,fileUp.getUpIp());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放资源
        MysqlConnect.close(psmt,con);
        return 1;
    }
}
