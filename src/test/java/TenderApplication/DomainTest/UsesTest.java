package TenderApplication.DomainTest;

import TenderApplication.Domain.Address;
import TenderApplication.Domain.Company;
import TenderApplication.Domain.Users;
import TenderApplication.config.factory.AddressFactory;
import TenderApplication.config.factory.UsersFactory;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class UsesTest {

    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void testCreate() throws Exception {

        Address address = AddressFactory
                .createAdress(554, 2151, "Dorset", "woodstock");
        List<Company> companies= new ArrayList<Company>();

        Users users = UsersFactory
                .createUser("FNAD1","0720375936",address,companies);
        Assert.assertEquals("0720375936", users.getContactDetails());
    }

   // @Test
    public void testUpdate() throws Exception {
        Address address = AddressFactory
                .createAdress(554, 2151, "Dorset", "woodstock");
        List<Company> companies= new ArrayList<Company>();
        Users users = UsersFactory
                .createUser("FNAD1","471425415",address,companies);
        Assert.assertEquals("471425415", users.getContactDetails());

    }

   // @After
    public void tearDown() throws Exception {


    }
}
