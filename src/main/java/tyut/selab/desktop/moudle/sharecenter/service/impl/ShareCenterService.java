package tyut.selab.desktop.moudle.sharecenter.service.impl;

import tyut.selab.desktop.moudle.sharecenter.dao.IShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.sharecenter.service.IShareCenterService;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

import java.util.List;

public class ShareCenterService implements IShareCenterService{
    private IShareCenterDao shareCenterDao;

    private IUserDao userDao;
    @Override
    public List<BugType> queryAllType() {
        return null;
    }

    @Override
    public List<BugVo> showBugInfo() {
        return null;
    }

    @Override
    public List<BugVo> ShowBugInfo(List<String> bugType) {
        return null;
    }

    @Override
    public List<BugVo> ShowBugInfo(UserVo userVo) {
        return null;
    }

    @Override
    public int insertBugInfo(BugVo bugVo) {
        return 0;
    }

    @Override
    public int updateBugInfo(BugVo newBugVo, BugVo oldBugVo) {
        return 0;
    }

    @Override
    public int deleteBugInfo(BugVo bugVo) {
        return 0;
    }

    @Override
    public int insertBugType(BugType bugType) {
        return 0;
    }

    @Override
    public int updateBugType(BugType newBugType, BugType oldBugType) {
        return 0;
    }

    @Override
    public int delete(BugType bugType) {
        return 0;
    }
}
