package tyut.selab.desktop.moudle.sharecenter.controller.impl;


import tyut.selab.desktop.moudle.sharecenter.controller.IShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.sharecenter.service.IShareCenterService;
import tyut.selab.desktop.moudle.sharecenter.service.impl.ShareCenterService;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.List;





    public class ShareCenterController implements IShareCenterController {

        private IShareCenterService shareCenterService = new ShareCenterService();


        @Override
        public List<BugType> queryAllType() {
            return shareCenterService.queryAllType();
        }

        @Override
        public List<BugVo> showBugInfo() {
            return shareCenterService.showBugInfo();
        }


        @Override
        public List<BugVo> ShowBugInfo(List<String> bugType) {

            return shareCenterService.ShowBugInfo(bugType);
        }

        @Override
        public List<BugVo> ShowBugInfo(UserVo userVo) {

            return shareCenterService.ShowBugInfo(userVo);
        }


        @Override
        public int insertBugInfo(BugVo bugVo) {

            shareCenterService.insertBugInfo(bugVo);

            return 0;
        }

        @Override
        public int updateBugInfo(BugVo newBugVo, BugVo oldBugVo) {
            shareCenterService.updateBugInfo(newBugVo, oldBugVo);
            return 0;
        }

        @Override
        public int deleteBugInfo(BugVo bugVo) {
            shareCenterService.deleteBugInfo(bugVo);
            return 0;
        }

        @Override
        public int insertBugType(BugType bugType) {
            shareCenterService.insertBugType(bugType);
            return 0;
        }

        @Override
        public int updateBugType(BugType newBugType, BugType oldBugType) {
            shareCenterService.updateBugType(newBugType,oldBugType);
            return 0;
        }

        @Override
        public int delete(BugType bugType) {
            shareCenterService.delete(bugType);
            return 0;
        }
    }