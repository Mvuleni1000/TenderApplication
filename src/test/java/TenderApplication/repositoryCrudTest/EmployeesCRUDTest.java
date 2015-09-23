package TenderApplication.repositoryCrudTest;

import TenderApplication.Domain.Address;
import TenderApplication.Domain.Employees;
import TenderApplication.config.factory.AddressFactory;
import TenderApplication.config.factory.EmployeesFactory;
import TenderApplication.repository.EmployeesRepo;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by student on 2015/08/12.
 */
//@SpringApplicationConfiguration(classes = TenderApplication.class)
//@WebAppConfiguration
public class EmployeesCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    EmployeesRepo repo;

    //@Test
    public void create() throws Exception {

        Address address = AddressFactory.createAdress(554, 2151, "Dorset", "woodstock");
        Employees employees = EmployeesFactory.createEmployee("Comfort","Mdaka","0720375936",address);
        repo.save(employees);
        id= employees.getEmployeeID();
        Assert.assertNotNull(id);
    }

   // @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Employees employees = (Employees)this.repo.findOne(this.id);
        Assert.assertNotNull(employees);
        Assert.assertEquals("Comfort", employees.getFirstname());
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Employees hr = (Employees)this.repo.findOne(this.id);
        Employees newHR =  new Employees.Builder(hr.getFirstname()).copy(hr).lastname("Mahlalela").build();
        this.repo.save(newHR);
        Employees updateHR = (Employees)this.repo.findOne(this.id);
        Assert.assertEquals("Mahlalela", updateHR.getLastname());
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {

        Employees hr = (Employees)this.repo.findOne(this.id);
        this.repo.delete(hr);
        Employees deleteHR = (Employees)this.repo.findOne(this.id);
        Assert.assertNull(deleteHR);
    }
}
