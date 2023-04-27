package tyut.selab.desktop.moudle.todolist.service;

import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;

import java.sql.SQLException;
import java.util.List;

public interface ITaskService {
    /**
     * 到期提醒
     */
    void taskWarnTime(TaskVo taskVo);

    /**
     * 查询该用户的全部任务
     * @param studentNumber
     * @return
     */
    List<TaskVo> queryAllTask(Integer studentNumber) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

    /**
     * 增加用户任务
     * @param task
     * @return
     */
    int insertTask(TaskVo task) throws SQLException;

    /**
     * 更新
     * @param task
     * @return
     */
    int updateTask(TaskVo task) throws SQLException;

    /**
     * 删除
     * @param task
     * @return
     */
    int deleteTask(TaskVo task) throws SQLException;
}
