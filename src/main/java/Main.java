/**
 * Created by onegrx on 04.04.15.
 */
public class Main {
    public static void main(String[] args) {

        Company company = Company.getInstance();
        GroupManager Steve = new GroupManager("Steve", RoleInCompany.CEO, 10);
        company.hireCEO(Steve);

        GroupManager Alan = new GroupManager("Alan", RoleInCompany.GROUP_MANAGER, 3);
        GroupManager Richard = new GroupManager("Richard", RoleInCompany.GROUP_MANAGER, 2);

        final int quantity = 4;
        Employee[] employees = new Employee[quantity];
        employees[0] = new Developer("Jack", RoleInCompany.DEVELOPER);
        employees[1] = new Developer("Mark", RoleInCompany.DEVELOPER);
        employees[2] = new Tester("Tom", RoleInCompany.TESTER);
        employees[3] = new Tester("Bill", RoleInCompany.TESTER);

        //Let's do some work
        Steve.hire(Alan);
        Alan.hire(Richard);
        Alan.hire(employees[0]);
        Alan.hire(employees[3]);
        Richard.hire(employees[1]);
        Richard.hire(employees[2]);

        System.out.println(Steve.getDescription());
        System.out.println(Alan.getDescription());
        System.out.println(Richard.getDescription());
        for(Employee e : employees) {
            System.out.println(e.getDescription());
        }

        System.out.println("Jack's responsibility chain:");
        System.out.println(employees[0].getResponsibilityChain());

        System.out.println("Tom's responsibility chain:");
        System.out.println(employees[2].getResponsibilityChain());

    }
}
