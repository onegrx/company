/**
 * Created by onegrx on 05.04.15.
 */

import org.junit.Test; //is it essential, what with annotation @test
//Can I mix 2 testing frameworks?

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.mock;

public class CompanyOldTest {

    @Test
    public void companySingletonCanBeOnlyOne() throws Exception {
        CompanyOld company = CompanyOld.getInstance();
        assertThat(company).isNotNull();
        assertThat(company).isInstanceOf(CompanyOld.class);
        CompanyOld otherCompany = CompanyOld.getInstance();
        assertThat(otherCompany).isSameAs(company);
    }

    @Test
    public void mainCeoIsUnique() throws Exception {
        Manager manager = mock(Manager.class);
        Manager otherManager = mock(Manager.class);
        CompanyOld company = CompanyOld.getInstance();
        company.hireCEO(manager);
        company.hireCEO(otherManager);


        assertThat((Employee)company.getCEO()).isSameAs(manager);
        assertThat((Employee)company.getCEO()).isNotSameAs(otherManager);

    }
}
