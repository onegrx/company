/**
 * Created by onegrx on 03.04.15.
 */
public class Tester extends Worker {

    public Tester(String name, String role) {
        super(name, role);
    }

    @Override
    public String getDescription() {
        final String s = "Name: " + getName() +", Role: " + getRole() + ", Subordinate employees: 0";
        return s;
    }

    @Override
    public String getResponsibilityChain() {
        return getRole();
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is testing software";
    }
}
