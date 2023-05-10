package tyut.selab.desktop.moudle.todolist.service.impl;

import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.todolist.dao.ITaskDao;
import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;
import tyut.selab.desktop.moudle.todolist.service.ITaskService;

import java.util.List;

public class TaskService implements ITaskService {
    private IUserDao userDao;

    private ITaskDao taskDao;


    @Override
    public void taskWarnTime(TaskVo taskVo) {

    }

    @Override
    public List<TaskVo> queryAllTask(Integer studentNumber) {
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
