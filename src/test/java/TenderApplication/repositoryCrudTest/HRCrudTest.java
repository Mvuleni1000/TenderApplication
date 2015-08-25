package TenderApplication.repositoryCrudTest;

import TenderApplication.Domain.HRDepartment;
import TenderApplication.TenderApplication;
import TenderApplication.config.factory.HRDepartmentFactory;
import TenderApplication.repository.HRDepartmentRepo;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/08/12.
 */
@SpringApplicationConfiguration(classes = TenderApplication.class)
@WebAppConfiguration
public class HRCrudTest extends AbstractTestNGSpringContextTests {

    private Long hrid;

    @Autowired
    private HRDepartmentRepo repository;

    public HRCrudTest() {
    }

    @Test
    public void create() throws Exception {

        HRDepartment hrDepartment = HRDepartmentFactory.createHRDepartment("Sibusiso Mnisi", "11th Floor");
        repository.save(hrDepartment);
        hrid = hrDepartment.getHrNo();
        Assert.assertNotNull(hrid);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        HRDepartment hr = (HRDepartment)this.repository.findOne(this.hrid);
        Assert.assertNotNull(hr);
        Assert.assertEquals("11th Floor", hr.getBuilding());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        HRDepartment hr = (HRDepartment)this.repository.findOne(this.hrid);
        HRDepartment newHR =  new HRDepartment.Builder(hr.getBuilding()).copy(hr).buildingLocation("111th Floor").build();
        this.repository.save(newHR);
        HRDepartment updateHR = (HRDepartment)this.repository.findOne(this.hrid);
        Assert.assertEquals("111th Floor", updateHR.getBuilding());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {

        HRDepartment hr = (HRDepartment)this.repository.findOne(this.hrid);
        this.repository.delete(hr);
        HRDepartment deleteHR = (HRDepartment)this.repository.findOne(this.hrid);
        Assert.assertNull(deleteHR);

    }

}