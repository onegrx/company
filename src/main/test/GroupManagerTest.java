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

    final static GroupManager manager = new GroupManager(name, role, salary, numOfWorkers, budget);

    @Test
    public void rightValuesForGroupManager() throws Exception {

        String receivedName = manager.getName();
        RoleInCompany receivedRole = manager.getRole();
        String receivedDescription = manager.getDescription();
        int receivedCapacity = manager.getNumberOfPossibleWorkers();

        assertThat(receivedName).isEqualTo(name);
        assertThat(receivedRole).isEqualTo(role);
        //assertThat(receivedDescription).contains(name).contains(role);
        assertThat(receivedCapacity).isEqualTo(numOfWorkers);

    }

    @Test
    public void hiringAndFiringWorksProperly() throws Exception {

        Employee person1 = mock(Employee.class);
        Employee person2 = mock(Developer.class);
        Employee person3 = mock(Tester.class);

        assertThat(manager.canHire()).isTrue();
        manager.hire(person1);
        manager.hire(person2);
        manager.hire(person3);
        assertThat(manager.canHire()).isFalse();
        manager.fire(person3);
        assertThat(manager.canHire()).isTrue();
        manager.fire(person3);

    }

    @Test
    public void hiringWorksAsItShould() throws Exception {
        GroupManager gm = new GroupManager("John Doe", RoleInCompany.GROUP_MANAGER, new BigDecimal("5000"),
                1, new BigDecimal("8000"));
        Developer developer = mock(Developer.class);
        gm.hire(developer);
        verify(developer).setSupervisor(gm);
    }


}
