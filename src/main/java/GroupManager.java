import java.util.ArrayList;
import java.util.List;

/**
 * Created by onegrx on 02.04.15.
 */
public class GroupManager implements Manager {

    private final String name;
    private final RoleInCompany role;
    private List<Employee> employees; //not sure about syntax = new ArrayList<>();
    private final int numberOfPossibleWorkers;
    private Manager supervisor;

    public GroupManager(String name, RoleInCompany role, int numberOfPossibleWorkers) {

        this.name = name;
        this.role = role;
        this.numberOfPossibleWorkers = numberOfPossibleWorkers;

        this.employees = new ArrayList<Employee>();
        //should I use ArrayList<>();

    }

    public void hire(Employee e) {
        if(canHire()) {
            if(employees.contains(e)) {
                System.out.println(e.getName() + " is already hired");
            }
            else {
                e.setSupervisor(this);
                employees.add(e);
                System.out.println(getName() + " is now hiring " + e.getName());
            }
        }
        else {
            System.out.println(getName() + "cannot hire more employees.");
        }
    }

    public void fire(Employee e) {
        if(employees.contains(e)) {
            employees.remove(e);
            System.out.println(e.getName() + " has just been fired by " + getName());
        }
    }

    public boolean canHire() {
        return employees.size() < numberOfPossibleWorkers;
    }

    public String work() {

        StringBuilder workDescription = new StringBuilder();


        if(employees.size() == 0) {
            workDescription.append(getName()).append(", ").append(getRole());
            workDescription.append("Manager is not hiring anyone.");
            return workDescription.toString();
        }

        workDescription.append("\n");
        workDescription.append(getName().toUpperCase()).append("'S TEAM:");
        StringBuilder employeesWorkGrpah = new StringBuilder();
        for (Employee e : employees) {
            employeesWorkGrpah.append("\n");
            employeesWorkGrpah.append("=> ").append(e.work());
        }

        workDescription.append(employeesWorkGrpah.toString().replace("\n", "\n\t"));
        return workDescription.toString();

    }

    public String getResponsibilityChain() {
        if(this.getSupervisor() != null) {
            return getSupervisor().getResponsibilityChain() + " <- " + getName();
        }
        return getName();
    }

    public String getDescription() {
        return "Name: " + getName() + ", Role: " + getRole() + ", Hiring: " + employees.size();
    }

    public int getNumberOfPossibleWorkers() {
        return numberOfPossibleWorkers;
    }

    public Manager getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
    }

    public String toString() {

        String s = "Group Manager: " + getName() + " ";
        return s;

    }

    public String getName() {
        return name;
    }

    public RoleInCompany getRole() {
        return role;
    }
}

