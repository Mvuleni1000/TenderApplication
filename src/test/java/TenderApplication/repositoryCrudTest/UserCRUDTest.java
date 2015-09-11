package TenderApplication.repositoryCrudTest;

import TenderApplication.Domain.Address;
import TenderApplication.Domain.Company;
import TenderApplication.Domain.Users;
import TenderApplication.TenderApplication;
import TenderApplication.config.factory.AddressFactory;
import TenderApplication.config.factory.UsersFactory;
import TenderApplication.repository.UserRepo;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mnisi 072 0375936 on 2015/08/12.
 */

@SpringApplicationConfiguration(classes = TenderApplication.class)
@WebAppConfiguration
public class UserCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    UserRepo repo;


    @Test
    public void create() throws Exception {
        Address address = AddressFactory
                .createAdress(554, 2151, "Dorset", "woodstock");
        List<Company> companies= new ArrayList<Company>();
        Users users = UsersFactory.createUser("1241","0745333355",address,companies);
        repo.save(users);
        id = users.getUserID();
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Users head = (Users)this.repo.findOne(this.id);
        Assert.assertNotNull(id);
        Assert.assertEquals("0745333355", head.getContactDetails());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Users hr = (Users)this.repo.findOne(this.id);
        Users newHR =  new Users.Builder(hr.getContactDetails()).account("074ABF").copy(hr).build();
        this.repo.save(newHR);
        Users updateHR = (Users)this.repo.findOne(this.id);
        Assert.assertNotNull("074ABF", updateHR.getContactDetails());

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {

        Users user = (Users)this.repo.findOne(this.id);
        this.repo.delete(user);
        Users deleteHR = (Users)this.repo.findOne(this.id);
        Assert.assertNull(deleteHR);

    }
}
