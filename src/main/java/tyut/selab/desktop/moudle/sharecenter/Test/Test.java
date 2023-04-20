package tyut.selab.desktop.moudle.sharecenter.Test;

import tyut.selab.desktop.moudle.sharecenter.controller.impl.ShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.BugTypeDao;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.ShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.sharecenter.service.impl.ShareCenterService;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args) throws SQLException {
//        User user = new User();
//        user.setStudentNumber(123);
//        user.setRole(new Role("用户"));
//
//        BugMessage bugMessage = new BugMessage(22,"tyu","solve",new Date(),user,"java");
//        System.out.println(bugMessage.getUserVo().getDuty());
        UserVo userVo = new UserVo();
        userVo.setDuty("用户");
        ShareCenterController controller = new ShareCenterController(userVo);

        controller.showBugInfo();
        controller.ShowBugInfo(userVo);
        controller.ShowBugInfo(new Vector<String>());
        controller.queryAllType();
        controller.insertBugInfo(new BugVo());
        controller.getUi().init();

//        ShareCenterService shareCenterService = new ShareCenterService();
//        List<BugVo> bugVoList = shareCenterService.showBugInfo();
//        System.out.println(bugVoList);

//        BugVo bugVo = new BugVo("bug1","solve",new Date(),bugMessage.getUserVo()
//                ,"java");
//        bugVo.addBugType("html");
//        BugVo newBugVo = new BugVo("bug2","soooo",new Date(),bugMessage.getUserVo()
//                ,"");
//        controller.insertBugInfo(bugVo);
//        controller.deleteBugInfo(bugVo);
//        controller.updateBugInfo(newBugVo,bugVo);

    }
}