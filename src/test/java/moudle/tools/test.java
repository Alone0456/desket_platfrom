package moudle.tools;

import org.junit.Test;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.tools.client.dao.impl.UpFileDao;
import tyut.selab.desktop.moudle.tools.client.domain.FileUp;
import tyut.selab.desktop.moudle.tools.client.domain.vo.FileUpVo;
import tyut.selab.desktop.moudle.tools.client.service.impl.FileService;

import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class test {

    @Test
    public void test(){

    }

    @Test
    public void test02() throws UnknownHostException {
        //UpFileDao upFileDao = new UpFileDao();
//        List<FileUp> fileUps = upFileDao.queryAllFileUpInfo();
//        for (FileUp fileUp : fileUps) {
//            System.out.println(fileUp);
//        }

//        User user = new User();
//        user.setStudentNumber(2021006207);
//        List<FileUp> fileUps1 = upFileDao.queryFileUpByUser(user);
//        for (FileUp fileUp : fileUps1) {
//            System.out.println(fileUp);
//        }
//        FileUp fileUp = new FileUp();
//        User user1 = new User();
//        user1.setStudentNumber(2021006207);
//        fileUp.setUser(user1);
//        fileUp.setUpIp("192.168.3.1");
//        Date date = new Date();
//        fileUp.setUpTime(new Timestamp(date.getTime()));
//        fileUp.setUpFilePath("/home/fengyang/week/冯洋/任务/");
//        upFileDao.insertFileUp(fileUp);

       // FileService fileService = new FileService();
        User userVo = new User();
        userVo.setStudentNumber(2021006207);
        UpFileDao upFileDao = new UpFileDao();
        for (FileUp fileUp : upFileDao.queryFileUpByUser(userVo)) {
            System.out.println(fileUp);
        }

        // /home/fengyang/week/冯洋/任务/2136-冯洋.zip
        //fileService.fileUpLoading(userVo,"/home/fengyang/week/冯洋/第一周/提交2021006207-冯洋.zip","C:\\Users\\19182\\Desktop\\乱七八糟\\项目改动.zip");
    }
}
