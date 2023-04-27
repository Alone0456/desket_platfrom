package tyut.selab.desktop.moudle.todolist.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Task {

    private Integer taskId;
    private Integer userStudentNumber;
    private String taskContent;
    private Date taskStartTime;
    private Date taskEndTime;

    public Task() {
    }

    public Task(Integer taskId) {
        this.taskId = taskId;
    }

    public Task(Integer taskId, Integer userStudentNumber, String taskContent, Date taskEndTime) {
        this.taskId = taskId;
        this.userStudentNumber = userStudentNumber;
        this.taskContent = taskContent;
        this.taskEndTime = taskEndTime;
        this.taskStartTime = new Date();
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getUserStudentNumber() {
        return userStudentNumber;
    }

    public void setUserStudentNumber(Integer userStudentNumber) {
        this.userStudentNumber = userStudentNumber;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime() {
        this.taskStartTime = new Date();
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
    public String MyToString(Date taskEndTime){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(taskEndTime);
        return strDate;

    }
}
