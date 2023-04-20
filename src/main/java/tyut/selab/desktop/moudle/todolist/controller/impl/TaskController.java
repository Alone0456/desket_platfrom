package tyut.selab.desktop.moudle.todolist.controller.impl;

import tyut.selab.desktop.moudle.todolist.controller.ITaskController;
import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;
import tyut.selab.desktop.moudle.todolist.service.ITaskService;

import java.sql.SQLException;
import java.util.List;

public class TaskController implements ITaskController {
    private ITaskService taskService;

    @Override
    public void taskWarnTime(TaskVo taskVo) {
        taskService.taskWarnTime(taskVo);
    }

    @Override
    public List<TaskVo> queryAllTask(Integer studentNumber) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return taskService.queryAllTask(studentNumber);
    }

    @Override
    public int insertTask(TaskVo taskVo) throws SQLException {
        return taskService.insertTask(taskVo);
    }

    @Override
    public int updateTask(TaskVo taskVo) throws SQLException {
        return taskService.updateTask(taskVo);
    }

    @Override
    public int deleteTask(TaskVo taskVo) throws SQLException {
        return taskService.deleteTask(taskVo);
    }
}

