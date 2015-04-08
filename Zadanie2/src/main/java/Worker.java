/**
 * Created by onegrx on 03.04.15.
 */
public abstract class Worker implements Employee {

    private final String name;
    private String role;
    private Manager supervisor;

    public Worker(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Worker(String name, String role, Manager supervisor) {
        this(name, role);
        this.supervisor = supervisor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String getResponsibilityChain() {
        return getSupervisor().getResponsibilityChain() + " <- " + getName();
    }

    @Override
    public String getDescription() {
        final String s = "Name: " + getName() +", Role: " + getRole() + ", Subordinate employees: 0";
        return s;
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
