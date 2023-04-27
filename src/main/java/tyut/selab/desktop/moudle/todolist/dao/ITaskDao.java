package tyut.selab.desktop.moudle.todolist.dao;

import tyut.selab.desktop.moudle.todolist.domain.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskDao {
    /**
     * 通过学号查询的清单
     * @param studentNumber
     * @return
     */
    List<Task> queryAllTask(Integer studentNumber) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;

//    List<Task> queryAllTaskByUserName(String name);

    List<Task> queryAllTaskByUserName(String name);

    /**
     * 添加清单
     * @param task
     * @return
     */
    int insertTask(Task task) throws SQLException;

    /**
     * 修改清单
     * @param newTask
     * @param oldTask
     * @return
     */
    int updateTask(Task newTask,Task oldTask) throws SQLException;

    /**
     * 删除清单
     * @param task
     * @return
     */
    int deleteTask(Task task) throws SQLException;
}
