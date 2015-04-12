/**
 * Created by onegrx on 05.04.15.
 */

import org.junit.Test;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GroupManagerTest {

    final static String name = "Alex";
    final static String role = "manager";
    final static int size = 3;
    final static GroupManager manager = new GroupManager(name, role, size);

    @Test
    public void rightValuesForGroupManager() throws Exception {

        String receivedName = manager.getName();
        String receivedRole = manager.getRole();
        String receivedDescription = manager.getDescription();
        int receivedCapacity = manager.getNumberOfPossibleWorkers();

        assertThat(receivedName).isEqualTo(name);
        assertThat(receivedRole).isEqualTo(role);
        assertThat(receivedDescription).contains(name).contains(role);
        assertThat(receivedCapacity).isEqualTo(size);

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
        GroupManager gm = new GroupManager("John Doe", "manager", 1);
        Developer developer = mock(Developer.class);
        gm.hire(developer);
        verify(developer).setSupervisor(gm);
    }


}
