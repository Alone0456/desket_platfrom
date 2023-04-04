package tyut.selab.desktop.moudle.todolist.service.impl;

import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;
import tyut.selab.desktop.moudle.todolist.dao.impl.TaskDao;
import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;
import tyut.selab.desktop.moudle.todolist.service.ITaskService;

import java.util.List;

public class TaskService implements ITaskService {
    private UserDao userDao;

    private TaskDao taskDao;

    @Override
    public List<TaskVo> queryAllTask(Integer studentNumber) {
        return null;
    }

    @Override
    public List<TaskVo> queryAllTaskByUserName(String name) {
        return null;
    }

    @Override
    public int insertTask(TaskVo task) {
        return 0;
    }

    @Override
    public int updateTask(TaskVo task) {
        return 0;
    }

    @Override
    public int deleteTask(TaskVo task) {
        return 0;
    }
}
