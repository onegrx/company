import java.math.*;

/**
 * Created by onegrx on 03.04.15.
 */
public abstract class AbstractEmployee implements Employee {

    private final String name;
    private final RoleInCompany role;
    private Manager supervisor;
    private BigDecimal salary;
    private Color eyeColor;

    public AbstractEmployee(String name, RoleInCompany role, BigDecimal salary, Color color) {
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.eyeColor = color;
    }

    @Override
    public String getResponsibilityChain() {
        if(getSupervisor() != null)
            return getSupervisor().getResponsibilityChain() + " <- " + getName();
        return getName();
    }

    //
    @Override
    public String getDescription() {
        return  "Name: " + getName() +", Role: " + getRole();
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
        return this.getClass().getSimpleName() + " - " + this.getName() + " is doing something.";
    }

    public BigDecimal getSalary() {
        return salary;
    }

}
