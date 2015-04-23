/**
 * Created by onegrx on 05.04.15.
 */

import org.junit.Test;

import java.math.*;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GroupManagerTest {

    final static String name = "Alex";
    final static RoleInCompany role = RoleInCompany.GROUP_MANAGER;
    final static BigDecimal salary = new BigDecimal("7000");
    final static int numOfWorkers = 3;
    final static BigDecimal budget = new BigDecimal("10000");
    final static HiringStrategy capacityHiring = new HiringByCapacity(3);
    final static HiringStrategy budgetHiring = new HiringByBudget(budget);

    final static GroupManager managerCap = new GroupManager(name, role, salary, capacityHiring);
    final static GroupManager managerBud = new GroupManager(name, role, salary, budgetHiring);

    @Test
    public void rightValuesForGroupManager() throws Exception {

        String receivedName = managerCap.getName();
        RoleInCompany receivedRole = managerCap.getRole();
        //String receivedDescription = managerCap.getDescription();
        assertThat(receivedName).isEqualTo(name);
        assertThat(receivedRole).isEqualTo(role);
    }

    @Test
    public void hiringAndFiringWorksProperly() throws Exception {

        Employee person1 = mock(Employee.class);
        Employee person2 = mock(Developer.class);
        Employee person3 = mock(Tester.class);

        assertThat(managerCap.canHire(person1)).isTrue();
        managerCap.hire(person1);
        managerCap.hire(person2);
        managerCap.hire(person3);
        assertThat(managerCap.canHire(person1)).isFalse();
        assertThat(managerCap.canHire(person2)).isFalse();
        assertThat(managerCap.canHire(person3)).isFalse();

        managerCap.fire(person3);
        //assertThat(managerCap.canHire(person3)).isTrue();

    }

    @Test
    public void hiringWorksAsItShould() throws Exception {
        GroupManager gm = new GroupManager("John Doe", RoleInCompany.GROUP_MANAGER, new BigDecimal("5000"),
                new HiringByCapacity(1));
        Developer developer = mock(Developer.class);
        gm.hire(developer);
        verify(developer).setSupervisor(gm);
    }

}
