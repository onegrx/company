import java.math.*;

/**
 * Created by onegrx on 03.04.15.
 */
public class Developer extends AbstractEmployee {

    public Developer(String name, RoleInCompany role, BigDecimal salary) {
        super(name, role, salary);
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is creating new features";
    }

    @Override
    public String getDescription() {
        return  "Name: " + getName() +", Role: " + getRole() + ", Subordinate employees: 0";
    }

    

}


