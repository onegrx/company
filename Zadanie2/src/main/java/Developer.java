/**
 * Created by onegrx on 03.04.15.
 */
public class Developer extends Worker {

    public Developer(String name, String role) {
        super(name, role);
    }

    public Developer(String name, String role, Manager supervisor) {
        super(name, role, supervisor);
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is creating new features";
    }
}
