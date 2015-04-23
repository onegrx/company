/**
 * Created by onegrx on 16.04.15.
 */
public class HiringByCapacity implements HiringStrategy{

    public final int numberOfPossibleWorkers;
    private int currentWorkers = 0;

    public HiringByCapacity(int numberOfPossibleWorkers) {
        this.numberOfPossibleWorkers = numberOfPossibleWorkers;
    }

    @Override
    public boolean canHire(Manager manager, Employee employee) {
        if(employee.getSupervisor() == manager) {
            return false;
        }
        else return(numberOfPossibleWorkers > manager.getEmployees().size());
    }

    @Override
    public void hire(Manager manager, Employee employee) {
        if(canHire(manager, employee)) {
            currentWorkers++;
        }
    }

    @Override
    public void fire(Manager manager, Employee employee) {
        if(employee.getSupervisor() == manager) {
            currentWorkers--;
        }
    }

    @Override
    public String toString() {
        return "Hiring based on capacity.";
    }

}
