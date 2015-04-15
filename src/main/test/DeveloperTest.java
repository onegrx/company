/**
 * Created by onegrx on 08.04.15.
 */

import org.junit.Test;

import java.math.*;

import static org.fest.assertions.Assertions.*;



public class DeveloperTest {

    static final Developer developer = new Developer("John Doe", RoleInCompany.DEVELOPER, new BigDecimal("3000"));

    @Test
    public void responsibilityChainMustContainName() throws Exception {
        assertThat(developer.getResponsibilityChain()).contains(developer.getName());
    }

    @Test
    public void responsibilityChainEmptyForUnemployed() throws Exception {
        assertThat(developer.getResponsibilityChain()).doesNotContain("<-");
    }

    @Test
    public void descriptionIsCorrect() throws Exception {
        final String s = "Name: " + developer.getName() +", Role: " + developer.getRole() + ", Subordinate employees: 0";
        assertThat(developer.getDescription()).isEqualTo(s);
    }
}
