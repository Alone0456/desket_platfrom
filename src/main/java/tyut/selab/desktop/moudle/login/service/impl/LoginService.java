package tyut.selab.desktop.moudle.login.service.impl;

import tyut.selab.desktop.moudle.login.dao.ILoginDao;
import tyut.selab.desktop.moudle.login.dao.impl.LoginDao;
import tyut.selab.desktop.moudle.login.domain.LoginLog;
import tyut.selab.desktop.moudle.login.service.ILoginService;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserRegisterVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.xml.crypto.dsig.Transform;

import static java.lang.System.currentTimeMillis;

public class LoginService implements ILoginService {

    private ILoginDao loginDao = new LoginDao();

    private IUserDao userDao = new UserDao();

    private User user = null;


    @Override
    public String login(String accountNumber, String password) throws Exception {
        if (accountNumber.equals("") || password.equals("")) {
            return "账号或密码不能为空";
        }
        //将密码转化为加密后的密文与数据库比对
        LoginService loginService = new LoginService();
        String encryptPassword = loginService.getEncryptPassword(password);
        user = userDao.queryUserByAccount(accountNumber, encryptPassword);

        if (user == null) {
            return "账号或密码错误";
        } else {
            LoginLog loginLog = new LoginLog();
            loginLog.setName(user.getName());
            loginLog.setStudentNumber(user.getStudentNumber());
            //获取当前时间
//            Date timestamp = loginService.getCurrentTime();
//
//            // 将 Timestamp 转换为 Date
//            Date date = new Date(timestamp.getTime());
//
//            // 将 Date 转换为 Data
//            Data currentTime = javax.xml.crypto.Data(date);
//            loginLog.setLoginTime(currentTime);



            //获取登录ip
            InetAddress localhost;

            localhost = InetAddress.getLocalHost();

            String IPAddress = localhost.getHostAddress();
            loginLog.setLoginIp(IPAddress);
            loginDao.insertLoginLog(loginLog);

            //将用户的登录状态从0改到1
            User loggedUser = userDao.queryUserByAccount(accountNumber, encryptPassword);
            loggedUser.setLoginStatus(1);
            userDao.updateUser(user, loggedUser);
            return "登录成功";
        }

    }


    @Override
    public String register(UserRegisterVo userRegisterVo) {
        User user = new User();

        if (userRegisterVo.getAccountNumber().equals("")) {
            return "账号不能为空";
        }
        if (userRegisterVo.getPassword().equals("")) {
            return "密码不能为空";
        }
        if (userRegisterVo.getName().equals("")) {
            return "姓名不能为空";
        }
        if (userRegisterVo.getPhone().equals("")) {
            return "电话号码不能为空";
        }
        if (userRegisterVo.getPost().equals("")) {
            return "邮箱不能为空";
        }

        //判断电话号码的格式是否正确
        String phone = "^1[3-9]\\d{9}$";
        if (!Pattern.matches(phone, userRegisterVo.getPhone())) {
            return "电话号码格式错误";
        }
        //判断QQ邮箱格式是否正确
        String qqEmain = "^[1-9]\\d{4,10}@qq\\.com$";
        if (!Pattern.matches(qqEmain, userRegisterVo.getPost())) {
            return "QQ邮箱格式错误";
        }

        //使用MD5加密算法将密码加密存到数据库中
        String password = userRegisterVo.getPassword();
        LoginService loginService = new LoginService();
        String encryptPassword = loginService.getEncryptPassword(password);
        user.setPassword(encryptPassword);

        if (userDao.queryUserByAccount(userRegisterVo.getAccountNumber(), encryptPassword).getAccountNumber() != null) {
            return "该账号已经存在";
        }
        if (userDao.queryUserByStudentNumber(userRegisterVo.getStudentNumber()) != null) {
            return "该学号已经存在";
        }
        user.setAccountNumber(userRegisterVo.getAccountNumber());


        user.setName(userRegisterVo.getName());
        user.setStudentNumber(userRegisterVo.getStudentNumber());
        user.setGender(1);
        user.setPhone(userRegisterVo.getPhone());
        user.setPost(userRegisterVo.getPost());
        //设置用户职责
        Role role = new Role();
        role.setDuty("用户");

        user.setRole(role);

        user.setLoginStatus(0);

        //获取当前时间
        Date currentTime = loginService.getCurrentTime();
        user.setRegisterTime(currentTime);
        int registAffectRows = userDao.insertUser(user);//获取注册用户在数据库中影响的行数
        if (registAffectRows > 0) {
            return "注册成功";
        }
        ;

        return null;
    }

    @Override
    public void autoLogin() throws Exception {

        Thread.sleep(3000);
        LoginService loginService = new LoginService();
        String account = loginService.getAccount();
        String password = loginService.getPassword();
        loginService.login(account, password);
    }

    @Override
    public void rememberAccount() {
        String accountNumber = user.getAccountNumber();
        File file = new File("account.txt");
        if (file.exists()) {
            file.delete();
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(accountNumber);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void rememberPassword() {
        String password = user.getPassword();

        File file = new File("password.txt");
        if (file.exists()) {
            file.delete();
        }
        FileWriter fw = null;
        byte[] bytes = password.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ (i * 18));
        }
        String newPassword = new String(bytes, 0, bytes.length);

        try {
            fw = new FileWriter(file);
            fw.write(newPassword);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<LoginLog> showLoginLog() throws Exception {
        return loginDao.queryAllLoginLog();
    }

    @Override
    public List<LoginLog> showLoginLog(Data startTime, Data endingTime) throws Exception {
        return loginDao.showLoginLog(startTime, endingTime);
    }

    //获取存入文件中的账号
    public String getAccount() {
        File f = new File("account.txt");
        FileReader fr = null;
        String account = null;
        if (f.exists()) {
            try {
                fr = new FileReader(f);
                int len;
                account = "";
                char[] buf = new char[24];
                while ((len = fr.read(buf)) != -1) {
                    String str = new String(buf, 0, len);
                    account += str;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return account;
        } else return "";
    }

    //获取存入文件中的密码
    public String getPassword() {
        File file = new File("password.txt");
        FileReader fr = null;
        String password = null;
        if (file.exists()) {
            try {
                fr = new FileReader(file);
                Scanner sc = new Scanner(fr);
                if (sc.hasNext()) {
                    byte[] bt = sc.nextLine().getBytes();
                    for (int i = 0; i < bt.length; i++) {
                        bt[i] = (byte) (bt[i] ^ (i + 18));
                    }
                    password = new String(bt, 0, bt.length);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return password;
        } else return "";
    }

    //获取当前时间
    public Date getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, dateTimeFormatter);
        Date currentTime = java.sql.Timestamp.valueOf(dateTime);
        return currentTime;
    }

    //获得加密后的密文
    public String getEncryptPassword(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(password.getBytes());
        StringBuffer sb = new StringBuffer();
        byte[] bytes = messageDigest.digest();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1, 3));
        }
        String encryptPassword = sb.toString();
        return encryptPassword;
    }


}
