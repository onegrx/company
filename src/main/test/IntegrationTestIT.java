/**
 * Created by onegrx on 08.04.15.
 */

import org.junit.Test;
import java.math.*;
import static org.fest.assertions.Assertions.*;


public class IntegrationTestIT {

    static final String name = "Tom Unknown";
    static final RoleInCompany role = RoleInCompany.GROUP_MANAGER;
    static final BigDecimal salary = new BigDecimal("7000");
    static final int numOfWorkers = 2;
    static final HiringStrategy capacityHiring = new HiringByCapacity(numOfWorkers);
    static final Color color = Color.BLUE;


    @Test
    public void supervisorIsNotSetAtTheBeginning() throws Exception {

        //Given
        final GroupManager gm = new GroupManager(name, role, salary, color, capacityHiring);

        //Then
        assertThat((Employee)gm.getSupervisor()).isNull();
    }

    @Test
    public void managerWithPositiveCapacityCanHire() throws Exception {

        //Given
        final GroupManager gm = new GroupManager(name, role, salary, color, capacityHiring);
        final Tester t = new Tester(name, RoleInCompany.TESTER, new BigDecimal("2500"), color);
        final Developer d = new Developer(name, RoleInCompany.DEVELOPER, new BigDecimal("4000"), color);

        //Then
        assertThat(gm.canHire(d)).isTrue();
        assertThat(gm.canHire(t)).isTrue();
    }

    @Test
    public void managerCannotHireTwiceTheSamePerson() throws Exception {

        //Given
        final GroupManager gm = new GroupManager(name, role, salary, color, capacityHiring);
        final Tester t = new Tester(name, RoleInCompany.TESTER, new BigDecimal("2500"), color);
        final Developer d = new Developer(name, RoleInCompany.DEVELOPER, new BigDecimal("4000"), color);

        //When
        gm.hire(d);
        gm.hire(d);

        //Then
        assertThat(gm.canHire(t)).isTrue();
        assertThat(gm.getHiringStrategy().canHire(gm, t)).isTrue();

    }

    @Test
    public void managerCannotHireMoreThanCapacity() throws Exception {

        //Given
        final GroupManager gm = new GroupManager(name, role, salary, color, capacityHiring);
        final Tester t = new Tester(name, RoleInCompany.TESTER, new BigDecimal("2500"), color);
        final Developer d = new Developer(name, RoleInCompany.DEVELOPER, new BigDecimal("4000"), color);

        //When
        gm.hire(d);
        gm.hire(t);

        //The
        assertThat(gm.canHire(d)).isFalse();
        assertThat(gm.canHire(t)).isFalse();

    }

    @Test
    public void managerIsTheSameForHisSubordinates() throws Exception {

        //Given
        final GroupManager gm = new GroupManager(name, role, salary, color, capacityHiring);
        final Tester t = new Tester(name, RoleInCompany.TESTER, new BigDecimal("2500"), color);
        final Developer d = new Developer(name, RoleInCompany.DEVELOPER, new BigDecimal("4000"), color);

        //When
        gm.hire(d);
        gm.hire(t);

        //Then
        assertThat((Employee) t.getSupervisor()).isEqualTo(d.getSupervisor());

    }
}