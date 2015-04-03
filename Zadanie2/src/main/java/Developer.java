/**
 * Created by onegrx on 03.04.15.
 */
public class Developer extends Worker{

    public Developer(String name, String role) {
        super(name, role);
    }

    //Consider defining getDescription() upper, in Worker
    @Override
    public String getDescription() {
        final String s = "Name: " + getName() +", Role: " + getRole() + ", Subordinate employees: 0";
        return s;
    }

    //Consider defining getResponsibilityChain() upper, in Worker
    @Override
    public String getResponsibilityChain() {
        return getRole();
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is creating new features";
    }
}
