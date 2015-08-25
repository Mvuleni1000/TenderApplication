package TenderApplication.DomainTest;

import TenderApplication.Domain.Address;
import TenderApplication.Domain.Employees;
import TenderApplication.config.factory.AddressFactory;
import TenderApplication.config.factory.EmployeesFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/08/06.
 */
public class EmployeesTest {


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testName() throws Exception {

        Address address = AddressFactory.createAdress(554, 2151, "Dorset", "woodstock");

        Employees employees = EmployeesFactory
                .createEmployee("Sibusiso","Mnisi","07403759365", address );

        Assert.assertEquals("Mnisi", employees.getLastname());
    }

    @Test
    public void testUpdate() throws Exception {

        Address address = AddressFactory.createAdress(554, 2151, "Dorset", "woodstock");

        Employees employees = EmployeesFactory
                .createEmployee("Sibusiso", "Mvuleni", "074", address);

        Assert.assertEquals("Mvuleni", employees.getLastname());
    }

    @After
    public void tearDown() throws Exception {


    }
}
