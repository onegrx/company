import java.math.*;

/**
 * Created by onegrx on 04.04.15.
 */
public class Main {
    public static void main(String[] args) {

        Company company = Company.getInstance();
        GroupManager Steve = new GroupManager("Steve", RoleInCompany.CEO, new BigDecimal("30000"),
                Color.BLUE, new HiringByCapacity(5));
        company.hireCEO(Steve);

        GroupManager Alan = new GroupManager("Alan", RoleInCompany.GROUP_MANAGER, new BigDecimal("20000"),
                Color.BROWN, new HiringByBudget(new BigDecimal(50000)));
        GroupManager Richard = new GroupManager("Richard", RoleInCompany.GROUP_MANAGER, new BigDecimal("10000"),
                Color.GREEN, new HiringByCapacity(20));

        final int quantity = 4;
        Employee[] employees = new Employee[quantity];
        employees[0] = new Developer("Jack", RoleInCompany.DEVELOPER, new BigDecimal("3000"), Color.BROWN);
        employees[1] = new Developer("Mark", RoleInCompany.DEVELOPER, new BigDecimal("2000"), Color.BLUE);
        employees[2] = new Tester("Tom", RoleInCompany.TESTER, new BigDecimal("2500"), Color.GREY);
        employees[3] = new Tester("Bill", RoleInCompany.TESTER, new BigDecimal("1500"), Color.BROWN);

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

        System.out.println(Alan.work());
        System.out.println(Richard.work());
        System.out.println(employees[0].work());

    }


}
