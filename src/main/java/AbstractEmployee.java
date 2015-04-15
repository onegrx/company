import java.math.*;

/**
 * Created by onegrx on 03.04.15.
 */
public abstract class AbstractEmployee implements Employee {

    protected final String name;
    protected final RoleInCompany role;
    protected Manager supervisor;
    private BigDecimal salary;

    public AbstractEmployee(String name, RoleInCompany role, BigDecimal salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String getResponsibilityChain() {
        if(getSupervisor() != null)
            return getSupervisor().getResponsibilityChain() + " <- " + getName();
        return getName();
    }

    @Override
    public String getDescription() {
        final String s = "Name: " + getName() +", Role: " + getRole() + ", Subordinate employees: 0";
        return s;
    }

    @Override
    public String work() {
        return getName() + " " + getRole() + " is doing some work.";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RoleInCompany getRole() {
        return role;
    }

    @Override
    public Manager getSupervisor() {
        return supervisor;
    }

    @Override
    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " is doing something.";
    }


}
