package tyut.selab.desktop.moudle.sharecenter.service;

import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.List;

public interface IShareCenterService {
    /**
     * 展示所有信息
     * @return
     */
    List<BugVo> showBugInfo();

    /**
     * 展示相关类型的信息
     * @param bugType
     * @return
     */
    List<BugVo> ShowBugInfo(List<String> bugType);

    /**
     * 根据用户信息查询
     * @param userVo
     * @return
     */
    List<BugVo> ShowBugInfo(UserVo userVo);

    /**
     * 增加
     * @param bugVo
     * @return
     */
    int insertBugInfo(BugVo bugVo);

    /**
     * 修改
     * @param newBugVo
     * @param oldBugVo
     * @return
     */
    int updateBugInfo(BugVo newBugVo,BugVo oldBugVo);

    /**
     * 删除
     * @param bugVo
     * @return
     */
    int deleteBugInfo(BugVo bugVo);
}
