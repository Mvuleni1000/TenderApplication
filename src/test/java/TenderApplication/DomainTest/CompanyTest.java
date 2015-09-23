package TenderApplication.DomainTest;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Manager;
import TenderApplication.config.factory.CompanyFactory;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class CompanyTest {

    private Long id;
    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void testcreate() throws Exception {

        List<Manager> managers = new ArrayList<Manager>();
        Company company = CompanyFactory.createCompany("tradings", "1241245125", managers);

        Assert.assertEquals("1241245125", company.getTaxclarance());
    }

    //@Test
    public void testUpdate() throws Exception {


        List<Manager>managers = new ArrayList<Manager>();
        Company company = CompanyFactory
                .createCompany("MVC","1",managers);

        Assert.assertEquals("1", company.getTaxclarance());

    }

    //@After
    public void tearDown() throws Exception {


    }
}
