/**
 * Created by onegrx on 03.04.15.
 */
public abstract class AbstractEmployee implements Employee {

    private final String name;
    private final RoleInCompany role;
    private Manager supervisor;

    public AbstractEmployee(String name, RoleInCompany role) {
        this.name = name;
        this.role = role;
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


}
