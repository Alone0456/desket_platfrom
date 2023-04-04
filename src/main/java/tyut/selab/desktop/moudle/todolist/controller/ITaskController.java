package tyut.selab.desktop.moudle.todolist.controller;

import tyut.selab.desktop.moudle.todolist.domain.Task;

import java.util.List;

public interface ITaskController {
    List<Task> queryAllTask(Integer studentNumber);

    List<Task> queryAllTaskByUserName(String name);

    int insertTask(Task task);

    int updateTask(Task task,Integer taskId);

    int deleteTask(Task task);
}
