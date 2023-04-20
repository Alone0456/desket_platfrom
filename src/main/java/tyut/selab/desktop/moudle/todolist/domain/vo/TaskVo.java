package tyut.selab.desktop.moudle.todolist.domain.vo;

import java.util.Date;

public class TaskVo {
    private Integer taskId;
    private Integer userStudentNumber;
    private String taskContent;
    private Date taskStartTime;
    private Date taskEndTime;

    public TaskVo() {
    }

    public TaskVo(Integer taskId, Integer userStudentNumber, String taskContent, Date taskStartTime, Date taskEndTime) {
        this.taskId = taskId;
        this.userStudentNumber = userStudentNumber;
        this.taskContent = taskContent;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
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

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
}

