package TenderApplication.repositoryCrudTest;

import TenderApplication.Domain.Manager;
import TenderApplication.TenderApplication;
import TenderApplication.config.factory.ManagerFactory;
import TenderApplication.repository.ManagerRepo;
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
public class ManagerCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    ManagerRepo repo;

    @Test
    public void create() throws Exception {

        Manager manager = ManagerFactory.createManger("mvuleni");
        repo.save(manager);
        id = manager.getManagerID();
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
     public void read() throws Exception {

        Manager manager = (Manager)this.repo.findOne(this.id);
        //id = manager.getManagerID();
        Assert.assertNotNull(id);
        Assert.assertEquals(null, manager.getSurname());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Manager hr = (Manager)this.repo.findOne(this.id);
        Manager newHR =  new Manager.Builder(hr.getSurname()).copy(hr).build();
        this.repo.save(newHR);
        Manager updateHR = (Manager)this.repo.findOne(this.id);
        Assert.assertNull(null, updateHR.getSurname());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {

        Manager hr = (Manager)this.repo.findOne(this.id);
        this.repo.delete(hr);
        Manager deleteHR = (Manager)this.repo.findOne(this.id);
        Assert.assertNull(deleteHR);
    }
}
