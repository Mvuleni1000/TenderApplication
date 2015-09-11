package TenderApplication.serviceTest;

import TenderApplication.Domain.Contracts;
import TenderApplication.Domain.Department;
import TenderApplication.Domain.HRDepartment;
import TenderApplication.Domain.Office;
import TenderApplication.TenderApplication;
import TenderApplication.config.factory.DepartmentFactory;
import TenderApplication.config.factory.HRDepartmentFactory;
import TenderApplication.config.factory.OfficeFactory;
import TenderApplication.repository.OfficeRepo;
import TenderApplication.services.OfficeService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/26.
 */
@SpringApplicationConfiguration(classes = TenderApplication.class)
@WebAppConfiguration
public class OfficeServiceTest  extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    OfficeService service;
    @Autowired
    OfficeRepo repo;
    private List<HRDepartment>hrDepartments;
    private List<Department>departments;
    List<Contracts> contract = new ArrayList<>();

    @BeforeMethod
    public void setUp() throws Exception {
        hrDepartments = new ArrayList<>();
        departments   = new ArrayList<>();

    }

    @Test
    public void create() throws Exception {

        HRDepartment hr1 = HRDepartmentFactory.createHRDepartment("14 street","Paarl Avenue");
        HRDepartment hr2 = HRDepartmentFactory.createHRDepartment("10th Plein","Cape Town");
        hrDepartments.add(hr1);
        hrDepartments.add(hr2);

        Department department1 = DepartmentFactory.createDepartment("Farming", "Vegetables",contract);
        Department department2 = DepartmentFactory.createDepartment("Engineering", "Motor Mechanics",contract);
        departments.add(department1);
        departments.add(department2);

        Office office = OfficeFactory.createAdim("Science", "Main Mall", departments, hrDepartments);
        repo.save(office);
        id= office.getadminNo();
    }

  //  @Test
   // public void testServices() throws Exception {

        //List<HRDepartment>hrDepartments1 = service.getHRDepartments(id);
        // Assert.assertNotNull(hrDepartments.size() == 2);

    //}
}
