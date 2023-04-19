package tyut.selab.desktop.moudle.student.domain;

public class Role {
    private String duty;

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

