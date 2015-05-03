import java.math.*;

/**
 * Created by onegrx on 03.04.15.
 */
public class Developer extends AbstractEmployee {

    public Developer(String name, RoleInCompany role, BigDecimal salary, Color color) {
        super(name, role, salary, color);
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is creating new features";
    }

}


