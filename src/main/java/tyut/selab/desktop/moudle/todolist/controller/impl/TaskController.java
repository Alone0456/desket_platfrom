package tyut.selab.desktop.moudle.todolist.controller.impl;

import tyut.selab.desktop.moudle.todolist.controller.ITaskController;
import tyut.selab.desktop.moudle.todolist.domain.Task;

import java.util.List;

public class TaskController implements ITaskController {
    private TaskController taskController;
    @Override
    public List<Task> queryAllTask(Integer studentNumber) {
        return null;
    }

    @Override
    public List<Task> queryAllTaskByUserName(String name) {
        return null;
    }

    @Override
    public int insertTask(Task task) {
        return 0;
    }

    @Override
    public int updateTask(Task task, Integer taskId) {
        return 0;
    }

    @Override
    public int deleteTask(Task task) {
        return 0;
    }
}
