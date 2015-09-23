package TenderApplication.serviceTest;

import TenderApplication.Domain.Contracts;
import TenderApplication.Domain.Department;
import TenderApplication.config.factory.ContractFactory;
import TenderApplication.config.factory.DepartmentFactory;
import TenderApplication.repository.DepartmentRepo;
import TenderApplication.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/17.
 */

//@SpringApplicationConfiguration(classes = TenderApplication.class)
//@WebAppConfiguration
public class DepartmentSercviceTest extends AbstractTestNGSpringContextTests {



    private Long id;

    @Autowired
    DepartmentService serivce;

    @Autowired
    DepartmentRepo repo;

    List<Contracts> availableContractor;


   // @BeforeMethod
    public void setUp() throws Exception {
        availableContractor = new ArrayList<>();
    }

   // @Test
    public void create() throws Exception {


       Contracts contracts1 = ContractFactory.createContracts("Agriculture","372AFG");
        Contracts contracts2 = ContractFactory.createContracts("Sports and Recreation","3ehG");
        Contracts contracts3 = ContractFactory.createContracts("Transport and Cars","3AFG");

        availableContractor.add(contracts1);
        availableContractor.add(contracts2);
        availableContractor.add(contracts3);

        Department d = DepartmentFactory
                .createDepartment("Human Resource", "Mvuleni", availableContractor);
        repo.save(d);
        id = d.getDepartmentNo();
        Assert.assertNotNull(id);

    }

   // @Test(dependsOnMethods = "create")
    public void read()throws Exception
    {
        Department d = serivce.findById(id);
        Assert.assertEquals("Mvuleni",d.getFounder());
    }

   // @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Department d= serivce.findById(id);
        Department newDepartment = new Department
                .Builder("ABA")
                .foundedBy("Mvuleni")
                .contractID(availableContractor)
                .copy(d)
                .build();

        serivce.update(newDepartment);
        Department updatedDepartment = serivce.findById(id);
        org.junit.Assert.assertEquals("Mvuleni", updatedDepartment.getFounder());
    }

   // @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Department d = serivce.findById(id);
        serivce.delete(d);
        Department deletedUser = serivce.findById(id);
        org.junit.Assert.assertNull(deletedUser);
    }


    /*@Test
    public void testCompanyRegistered() throws Exception {
        List<Contracts> contractses = serivce.getContractor(id);
        Assert.assertFalse(contractses.size() == 2);
    }*/

}
