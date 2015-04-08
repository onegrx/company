/**
 * Created by onegrx on 08.04.15.
 */

import org.junit.Test;

import static org.fest.assertions.Assertions.*;
//import static org.mockito.Mockito.mock;


public class TesterTest {

    static final Tester tester = new Tester("John Doe", "tester");

    @Test
    public void responsibilityChainMustContainName() throws Exception {
        assertThat(tester.getResponsibilityChain()).contains(tester.getName());
    }

    @Test
    public void responsibilityChainEmptyForUnemployeed() throws Exception {
        assertThat(tester.getResponsibilityChain()).doesNotContain("<-");
    }

    @Test
    public void descriptionIsCorrect() throws Exception {
        final String s = "Name: " + tester.getName() +", Role: " + tester.getRole() + ", Subordinate employees: 0";
        assertThat(tester.getDescription()).isEqualTo(s);
    }

}
