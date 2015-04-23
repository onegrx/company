import java.util.*;

/**
 * Created by onegrx on 02.04.15.
 */
public interface Manager extends Employee {
    void hire(Employee e);
    void fire(Employee e);
    boolean canHire(Employee e);
    List<Employee> getEmployees();
}
