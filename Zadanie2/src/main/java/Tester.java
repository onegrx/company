/**
 * Created by onegrx on 03.04.15.
 */
public class Tester extends Worker {

    public Tester(String name, String role) {
        super(name, role);
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is testing software";
    }
}
