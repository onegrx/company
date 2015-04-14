/**
 * Created by onegrx on 08.04.15.
 */

import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class IntegrationTestIT {

    final Developer d = new Developer("John Doe", RoleInCompany.DEVELOPER);
    final Tester t = new Tester("Will Smith", RoleInCompany.TESTER);
    final GroupManager gm = new GroupManager("Tom Unknown", RoleInCompany.GROUP_MANAGER, 2);

    @Test
    public void hiringSystemWorksProperly() throws Exception {
        assertThat(gm.canHire()).isTrue();
        gm.hire(d);
        gm.hire(d);
        assertThat(gm.canHire()).isTrue();
        assertThat(gm.getSupervisor()).isNull();
        gm.hire(t);
        assertThat(gm.canHire()).isFalse();
        assertThat(d.getSupervisor()).isInstanceOf(GroupManager.class);
        assertThat(t.getSupervisor()).isInstanceOf(GroupManager.class);
        assertThat(t.getSupervisor()).isEqualTo(d.getSupervisor());
    }
}
