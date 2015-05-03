import java.util.*;

/**
 * Created by onegrx on 03.05.15.
 */
public class CompanyStructureVisitor implements Visitor {

    private final Map<Employee, Integer> structure = new LinkedHashMap<Employee, Integer>();

    @Override
    public void visit(Employee e) {
        int depth = 0;
        if(e.getSupervisor() != null) {
            depth = structure.get(e.getSupervisor()) + 1;
        }
        structure.put(e, depth);
    }

    public String printCompanyStructure() {
        StringBuilder builder = new StringBuilder();

        for(Map.Entry<Employee, Integer> entry: structure.entrySet()) {
            for(int i = 0; i < entry.getValue(); ++i) {
                builder.append("\t");
            }
            Employee e = entry.getKey();
            builder.append(e.getName() + " : " + e.getRole() + "\n");
        }

        return builder.toString();
    }
}