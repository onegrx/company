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
    final static Color color = Color.BLUE;


    static final GroupManager gm = new GroupManager(name, role, salary, color, capacityHiring);
    static final Tester t =
            new Tester("Will Smith", RoleInCompany.TESTER, new BigDecimal("2500"), color);
    static final Developer d =
            new Developer("John Doe", RoleInCompany.DEVELOPER, new BigDecimal("4000"), color);


    @Test
    public void hiringSystemWorksProperly() throws Exception {

        assertThat(gm.getSupervisor()).isNull();

        assertThat(gm.canHire(d)).isTrue();
        assertThat(gm.canHire(t)).isTrue();
        gm.hire(d);
        gm.hire(d);
        assertThat(gm.canHire(t)).isTrue();
        assertThat(gm.getHiringStrategy().canHire(gm, t)).isTrue();


        gm.hire(t);
        assertThat(gm.canHire(d)).isFalse();
        assertThat(gm.canHire(t)).isFalse();

        assertThat(t.getSupervisor()).isEqualTo(d.getSupervisor()).isInstanceOf(GroupManager.class);
    }

}