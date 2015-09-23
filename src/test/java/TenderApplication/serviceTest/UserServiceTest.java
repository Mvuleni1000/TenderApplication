package TenderApplication.serviceTest;

import TenderApplication.Domain.Address;
import TenderApplication.Domain.Company;
import TenderApplication.Domain.Manager;
import TenderApplication.Domain.Users;
import TenderApplication.TenderApplication;
import TenderApplication.config.factory.AddressFactory;
import TenderApplication.config.factory.CompanyFactory;
import TenderApplication.config.factory.ManagerFactory;
import TenderApplication.config.factory.UsersFactory;
import TenderApplication.repository.UserRepo;
import TenderApplication.services.UserSerivce;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@SpringApplicationConfiguration(classes = TenderApplication.class)
@WebAppConfiguration
public class UserServiceTest extends AbstractTestNGSpringContextTests {


    private Long id;

    @Autowired
    UserSerivce serivce;

    @Autowired
    UserRepo repo;

    List<Company>addCompanies;
    List<Manager>manager;

   // @BeforeMethod
    public void setUp() throws Exception {
        manager = new ArrayList<>();
        addCompanies = new ArrayList();
    }

   // @Test
    public void create() throws Exception {
        Address address = AddressFactory.createAdress(3142, 1421, "Likazi", "Lowveld");
        Manager manager1 = ManagerFactory.createManger("Mhlanga Bongani");

        manager.add(manager1);

        Company company1 =CompanyFactory.createCompany("Bongumusa","Mnisi",manager);
        Company company2 =CompanyFactory.createCompany("Mnisi","Constraction",manager);

        addCompanies.add(company1);
        addCompanies.add(company2);

        Users users = UsersFactory.createUser("1241", "0745333355", address, addCompanies);
        repo.save(users);
        id = users.getUserID();
        Assert.assertNotNull(id);

    }


   // @Test(dependsOnMethods = "create")
    public void read()throws Exception
    {
        Users users = serivce.findById(id);
        Assert.assertEquals("0745333355", users.getContactDetails());

    }

   // @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Users users= serivce.findById(id);
        Users newUser = new Users
                .Builder("012 542 3652")
                .account("12")
                .address(users.getBuilding_address())
                .company(users.getCompany())
                .copy(users)
                .build();

        serivce.update(newUser);
        Users updatedUser = serivce.findById(id);
        Assert.assertEquals("0745333355",updatedUser.getContactDetails());
    }

   // @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Users users = serivce.findById(id);
        serivce.delete(users);
        Users deletedUser = serivce.findById(id);
        Assert.assertNull(deletedUser);
    }


   // @Test
    public void testCompanyRegistered() throws Exception {
        List<Company> addCompanies = serivce.getUserCompany(id);
        Assert.assertTrue(addCompanies.size() == 2);
    }

}
