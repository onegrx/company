/**
 * Created by onegrx on 03.04.15.
 */
public class Tester extends Worker {

    public Tester(String name, String role) {
        super(name, role);
    }

    public Tester(String name, String role, Manager supervisor) {
        super(name, role, supervisor);
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is testing software";
    }
}
