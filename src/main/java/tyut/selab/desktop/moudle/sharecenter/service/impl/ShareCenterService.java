package tyut.selab.desktop.moudle.sharecenter.service.impl;

import tyut.selab.desktop.moudle.sharecenter.dao.IShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.BugTypeDao;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.ShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.sharecenter.service.IShareCenterService;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.ui.sharecenter.boundary;

import java.sql.SQLException;
import java.util.*;

public class ShareCenterService implements IShareCenterService{
    private IShareCenterDao shareCenterDao = new ShareCenterDao();
    private BugTypeDao bugTypeDao = new BugTypeDao();

    private IUserDao userDao;
    @Override
    public List<BugType> queryAllType() {
        try {
            return bugTypeDao.queryAllType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public List<BugVo> showBugInfo() {
        try {
            List<BugMessage> bugMessages = shareCenterDao.queryAllBugInfo();
            List<BugVo> bugVoList = new Vector<>();
            ArrayList<String> titleList = new ArrayList<>();

            if (bugMessages.size()>=1){
                BugMessage bugMessage = bugMessages.get(0);
                BugVo bugVo = bugMessage.toBugVo();
                bugVoList.add(bugVo);
                titleList.add(bugVo.getBugTitle());
                for (int i = 1; i < bugMessages.size(); i++) {
                    bugMessage = bugMessages.get(i);

                    if (titleList.contains(bugMessage.getBugTitle())){
                        int index = titleList.indexOf(bugMessage.getBugTitle());
                        bugVoList.get(index).addBugType(bugMessage.getBugType());
                    }else {
                        titleList.add(bugMessage.getBugTitle());
                        bugVo = bugMessage.toBugVo();
                        bugVoList.add(bugVo);
                    }
                }
                return bugVoList;
            } else {
                return bugVoList;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BugVo> ShowBugInfo(List<String> bugType) {
        try {
            List<BugMessage> bugMessages = shareCenterDao.queryBugInfoByType(bugType);
            List<BugVo> bugVoList = new Vector<>();
            ArrayList<String> titleList = new ArrayList<>();

            if (bugMessages.size()>=1){
                BugMessage bugMessage = bugMessages.get(0);
                BugVo bugVo = bugMessage.toBugVo();
                bugVoList.add(bugVo);
                titleList.add(bugVo.getBugTitle());
                for (int i = 1; i < bugMessages.size(); i++) {
                    bugMessage = bugMessages.get(i);

                    if (titleList.contains(bugMessage.getBugTitle())){
                        int index = titleList.indexOf(bugMessage.getBugTitle());
                        bugVoList.get(index).addBugType(bugMessage.getBugType());
                    }else {
                        titleList.add(bugMessage.getBugTitle());
                        bugVo = bugMessage.toBugVo();
                        bugVoList.add(bugVo);
                    }
                }
                return bugVoList;
            } else {
                return bugVoList;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BugVo> ShowBugInfo(UserVo userVo) {
        try {
            User user = new User();
            user.setStudentNumber(userVo.getStudentNumber());

            List<BugMessage> bugMessages = shareCenterDao.ShowBugInfo(user);
            List<BugVo> bugVoList = new Vector<>();
            ArrayList<String> titleList = new ArrayList<>();

            if (bugMessages.size()>=1){
                BugMessage bugMessage = bugMessages.get(0);
                BugVo bugVo = bugMessage.toBugVo();
                bugVoList.add(bugVo);
                titleList.add(bugVo.getBugTitle());
                for (int i = 1; i < bugMessages.size(); i++) {
                    bugMessage = bugMessages.get(i);

                    if (titleList.contains(bugMessage.getBugTitle())){
                        int index = titleList.indexOf(bugMessage.getBugTitle());
                        bugVoList.get(index).addBugType(bugMessage.getBugType());
                    }else {
                        titleList.add(bugMessage.getBugTitle());
                        bugVo = bugMessage.toBugVo();
                        bugVoList.add(bugVo);
                    }
                }
                return bugVoList;
            } else {
                return bugVoList;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertBugInfo(BugVo bugVo) {

        User user = new User();
        user.setStudentNumber(bugVo.getUserVo().getStudentNumber());
        BugMessage bugMessage = new BugMessage(0, bugVo.getBugTitle(), bugVo.getBugSolve(),
                bugVo.getReleaseTime(), user, bugVo.getBugType().get(0));

        try {
            shareCenterDao.insertBugInfo(bugMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (bugVo.getBugType().size()>1){
            for (int i = 1; i < bugVo.getBugType().size(); i++) {
                bugMessage = new BugMessage();
                bugMessage.setBugType(bugVo.getBugType().get(i));
                try {
                    shareCenterDao.insertBugInfo(bugMessage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return 0;
    }

    @Override
    public int updateBugInfo(BugVo newBugVo, BugVo oldBugVo) {
        User user = new User();
        user.setStudentNumber(oldBugVo.getUserVo().getStudentNumber());
        BugMessage oldBugMessage = new BugMessage(0,oldBugVo.getBugTitle(),oldBugVo.getBugSolve() ,
                oldBugVo.getReleaseTime(), user, oldBugVo.getBugType().get(0));
        BugMessage newBugMessage = new BugMessage(0, newBugVo.getBugTitle(),newBugVo.getBugSolve(),
                newBugVo.getReleaseTime(), user, newBugVo.getBugType().get(0));

        try {
            shareCenterDao.updateBugInfo(newBugMessage, oldBugMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (newBugVo.getBugType().size()>1){
            for (int i = 1; i < newBugVo.getBugType().size(); i++) {
                newBugMessage= new BugMessage();
                newBugMessage.setBugTitle(newBugVo.getBugTitle());
                newBugMessage.setUser(user);
                newBugMessage.setBugType(newBugVo.getBugType().get(i));
                try {
                    shareCenterDao.updateBugInfo(newBugMessage, oldBugMessage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return 0;
    }

    @Override
    public int deleteBugInfo(BugVo bugVo) {
        User user = new User();
        user.setStudentNumber(bugVo.getUserVo().getStudentNumber());
        BugMessage bugMessage = new BugMessage(0, bugVo.getBugTitle(), bugVo.getBugSolve(),
                bugVo.getReleaseTime(), user, bugVo.getBugType().get(0));
        try {
            shareCenterDao.deleteBugInfo(bugMessage);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public int insertBugType(BugType bugType) {
        try {
            return bugTypeDao.insertBugType(bugType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateBugType(BugType newBugType, BugType oldBugType) {
        try {
            return bugTypeDao.updateBugType(newBugType, oldBugType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(BugType bugType) {
        try {
            bugTypeDao.delete(bugType);
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}