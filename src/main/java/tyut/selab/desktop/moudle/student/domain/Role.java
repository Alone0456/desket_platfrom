package tyut.selab.desktop.moudle.student.domain;

public class Role {


    public Role(String duty) {
        this.duty = duty;
    }

    public Role() {

    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    private String duty;
}
