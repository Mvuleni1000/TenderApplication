package TenderApplication.repositoryCrudTest;

/**
 * Created by student on 2015/08/12.
 */

import TenderApplication.Domain.*;
import TenderApplication.config.factory.AddressFactory;
import TenderApplication.config.factory.TenderHeadFactory;
import TenderApplication.repository.TenderHeadRepo;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.ArrayList;
import java.util.List;


//@SpringApplicationConfiguration(classes = TenderApplication.class)
//@WebAppConfiguration
public class TenderHeadCRUD extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    TenderHeadRepo repo;


    //@Test
    public void create() throws Exception {

        Address address = AddressFactory.createAdress(121, 2151, "Dorset", "woodstock");
        List<Users> workers              = new ArrayList<Users>();
        List<Employees> employeesList= new ArrayList<Employees>();
        List<Office> offices= new ArrayList<Office>();

        TenderHeadOffice tenderHeadOffice =TenderHeadFactory.createOffice("HeadOffice", "RSA", address, workers, employeesList, offices);

        repo.save(tenderHeadOffice);
        id = tenderHeadOffice.getTenderHeadOffice();
        Assert.assertNotNull(id);
    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception {

        TenderHeadOffice head = (TenderHeadOffice)this.repo.findOne(this.id);
        Assert.assertNotNull(id);
        Assert.assertEquals("RSA", head.getState());
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception {

        TenderHeadOffice hr = (TenderHeadOffice)this.repo.findOne(this.id);
        TenderHeadOffice newHR =  new TenderHeadOffice.Builder(hr.getOfficeReg()).stateOFCountry("America").copy(hr).build();
        this.repo.save(newHR);
        TenderHeadOffice updateHR = (TenderHeadOffice)this.repo.findOne(this.id);
        Assert.assertNotNull(null, updateHR.getState());
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        TenderHeadOffice head = (TenderHeadOffice)this.repo.findOne(this.id);
        this.repo.delete(head);
        TenderHeadOffice deleteHR = (TenderHeadOffice)this.repo.findOne(this.id);
        Assert.assertNull(deleteHR);
    }
}
