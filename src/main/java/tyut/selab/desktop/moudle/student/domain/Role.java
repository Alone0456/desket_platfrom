package tyut.selab.desktop.moudle.student.domain;

public class Role {
    private String duty;

    public Role() {
    }

    public Role(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "Role{" +
                "duty='" + duty + '\'' +
                '}';
    }
}
