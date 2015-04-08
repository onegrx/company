import java.util.ArrayList;
import java.util.List;

/**
 * Created by onegrx on 02.04.15.
 */
public class GroupManager implements Manager {

    private final String name;
    private String role;
    private List<Employee> employees; //not sure about syntax = new ArrayList<>();
    private int numberOfPossibleWorkers;
    private Manager supervisor;

    public GroupManager(String name, String role, int numberOfPossibleWorkers) {

        this.name = name;
        this.role = role;
        this.numberOfPossibleWorkers = numberOfPossibleWorkers;

        this.employees = new ArrayList<Employee>(); //<>

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

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String work() {

        StringBuilder workDescription = new StringBuilder();
        if(employees.size() == 0) {
            workDescription.append(getName()).append(", ").append(getRole());
            workDescription.append("Manager is not hiring anyone.");
        }
        else {
            workDescription.append("\n").append(getName().toUpperCase()).append("'S TEAM:");
            for (Employee e : employees) {
                workDescription.append("\n");
                workDescription.append("=> ").append(e.toString());
            }
        }

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
}
