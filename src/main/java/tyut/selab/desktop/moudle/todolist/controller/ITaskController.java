package tyut.selab.desktop.moudle.todolist.controller;

import tyut.selab.desktop.moudle.todolist.domain.Task;
import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;

import java.util.List;

public interface ITaskController {
    List<TaskVo> queryAllTask(Integer studentNumber);

    List<TaskVo> queryAllTaskByUserName(String name);

    int insertTask(TaskVo task);

    int updateTask(TaskVo task);

    int deleteTask(TaskVo task);
}
