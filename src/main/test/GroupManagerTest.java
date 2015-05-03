/**
 * Created by onegrx on 05.04.15.
 */

import org.junit.Test;

import java.math.*;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;

public class GroupManagerTest {

    final static String name = "Alex";
    final static RoleInCompany role = RoleInCompany.GROUP_MANAGER;
    final static BigDecimal salary = new BigDecimal("7000");
    final static int numOfWorkers = 3;
    final static BigDecimal budget = new BigDecimal("10000");
    final static HiringStrategy capacityHiring = new HiringByCapacity(numOfWorkers);
    final static HiringStrategy budgetHiring = new HiringByBudget(budget);
    final static Color color = Color.BLUE;

    final static GroupManager managerCap = new GroupManager(name, role, salary, color, capacityHiring);
    final static GroupManager managerBud = new GroupManager(name, role, salary, color, budgetHiring);

    @Test
    public void rightValuesForGroupManager() throws Exception {

        String receivedName = managerCap.getName();
        RoleInCompany receivedRole = managerCap.getRole();
        String receivedDescription = managerCap.getDescription();
        String receivedBudStrategy = managerBud.getHiringStrategy().toString();
        assertThat(receivedBudStrategy).isEqualTo("Hiring based on budget.").doesNotContain("capacity");
        assertThat(receivedDescription).contains("Name: " + name);
        assertThat(receivedName).isEqualTo(name);
        assertThat(receivedRole).isEqualTo(role);
    }

    @Test
    public void hiringAndFiringWorksProperlyCapacityStrategy() throws Exception {

        Employee person1 = mock(Employee.class);
        Employee person2 = mock(Developer.class);
        Employee person3 = mock(Tester.class);

        assertThat(managerCap.canHire(person1)).isTrue();
        managerCap.hire(person1);
        assertThat(managerCap.canHire(person2)).isTrue();
        managerCap.hire(person2);
        assertThat(managerCap.canHire(person3)).isTrue();
        managerCap.hire(person3);
        assertThat(managerCap.getEmployees()).doesNotHaveDuplicates();
        assertThat(managerCap.getEmployees()).hasSize(3);
        verify(person1).setSupervisor(managerCap);
        verify(person2).setSupervisor(managerCap);
        verify(person3).setSupervisor(managerCap);
        assertThat(managerCap.canHire(person1)).isFalse();
        assertThat(managerCap.canHire(person2)).isFalse();
        assertThat(managerCap.canHire(person3)).isFalse();

        stub(person3.getSupervisor()).toReturn(managerCap);
        managerCap.fire(person3);
        assertThat(managerCap.getEmployees()).excludes(person3);
        assertThat(managerCap.getEmployees()).hasSize(2);


        verify(person1, times(1)).getName();
        verify(person3, times(2)).getName(); //because one more from firing
        verify(person3).setSupervisor(null);

        stub(person3.getSupervisor()).toReturn(null);

        assertThat(managerCap.getHiringStrategy().canHire(managerCap, person3)).isTrue();
        assertThat(managerCap.canHire(person3)).isTrue();

    }

    @Test
    public void hiringWorksAsItShould() throws Exception {
        final GroupManager gm = managerCap;
        Developer developer = mock(Developer.class);
        gm.hire(developer);
        verify(developer, times(1)).setSupervisor(gm);
    }

}
