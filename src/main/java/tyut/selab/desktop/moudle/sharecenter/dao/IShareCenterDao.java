package tyut.selab.desktop.moudle.sharecenter.dao;

import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.User;


import java.util.List;

public interface IShareCenterDao {
    /**
     * 查询所有bug信息
     * @return
     */
    List<BugMessage> queryAllBugInfo();

    /**
     * 根据bug类型查询bug
     * @param bugType
     * @return
     */
    List<BugMessage> queryBugInfoByType(List<String> bugType);

    /**
     * 根据用户查询
     * @param user
     * @return
     */
    List<BugMessage> ShowBugInfo(User user);

    /**
     * 增加
     * @param bugMessage
     * @return
     */
    int insertBugInfo(BugMessage bugMessage);

    /**
     * 修改
     * @param newBugMessage
     * @param oldBugMessage
     * @return
     */
    int updateBugInfo(BugMessage newBugMessage,BugMessage oldBugMessage);

    /**
     * 删除
     * @param bugMessage
     * @return
     */
    int deleteBugInfo(BugMessage bugMessage);
}
