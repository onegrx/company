import java.util.*;

/**
 * Created by onegrx on 04.05.15.
 */
public class CompanyIterator implements Iterator<Employee> {

    private Stack<Iterator<Employee>> iterators = new Stack<>();
    private Employee employeeNext;

    @Override
    public boolean hasNext() {
        if(employeeNext == null) {
            return false;
        }
        return true;
    }

    @Override
    public Employee next() {
        if(hasNext()) {

        }
        return null;
    }
}
