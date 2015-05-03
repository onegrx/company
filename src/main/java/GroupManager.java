import java.math.*;
import java.util.*;
import java.util.function.*;

/**
 * Created by onegrx on 02.04.15.
 */
public class GroupManager extends AbstractEmployee implements Manager {

    private final List<Employee> employees = new ArrayList<Employee>();
    private final HiringStrategy hiringStrategy;

    public GroupManager(String name, RoleInCompany role, BigDecimal salary, Color color,
                        HiringStrategy hiringStrategy) {

        super(name, role, salary, color);
        this.hiringStrategy = hiringStrategy;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for(Employee e: employees) {
            e.accept(visitor);
        }
    }

    @Override
    public boolean canHire(Employee e) {
        if(employees.contains(e)) {
            return false;
        }
        return this.hiringStrategy.canHire(this, e);
    }

    @Override
    public void hire(Employee e) {
        if (employees.contains(e)) {
            System.out.println(e.getName() + " is already hired");
            return;
        }
        if (!hiringStrategy.canHire(this, e)) {
            System.out.println(e.getName() + "cannot be hired.");
            return;
        }

        hiringStrategy.hire(this, e);
        e.setSupervisor(this);
        employees.add(e);
        System.out.println(getName() + " is now hiring " + e.getName());

    }

    @Override
    public void fire(Employee e) {
        if(employees.contains(e) && e.getSupervisor() == this) {
            employees.remove(e);
            System.out.println(e.getName() + " has just been fired by " + getName());
            hiringStrategy.fire(this, e);
            e.setSupervisor(null);
        }
    }

    @Override
    public String work() {

        StringBuilder workDescription = new StringBuilder();


        if(employees.size() == 0) {
            workDescription.append(getName()).append(", ").append(getRole());
            workDescription.append("Manager is not hiring anyone.");
            return workDescription.toString();
        }

        workDescription.append(getName().toUpperCase()).append("'S TEAM:");
        StringBuilder employeesWorkGrpah = new StringBuilder();
        for (Employee e : employees) {
            employeesWorkGrpah.append("\n");
            employeesWorkGrpah.append("=> ").append(e.work());
        }

        workDescription.append(employeesWorkGrpah.toString().replace("\n", "\n\t"));
        return workDescription.toString();

    }

    @Override
    public String getDescription() {
        return "Name: " + getName() + ", Role: " + getRole() + ", Hiring: " + employees.size();
    }

    public HiringStrategy getHiringStrategy() {
        return hiringStrategy;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Iterator<Employee> iterator() {
        return Collections.unmodifiableList(employees).iterator();
    }


}

