import java.math.*;

/**
 * Created by onegrx on 03.04.15.
 */
public class Tester extends AbstractEmployee {

    public Tester(String name, RoleInCompany role, BigDecimal salary, Color color) {
        super(name, role, salary, color);
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is testing software";
    }

    @Override
    public String getDescription() {
        return  "Name: " + getName() +", Role: " + getRole() + ", Subordinate employees: 0";
    }
}
