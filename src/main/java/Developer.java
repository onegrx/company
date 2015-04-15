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

    //public String toString() {
    //    return "Developer: " + getName() + " ";
    //}
}


