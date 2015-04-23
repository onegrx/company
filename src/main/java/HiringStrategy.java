/**
 * Created by onegrx on 15.04.15.
 */
public interface HiringStrategy {
    boolean canHire(Manager manager, Employee employee);
    void hire(Manager manager, Employee employee);
    void fire(Manager manager, Employee employee);
    String toString();
}


