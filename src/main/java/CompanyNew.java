import java.util.*;

/**
 * Created by onegrx on 04.05.15.
 */
public class CompanyNew extends AbstractCollection<Employee>
        implements Visitable, Iterable<Employee> {

    private Manager CEO;

    public CompanyNew(Manager CEO) {
        this.CEO = CEO;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new CompanyIterator();
    }

    @Override
    public int size() {
        int size = 0;
        Iterator<Employee> it  = iterator();
        while(it.hasNext()) {
            size++;
            it.next();
        }
        return size;
    }

    @Override
    public void accept(Visitor visitor) {
        CEO.accept(visitor);
    }
}
