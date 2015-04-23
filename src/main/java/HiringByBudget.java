import java.math.*;

/**
 * Created by onegrx on 16.04.15.
 */

public class HiringByBudget implements HiringStrategy {

    public HiringByBudget(BigDecimal budget) {
        this.budget = budget;
        this.currentBudget = budget;
    }

    private final BigDecimal budget;
    private BigDecimal currentBudget;

    @Override
    public boolean canHire(Manager manager, Employee employee) {

        if(employee.getSupervisor() == manager) {
            return false;
        }

        return (currentBudget.compareTo(employee.getSalary()) >= 0);
    }

    @Override
    public void hire(Manager manager, Employee employee) {
        if(canHire(manager, employee)) {
            currentBudget = currentBudget.subtract(employee.getSalary());
        }
    }

    @Override
    public void fire(Manager manager, Employee employee) {
        if(employee.getSupervisor() == manager) {
            currentBudget = currentBudget.add(employee.getSalary());
        }
    }

    @Override
    public String toString() {
        return "Hiring based on budget.";
    }

}
