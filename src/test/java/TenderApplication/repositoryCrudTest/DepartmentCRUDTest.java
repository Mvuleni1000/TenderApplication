package TenderApplication.repositoryCrudTest;

import TenderApplication.Domain.Contracts;
import TenderApplication.Domain.Department;
import TenderApplication.TenderApplication;
import TenderApplication.config.factory.DepartmentFactory;
import TenderApplication.repository.DepartmentRepo;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
@SpringApplicationConfiguration(classes = TenderApplication.class)
@WebAppConfiguration
public class DepartmentCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    DepartmentRepo repo;

    @Test
    public void create() throws Exception {
        List<Contracts> contract = new ArrayList<>();
        Department department = DepartmentFactory.createDepartment("Agriculture","Mr Smalls",contract);

        repo.save(department);
        id = department.getDepartmentNo();
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {

        Department depart = (Department)this.repo.findOne(this.id);
        Assert.assertNotNull(id);
        Assert.assertEquals("Mr Smalls", depart.getFounder());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Department hr = (Department)this.repo.findOne(this.id);
        Department newHR =  new Department.Builder(hr.getFounder()).copy(hr).foundedBy("Mnisi").build();
        this.repo.save(newHR);
        Department company = (Department)this.repo.findOne(this.id);
        Assert.assertEquals("Mnisi", company.getFounder());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {

        Department con = (Department)this.repo.findOne(this.id);
        this.repo.delete(con);
        Department department = (Department)this.repo.findOne(this.id);
        Assert.assertNull(department);
    }
}
