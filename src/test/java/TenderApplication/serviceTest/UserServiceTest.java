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
import org.aspectj.weaver.NameMangler;
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

    @BeforeMethod
    public void setUp() throws Exception {
        manager = new ArrayList<>();
        addCompanies = new ArrayList();
    }

    @Test
    public void create() throws Exception {
        Address address = AddressFactory.createAdress(3142, 1421, "Malelane", "Nelspruit");
        Manager manager1 = ManagerFactory.createManger("Mnisi Sibusiso");

        manager.add(manager1);

        Company company1 =CompanyFactory.createCompany("Sibusiso","dfgdfg",manager);
        Company company2 =CompanyFactory.createCompany("Mnisi","Constraction",manager);

        addCompanies.add(company1);
        addCompanies.add(company2);

        Users users = UsersFactory.createUser("1241", "0745333355", address, addCompanies);
        repo.save(users);
        id = users.getUserID();
        Assert.assertNotNull(id);

    }

    @Test
    public void testCompanyRegistered() throws Exception {

        List<Company> addCompanies = serivce.getUserCompany(id);


        Assert.assertTrue(addCompanies.size() == 2);
    }

}
