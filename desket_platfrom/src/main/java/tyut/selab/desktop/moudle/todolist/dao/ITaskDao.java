package tyut.selab.desktop.moudle.todolist.dao;

import tyut.selab.desktop.moudle.todolist.domain.Task;

import java.util.List;

public interface ITaskDao {
    /**
     * 通过学号查询的清单
     * @param studentNumber
     * @return
     */
    List<Task> queryAllTask(Integer studentNumber);

    /**
     * 添加清单
     * @param task
     * @return
     */
    int insertTask(Task task);

    /**
     * 修改清单
     * @param newTask
     * @param oldTask
     * @return
     */
    int updateTask(Task newTask,Task oldTask);

    /**
     * 删除清单
     * @param task
     * @return
     */
    int deleteTask(Task task);
}
