package TenderApplication.repositoryCrudTest;

import TenderApplication.Domain.Department;
import TenderApplication.Domain.HRDepartment;
import TenderApplication.Domain.Office;
import TenderApplication.config.factory.OfficeFactory;
import TenderApplication.repository.OfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
//@SpringApplicationConfiguration(classes = TenderApplication.class)
//@WebAppConfiguration
public class OfficeCRUDTest  extends AbstractTestNGSpringContextTests {
    
    private Long id;
    
    @Autowired
    OfficeRepo repo;


   // @Test
    public void create() throws Exception {
        List<Department> departments = new ArrayList<Department>();
        List<HRDepartment>hrDepartments = new ArrayList<HRDepartment>();
        Office office = OfficeFactory.createAdim("Science","Main Mall",departments,hrDepartments);
        repo.save(office);
        id= office.getadminNo();
    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Office office = (Office)this.repo.findOne(this.id);
        Assert.assertNotNull(id);
        Assert.assertEquals("Main Mall", office.getStationNo());
    }

   // @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Office hr = (Office)this.repo.findOne(this.id);
        Office newHR =  new Office.Builder(hr.getDocument()).station("mnisi").copy(hr).build();
        this.repo.save(newHR);
        Office updateHR = (Office)this.repo.findOne(this.id);
        Assert.assertNull(null, updateHR.getStationNo());
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {

        Office hr = (Office)this.repo.findOne(this.id);
        this.repo.delete(hr);
        Office deleteHR = (Office)this.repo.findOne(this.id);
        Assert.assertNull(deleteHR);
    }
}
