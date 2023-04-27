package tyut.selab.desktop.moudle.sharecenter.dao;

import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.User;


import java.sql.SQLException;
import java.util.List;

public interface IShareCenterDao {
    /**
     * 查询所有bug信息
     * @return
     */
    List<BugMessage> queryAllBugInfo() throws Exception;

    /**
     * 根据bug类型查询bug
     * @param bugType
     * @return
     */
    List<BugMessage> queryBugInfoByType(List<String> bugType) throws SQLException;

    /**
     * 根据用户查询
     * @param user
     * @return
     */
    List<BugMessage> ShowBugInfo(User user) throws Exception;

    /**
     * 增加
     * @param bugMessage
     * @return
     */
    int insertBugInfo(BugMessage bugMessage) throws Exception;

    /**
     * 修改
     * @param newBugMessage
     * @param oldBugMessage
     * @return
     */
    int updateBugInfo(BugMessage newBugMessage,BugMessage oldBugMessage) throws SQLException;

    /**
     * 删除
     * @param bugMessage
     * @return
     */
    int deleteBugInfo(BugMessage bugMessage) throws SQLException;
}
