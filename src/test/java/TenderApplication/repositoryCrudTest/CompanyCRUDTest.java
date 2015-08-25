package TenderApplication.repositoryCrudTest;

import TenderApplication.Domain.Company;
import TenderApplication.Domain.Manager;
import TenderApplication.TenderApplication;
import TenderApplication.config.factory.CompanyFactory;
import TenderApplication.config.factory.ManagerFactory;
import TenderApplication.repository.CompanyRepo;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by student on 2015/08/06.
 */
@SpringApplicationConfiguration(classes = {TenderApplication.class})
@WebAppConfiguration
public class CompanyCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private CompanyRepo repo;

    @Test
    public void create() throws Exception
    {
        List<Manager> managers = new ArrayList<Manager>();
        Company company = CompanyFactory.createCompany("tradings", "1241245125", managers);

        repo.save(company);
        id = company.getCompanyNo();
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods ="create")
    public void read() throws Exception {

        Company company = (Company)this.repo.findOne(this.id);
        Assert.assertNotNull(id);
        Assert.assertEquals("1241245125", company.getTaxclarance());
    }

    @Test(dependsOnMethods ="read")
    public void update() throws Exception {

        Company hr = (Company)this.repo.findOne(this.id);
        Company newHR =  new Company.Builder(hr.getName()).copy(hr).taxclarance("DESA1241").build();
        this.repo.save(newHR);
        Company company = (Company)this.repo.findOne(this.id);
        Assert.assertEquals("DESA1241", company.getTaxclarance());
    }

    @Test(dependsOnMethods ="update")
    public void delete() throws Exception {

        Company hr = (Company)this.repo.findOne(this.id);
        this.repo.delete(hr);
        Company deleteHR = (Company)this.repo.findOne(this.id);
        Assert.assertNull(deleteHR);
    }
}
