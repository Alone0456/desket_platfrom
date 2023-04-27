package tyut.selab.desktop.moudle.todolist.dao.impl;

import tyut.selab.desktop.moudle.todolist.dao.ITaskDao;
import tyut.selab.desktop.moudle.todolist.domain.Task;
import tyut.selab.desktop.moudle.todolist.domain.vo.TaskVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDao extends baseDao implements ITaskDao {
    public TaskDao() throws SQLException {
    }


    @Override
    public List<Task> queryAllTask(Integer studentNumber) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        ArrayList<Task> task = query(Task.class, "SELECT  task_id AS taskId ,\n" +
                "\tuser_student_number AS userStudentNumber , \n" +
                "\ttask_content AS taskContent,\n" +
                "\ttask_start_time AS taskStartTime,\n" +
                "\ttask_end_time AS taskEndTime\n" +
                "\tFROM user_tasks_list \n" +
                "\tWHERE user_Student_Number=?;", studentNumber);

        return task;
    }


//    @Override
//    public List<Task> queryAllTaskByUserName(String name) {
//        return null;
//    }


    public int insertTask(Task task) throws SQLException {
        Task task1 = new Task();
        int len = executeUpdate("INSERT INTO user_tasks_list (\n" +
                "\t user_student_number,\n" +
                "\t task_content,\n" +
                "\t task_start_time,\n" +
                "\t task_end_time)\n" +
                "\t VALUES (?,?,?,?);", task.getUserStudentNumber(), task.getTaskContent(),
                task1.MyToString(task.getTaskStartTime()), task1.MyToString(task.getTaskEndTime()));

        return 0;
    }



    @Override
    public int updateTask(Task newTask, Task oldTask) throws SQLException {
        int i = executeUpdate("UPDATE  user_tasks_list\n" +
                        "SET \n" +
                        "task_id=?,\n" +
                        "user_student_number=?,\n" +
                        "task_content=?,\n" +
                        "task_start_time=?,\n" +
                        "task_end_time=?\n" +
                        "WHERE\n" +
                        "task_id=?;", newTask.getTaskId(), newTask.getUserStudentNumber(),
                newTask.getTaskContent(), newTask.getTaskStartTime(), newTask.getTaskEndTime(), oldTask.getTaskId());
        return 0;
    }

    @Override
    public int deleteTask(Task task) throws SQLException {
        int i = executeUpdate("DELETE FROM user_tasks_list\n" +
                "WHERE task_id=?;\n", task.getTaskId());
        return 0;
    }
}
