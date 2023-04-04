package tyut.selab.desktop.moudle.todolist.service;

import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;

import java.util.List;

public interface ITaskService {
    List<TaskVo> queryAllTask(Integer studentNumber);

    List<TaskVo> queryAllTaskByUserName(String name);

    int insertTask(TaskVo task);

    int updateTask(TaskVo task);

    int deleteTask(TaskVo task);
}
