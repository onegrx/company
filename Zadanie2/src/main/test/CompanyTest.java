/**
 * Created by onegrx on 05.04.15.
 */

import org.junit.Test; //is it essential, what with annotation @test
//Can I mix 2 testing frameworks?

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.mock;

public class CompanyTest {

    @Test
    public void companySingletonCanBeOnlyOne() throws Exception {
        Company company = Company.getInstance();
        assertThat(company).isNotNull();
        assertThat(company).isInstanceOf(Company.class);
        Company otherCompany = Company.getInstance();
        assertThat(otherCompany).isSameAs(company);
    }

    @Test
    public void mainCeoIsUnique() throws Exception {
        Manager manager = mock(Manager.class);
        Manager otherManager = mock(Manager.class);
        Company company = Company.getInstance();
        company.hireCEO(manager);
        company.hireCEO(otherManager);
        assertThat(company.getCEO()).isSameAs(manager);
        assertThat(company.getCEO()).isNotSameAs(otherManager);
    }
}
