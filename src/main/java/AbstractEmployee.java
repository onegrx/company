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
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    @Override
    public String getResponsibilityChain() {
        if(getSupervisor() != null)
            return getSupervisor().getResponsibilityChain() + " <- " + getName();
        return getName();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (" + this.role + ") "
                + " - " + this.getName() + " is doing something.";
    }

    @Override
    public String getDescription() {
        return  "Name: " + getName() +", Role: " + getRole() + ", Subordinate employees: 0";
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

    @Override
    public BigDecimal getSalary() {
        return salary;
    }

}
