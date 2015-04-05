/**
 * Created by onegrx on 04.04.15.
 */
public class Main {
    public static void main(String[] args) {

        Company company = Company.getInstance();
        GroupManager Steve = new GroupManager("Steve", "CEO", 10);
        company.hireCEO(Steve);

    }
}
